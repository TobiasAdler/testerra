package eu.tsystems.mms.tic.testframework.report.testundertest;

import eu.tsystems.mms.tic.testframework.execution.testng.NonFunctionalAssert;
import eu.tsystems.mms.tic.testframework.report.FailureCorridor;
import org.testng.annotations.Test;

public class ReportTestUnderTestCorridorHighExceed extends AbstractTest {

    @FailureCorridor.High
    @Test
    public void test_testHighExceedCorridorFailedMinor1() throws Exception {
        NonFunctionalAssert.assertTrue(2>3);
        throw new Exception();
    }
}
