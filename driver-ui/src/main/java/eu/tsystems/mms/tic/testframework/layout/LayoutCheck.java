/*
 * Testerra
 *
 * (C) 2020, René Habermann, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
 *
 * Deutsche Telekom AG and all other contributors /
 * copyright owners license this file to you under the Apache
 * License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package eu.tsystems.mms.tic.testframework.layout;

import eu.tsystems.mms.tic.testframework.common.IProperties;
import eu.tsystems.mms.tic.testframework.common.PropertyManagerProvider;
import eu.tsystems.mms.tic.testframework.common.Testerra;
import eu.tsystems.mms.tic.testframework.exceptions.SystemException;
import eu.tsystems.mms.tic.testframework.execution.testng.NonFunctionalAssert;
import eu.tsystems.mms.tic.testframework.layout.reporting.LayoutCheckContext;
import eu.tsystems.mms.tic.testframework.report.Report;
import eu.tsystems.mms.tic.testframework.report.utils.ExecutionContextController;
import eu.tsystems.mms.tic.testframework.utils.AssertUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * Utility class for handling layout checking screenshots.
 *
 * @author mibu
 */
public final class LayoutCheck implements PropertyManagerProvider {

    public enum Properties implements IProperties {
        MODE("mode", "pixel"),
        TAKEREFERENCE("takereference", false),
        // if true, will use non-functional asserts
        //LAYOUTCHECK_ASSERT_INFO_MODE("assert.info.mode", null),
        REFERENCE_NAMETEMPLATE("reference.nametemplate", "Reference%s.png"),
        ANNOTATED_NAMETEMPLATE("annotated.nametemplate", "ReferenceAnnotated%s.png"),
        ANNOTATIONDATA_NAMETEMPLATE("annotationdata.nametemplate", "Reference%s_data.json"),
        ACTUAL_NAMETEMPLATE("actual.nametemplate", "Actual%s.png"),
        DISTANCE_NAMETEMPLATE("distance.nametemplate", "Distance%s.png"),
        REFERENCE_PATH("reference.path", "src/test/resources/screenreferences/reference"),
        DISTANCE_PATH("distance.path", "src/test/resources/screenreferences/distance"),
        ACTUAL_PATH("actual.path", "src/test/resources/screenreferences/actual"),
        USE_IGNORE_COLOR("use.ignore.color", false),
        PIXEL_RGB_DEVIATION_PERCENT("pixel.rgb.deviation.percent", 0),

        ;
        private final String property;
        private final Object defaultValue;

        Properties(String property, Object defaultValue) {
            this.property = property;
            this.defaultValue = defaultValue;
        }

        @Override
        public String toString() {
            return String.format("tt.layoutcheck.%s", property);
        }

        @Override
        public Object getDefault() {
            return defaultValue;
        }
    }

    public static class MatchStep {
        Path referenceFileName;
        Path actualFileName;
        Path distanceFileName;
        String consecutiveTargetImageName;
        public boolean takeReferenceOnly;
        public double distance = NO_DISTANCE;
    }

    private static final Report report = Testerra.getInjector().getInstance(Report.class);

    /**
     * Hide Default constructor.
     */
    private LayoutCheck() {
    }

    /**
     * LayoutCheck Mode options
     *
     * @author sepr
     */
    public enum Mode {
        PIXEL
    }

    private static final double NO_DISTANCE = 0;
    private static final int RGB_DEVIATION_PERCENT = Properties.PIXEL_RGB_DEVIATION_PERCENT.asLong().intValue();
    private static final double RGB_MAX_DEVIATION = 255;

    private static final HashMap<String, Integer> runCount = new HashMap<>();

    /**
     * Logger.
     */
    @Deprecated
    private static final Logger LOGGER = LoggerFactory.getLogger(LayoutCheck.class);

    public static Path getDir(String basePath) {
        File baseDir = new File(basePath);
        if (!baseDir.exists()) {
            baseDir.mkdirs();
        }
        return baseDir.toPath();
    }

    /**
     * Takes reference screenshots and prepares file paths for discrete matching modes
     */
    private static MatchStep prepare(
            final File screenshot,
            final String targetImageName
    ) {
        final MatchStep step = new MatchStep();

        Path referenceImagesDir = getDir(PROPERTY_MANAGER.getProperty(Properties.REFERENCE_PATH, "src/test/resources/screenreferences/reference"));
        Path actualImagesDir = getDir(PROPERTY_MANAGER.getProperty(Properties.ACTUAL_PATH, "src/test/resources/screenreferences/actual"));
        Path distanceImagesDir = getDir(PROPERTY_MANAGER.getProperty(Properties.DISTANCE_PATH, "src/test/resources/screenreferences/distance"));

        step.referenceFileName = referenceImagesDir.resolve(String.format(
                PROPERTY_MANAGER.getProperty(Properties.REFERENCE_NAMETEMPLATE, "Reference%s.png"),
                targetImageName
        ));

        String runCountModifier = "";
        if (!runCount.containsKey(targetImageName)) {
            runCount.put(targetImageName, 1);
        } else {
            Integer newCount = runCount.get(targetImageName) + 1;
            runCount.put(targetImageName, newCount);
            runCountModifier = String.format("-%03d", newCount);
        }

        step.takeReferenceOnly = Properties.TAKEREFERENCE.asBool();
        if (step.takeReferenceOnly) {
            // take reference screenshot
            try {
                FileUtils.copyFile(screenshot, step.referenceFileName.toFile());
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
                throw new SystemException("Error when saving reference screenshot.", e);
            }
            LOGGER.info(String.format("Saved reference screenshot at '%s'.", step.referenceFileName.toString()));
        } else {
            step.consecutiveTargetImageName = targetImageName + runCountModifier;

            step.actualFileName = actualImagesDir.resolve(
                    String.format(Properties.ACTUAL_NAMETEMPLATE.asString(), step.consecutiveTargetImageName)
            );

            try {
                FileUtils.copyFile(screenshot, step.actualFileName.toFile());
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
                throw new SystemException("Error when saving screenshot.", e);
            }
            LOGGER.debug(String.format("Saved actual screenshot at '%s'.", step.actualFileName.toString()));

            // create distance file name
            step.distanceFileName = distanceImagesDir.resolve(
                    String.format(Properties.DISTANCE_NAMETEMPLATE.asString(), step.consecutiveTargetImageName)
            );
        }

        return step;
    }

    /**
     * Matches image pixels and returns an absolute distance value
     */
    public static MatchStep matchPixels(final TakesScreenshot takesScreenshot, final String targetImageName) {
        final File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        return matchPixels(screenshot, targetImageName);
    }

    public static MatchStep matchPixels(final File screenshot, final String targetImageName) {
        final MatchStep step = prepare(screenshot, targetImageName);
        if (!step.takeReferenceOnly) {
            matchPixels(step);
        }
        return step;
    }

    private static void matchPixels(final MatchStep matchStep) {
        try {
            // read images
            File refFile = matchStep.referenceFileName.toFile();
            File actualFile = matchStep.actualFileName.toFile();

            if (!refFile.exists()) {
                throw new FileNotFoundException(matchStep.referenceFileName.toString());
            }
            if (!actualFile.exists()) {
                throw new FileNotFoundException(matchStep.actualFileName.toString());
            }

            final BufferedImage referenceImage = ImageIO.read(refFile);
            final BufferedImage actualImage = ImageIO.read(actualFile);

            final boolean useIgnoreColor = Properties.USE_IGNORE_COLOR.asBool();

            // create distance image to given reference
            matchStep.distance = generateDistanceImage(
                    referenceImage,
                    actualImage,
                    matchStep.distanceFileName,
                    useIgnoreColor
            );
        } catch (Exception e) {
            throw new LayoutCheckException(matchStep, e);
        }
    }

    /**
     * Returns the color of a pixel at a certain position of the image
     *
     * @param image with a certain colored pixel
     * @param x Position of the pixel
     * @param y Position of the pixel
     * @return color code of the pixel
     */
    private static int getColorOfPixel(BufferedImage image, int x, int y) {
        return image.getRGB(x, y);
    }

    /**
     * Creates an image showing the differences of the given images and calculates the difference between the images in
     * percent.
     *
     * @param expectedImage The expected image
     * @param actualImage The actual image
     * @param resultFilename Filename to the save the image containing the differences
     * @return Percents of pixels that are different
     */
    private static double generateDistanceImage(
            final BufferedImage expectedImage,
            final BufferedImage actualImage,
            final Path resultFilename,
            final boolean useIgnoreColor
    ) {
        // for counting the pixels that are different
        int pixelsInError = 0;
        int noOfIgnoredPixels = 0;
        // calculate the size of the distance image and create an empty image
        final Dimension distanceImageSize = calculateMaxImageSize(expectedImage, actualImage);
        final BufferedImage distanceImage = new BufferedImage(
                distanceImageSize.width, distanceImageSize.height,
                expectedImage.getType());

        Dimension expectedImageDimension = new Dimension(expectedImage.getWidth(), expectedImage.getHeight());
        Dimension actualImageDimension = new Dimension(actualImage.getWidth(), actualImage.getHeight());

        if (!actualImageDimension.equals(expectedImageDimension)) {
            NonFunctionalAssert.fail(
                    String.format(
                            "The actual image (width=%dpx, height=%dpx) has a different size than the reference image (width=%dpx, height=%dpx)",
                            actualImageDimension.width,
                            actualImageDimension.height,
                            expectedImageDimension.width,
                            expectedImageDimension.height
                    )
            );
        }

//        // TODO remove markedRectangles
//        List<Rectangle> markedRectangles = null;
//
//        // PIXEL mode: markedRectangles always null
//        if (markedRectangles == null) {
//            markedRectangles = new ArrayList<>();
//            Rectangle rectangle = new Rectangle(0, 0, distanceImageSize.width, distanceImageSize.height);
//            markedRectangles.add(rectangle);
//        } else {
//            for (int currentY = 0; currentY < distanceImage.getHeight(); currentY++) {
//                for (int currentX = 0; currentX < distanceImage.getWidth(); currentX++) {
//                    boolean pixelIsInsideExpectedImage = isPixelInImageBounds(expectedImage, currentX, currentY);
//                    if (pixelIsInsideExpectedImage) {
//                        int rgb = expectedImage.getRGB(currentX, currentY);
//                        Color color = new Color(rgb);
//                        color = color.darker().darker();
//                        distanceImage.setRGB(currentX, currentY, color.getRGB());
//                    } else {
//                        distanceImage.setRGB(currentX, currentY, Color.BLUE.getRGB());
//                    }
//                }
//            }
//        }

        int ignoreColor = getColorOfPixel(expectedImage, 0, 0);

        for (int currentY = 0; currentY < distanceImageSize.height; currentY++) {
            for (int currentX = 0; currentX < distanceImageSize.width; currentX++) {
                boolean pixelIsInsideExpectedImage = isPixelInImageBounds(expectedImage, currentX, currentY);
                boolean pixelIsInsideActualImage = isPixelInImageBounds(actualImage, currentX, currentY);

                if (pixelIsInsideExpectedImage) {
                    // draw every pixel that is available in the expected image
                    distanceImage.setRGB(currentX, currentY,
                            expectedImage.getRGB(currentX, currentY));
                }

                if (pixelIsInsideExpectedImage && pixelIsInsideActualImage) {
                    // if the pixel color at x,y is not equal and the pixel is not marked as 'to ignore'
                    int expectedRgb = expectedImage.getRGB(currentX, currentY);
                    int actualImageRGB = actualImage.getRGB(currentX, currentY);

                    boolean ignoredPixel = useIgnoreColor && expectedRgb == ignoreColor;

                    //

                    if (!ignoredPixel) {
                        boolean match = doRGBsMatch(expectedRgb, actualImageRGB);
                        if (!match) {
                            // mark the current pixel as error by painting it red
                            distanceImage.setRGB(currentX, currentY, Color.RED.getRGB());
                            pixelsInError++;
                        }
                    }

                    // count the ignored pixels for calculating
                    if (useIgnoreColor && expectedRgb == ignoreColor) {
                        noOfIgnoredPixels++;
                    }
                } else {
                    // this pixel is not inside one or the other image - mark it, but not as error
                    distanceImage.setRGB(currentX, currentY, Color.BLUE.getRGB());
                }
            }
        }

        try {
            // Write image to given file
            resultFilename.toFile().getParentFile().mkdirs();
            ImageIO.write(distanceImage, "PNG", resultFilename.toAbsolutePath().toFile());
        } catch (IOException ioe) {
            LOGGER.error(
                    String.format("An error occurred while trying to persist image to '%s'.", resultFilename),
                    ioe);
        }

        int totalPixels = distanceImageSize.width * distanceImageSize.height;
//        for (Rectangle rectangleToCompare : markedRectangles) {
//            totalPixels += rectangleToCompare.height * rectangleToCompare.width;
//        }

        // calculate and return the percentage number of pixels in error
        return ((double) pixelsInError / (totalPixels - noOfIgnoredPixels)) * 100;
    }

    public static boolean doRGBsMatch(int expectedRgb, int actualImageRGB) {
        if (expectedRgb == actualImageRGB) {
            return true;
        }

        if (RGB_DEVIATION_PERCENT > 0) {
            Color expectedColor = new Color(expectedRgb);
            Color actualColor = new Color(actualImageRGB);

            int percentR = (int) (100 * (Math.abs(expectedColor.getRed() - actualColor.getRed())) / RGB_MAX_DEVIATION);
            int percentG = (int) (100 * (Math.abs(expectedColor.getGreen() - actualColor.getGreen())) / RGB_MAX_DEVIATION);
            int percentB = (int) (100 * (Math.abs(expectedColor.getBlue() - actualColor.getBlue())) / RGB_MAX_DEVIATION);

//            LOGGER.info("RGB deviation percent: " + percentR + "/" + percentG + "/" + percentB);
            if (percentR <= RGB_DEVIATION_PERCENT && percentG <= RGB_DEVIATION_PERCENT && percentB <= RGB_DEVIATION_PERCENT) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates the sizes that result from the maximum sizes of both pictures.
     *
     * @param expectedImage The expected image
     * @param actualImage The actual image
     * @return Calculated maximum size of the images
     */
    private static Dimension calculateMaxImageSize(
            final BufferedImage expectedImage,
            final BufferedImage actualImage
    ) {
        return new Dimension(
                Math.max(expectedImage.getWidth(), actualImage.getWidth()),
                Math.max(expectedImage.getHeight(), actualImage.getHeight())
        );
    }

    /**
     * Determines whether a pixel is within the bounds of an image.
     *
     * @param image The image
     * @param x X-coordinate of the pixel
     * @param y Y-coordinate of the pixel
     * @return true, if the pixel is within the images bounds, otherwise false
     */
    private static boolean isPixelInImageBounds(
            final BufferedImage image,
            final int x,
            final int y
    ) {
        return (image.getWidth() > x) && (image.getHeight() > y);
    }

    public static void toReport(final MatchStep step) {
        final String name = step.consecutiveTargetImageName;
        final Path referenceScreenshotPath = step.referenceFileName;
        final Path actualScreenshotPath = step.actualFileName;
        final Path distanceScreenshotPath = step.distanceFileName;

        LayoutCheckContext context = new LayoutCheckContext();
        context.image = name;
        // For readable report
        context.distance = new BigDecimal(step.distance).setScale(2, RoundingMode.HALF_UP).doubleValue();
        // Always copy the reference image
        context.expectedScreenshot = report.provideScreenshot(referenceScreenshotPath.toFile(), Report.FileMode.COPY);
        context.actualScreenshot = report.provideScreenshot(actualScreenshotPath.toFile(), Report.FileMode.MOVE);
        context.distanceScreenshot = report.provideScreenshot(distanceScreenshotPath.toFile(), Report.FileMode.MOVE);
        context.distanceScreenshot.getMetaData().put("Distance", Double.toString(step.distance));

        ExecutionContextController.getMethodContextForThread().ifPresent(methodContext -> {
            methodContext.addCustomContext(context);
        });
    }

    public static void assertScreenshot(WebDriver webDriver, String targetImageName, double confidenceThreshold) {
        LayoutCheck.MatchStep matchStep;
        final String assertMessage = String.format("Expected that pixel distance (%%) of WebDriver screenshot to image '%s'", targetImageName);
        try {
            //PropertyManager.setPriorityResolvers(Stream.of(new WebDriverPropertyResolver(webDriver)));
            matchStep = LayoutCheck.matchPixels((TakesScreenshot) webDriver, targetImageName);
            //PropertyManager.clearPriorityResolvers();
            if (!matchStep.takeReferenceOnly) {
                LayoutCheck.toReport(matchStep);
            }
            // Check for 2 decimals of % value is enough --> Readable assertion message
            AssertUtils.assertLowerEqualThan(new BigDecimal(matchStep.distance).setScale(2, RoundingMode.HALF_UP), new BigDecimal(confidenceThreshold), assertMessage);
        } catch (LayoutCheckException e) {
            matchStep = e.getMatchStep();
            LayoutCheck.toReport(matchStep);
            throw e;
        }
    }
}
