/*
 * Testerra
 *
 * (C) 2020, Peter Lehmann, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
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
package eu.tsystems.mms.tic.testframework.mailconnector.smtp;

import eu.tsystems.mms.tic.testframework.common.PropertyManager;
import eu.tsystems.mms.tic.testframework.exceptions.SystemException;
import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.mailconnector.util.AbstractMailConnector;
import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.util.Base64;
import java.util.Properties;

/**
 * MailConnector using the SMTP Protocol. Creates a session with values from mailconnection.properties.
 *
 * @author pele, mrgi
 */
public class SMTPMailConnector extends AbstractMailConnector implements Loggable {
    /**
     * messageID from the current sent message.
     */
    private String messageID;
    /**
     * the last sent message.
     */
    private MimeMessage lastSentMessage;

    /**
     * Constructor, creates a SMTPMailConnector Object.
     */
    public SMTPMailConnector() {
        super();
        this.init();
    }

    /**
     * Called from constructor. Initializes the ImapMailConnector.
     */
    private void init() {
        setUsername(PropertyManager.getProperty("SMTP_USERNAME", null));
        setPassword(PropertyManager.getProperty("SMTP_PASSWORD", null));
        setServer(PropertyManager.getProperty("SMTP_SERVER", null));
        setPort(PropertyManager.getProperty("SMTP_SERVER_PORT", null));

        setDebug(PropertyManager.getBooleanProperty("DEBUG_SETTING", false));
        setSslEnabled(PropertyManager.getBooleanProperty("SMTP_SSL_ENABLED", false));
    }

    /**
     * Open a new SMTP Session and save in session object.
     *
     * @see {https://eclipse-ee4j.github.io/mail/docs/api/com/sun/mail/smtp/package-summary.html}
     */
    @Override
    protected void openSession() {
        final Properties mailprops = new Properties();
        String protocol;
        if (isSslEnabled()) {
            protocol = "smtps";
        } else {
            protocol = "smtp";
        }

        mailprops.setProperty("mail.transport.protocol", protocol);
        mailprops.put("mail." + protocol + ".auth", "true");

        setSession(createDefaultSession(mailprops, protocol));
    }

    /**
     * Send a new message.
     *
     * @param message The message to send.
     * @throws SystemException thrown if message was not sent.
     */
    public void sendMessage(final MimeMessage message) throws SystemException {
        this.pSendMessage(message);
    }

    /**
     * Send a new message.
     *
     * @param message The message to send.
     * @throws SystemException thrown if message was not sent.
     */
    private void pSendMessage(final MimeMessage message) throws SystemException {
        Transport transport = null;
        try {
            transport = getSession().getTransport();

            // send
            transport.connect();

            // save message id
            if (message.getMessageID() != null) {
                this.messageID = message.getMessageID();
            }

            transport.sendMessage(message, message.getAllRecipients());
            log().info("Message sent! ");
            transport.close();
            this.lastSentMessage = message;
        } catch (final Exception e) {
            log().error("Unable to send email", e);
        }
    }

    /**
     * Creates a MimeBodyPart attachment from file.
     *
     * @param file The file to convert to MimeBodyPart.
     * @return MimeBodyPart.
     */
    public MimeBodyPart createAttachment(final File file) {
        return this.pCreateAttachment(file);
    }

    /**
     * Creates a MimeBodyPart attachment from file.
     *
     * @param file The file to convert to MimeBodyPart.
     * @return MimeBodyPart.
     */
    private MimeBodyPart pCreateAttachment(final File file) {
        final MimeBodyPart attachment = new MimeBodyPart();
        try {
            attachment.setDataHandler(new DataHandler(new FileDataSource(file)));
            attachment.setFileName(file.getName());
            attachment.setDisposition(MimeBodyPart.ATTACHMENT);
        } catch (final MessagingException e) {
            log().error("Unable to create attachment", e);
        }

        return attachment;
    }

    /**
     * Add MimeBodyParts to a message. Can only called once, otherwise message text can not saved.
     *
     * @param attachments An array containing the MimeBodyParts.
     * @param message The message to add the attachments.
     * @return The message with the attached MimeBodyParts.
     */
    public MimeMessage addAttachmentsToMessage(final MimeBodyPart[] attachments, final Message message) {
        return this.pAddAttachmentsToMessage(attachments, message);
    }

    /**
     * Add MimeBodyParts to a message. Can only called once, otherwise message text can not saved.
     *
     * @param attachments An array containing the MimeBodyParts.
     * @param message The message to add the attachments.
     * @return The message with the attached MimeBodyParts.
     */
    private MimeMessage pAddAttachmentsToMessage(final MimeBodyPart[] attachments, final Message message) {
        try {
            final MimeMultipart mimeMultipart = new MimeMultipart();
            final MimeBodyPart text = new MimeBodyPart();

            text.setText(message.getContent().toString());
            text.setDisposition(MimeBodyPart.INLINE);
            mimeMultipart.addBodyPart(text);
            for (final MimeBodyPart attachment : attachments) {
                mimeMultipart.addBodyPart(attachment);
            }

            message.setContent(mimeMultipart);
            message.saveChanges();
        } catch (final Exception e) {
            log().error("Unable to add attachment", e);
        }

        return (MimeMessage) message;
    }

    /**
     * Send a virus mail.
     *
     * @param from The from address.
     * @param receiver The to address.
     * @param ccReceiver The cc address. Can be null.
     * @param bcc The bcc address. Can be null.
     * @return A MimeMessage containing a virus signature.
     * @throws SystemException thrown if virus Mail can't generated.
     * @throws RuntimeException thrown if address parameters were wrong.
     */
    public MimeMessage generateVirusMail(final String from, final String receiver,
                                         final String ccReceiver, final String bcc) throws SystemException, RuntimeException {
        return this.pGenerateVirusMail(from, receiver, ccReceiver, bcc);
    }

    /**
     * Send a virus mail.
     *
     * @param from The from address.
     * @param receiver The to address.
     * @param ccReceiver The cc address. Can be null.
     * @param bcc The bcc address. Can be null.
     * @return A MimeMessage containing a virus signature.
     * @throws SystemException thrown if virus Mail can't generated.
     * @throws RuntimeException thrown if address parameters were wrong.
     */
    private MimeMessage pGenerateVirusMail(final String from, final String receiver,
                                           final String ccReceiver, final String bcc) throws SystemException, RuntimeException {
        final MimeMessage message = new MimeMessage(getSession());
        try {

            message.setFrom(new InternetAddress(from));
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiver));

            if (ccReceiver != null) {
                message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress(ccReceiver));
            }

            if (bcc != null) {
                message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress(bcc));
            }

            final String virusPattern = "X5O!P%@AP[4\\PZX54" + "(P^)7CC)7}$EICAR-STANDARD-ANTIVIRUS-TEST-FILE!$H+H*";
            message.setSubject("Antivirus-Test");

            final MimeMultipart multiPart = new MimeMultipart();

            final MimeBodyPart bp1 = new MimeBodyPart();

            bp1.setContent(String.class, "text/plain");

            multiPart.addBodyPart(bp1);

            final byte[] encoded = Base64.getEncoder().encode(virusPattern.getBytes());
            final MimeBodyPart bp2 = new MimeBodyPart();
            bp2.setFileName("virus.exe");
            bp2.setContent(encoded, "application/octet-stream");
            bp2.setHeader("Content-Transfer-Encoding", "base64");

            multiPart.addBodyPart(bp2);

            message.setContent(multiPart);
            message.saveChanges();
        } catch (final AddressException aex) {
            throw new RuntimeException("Some of the address parameters were wrong.", aex);
        } catch (final MessagingException e) {
            throw new SystemException(e);
        }
        return message;
    }

    /**
     * .
     *
     * @return .
     */
    public String getMessageID() {
        return messageID;
    }

    /**
     * .
     *
     * @return last sent message
     */
    public MimeMessage getLastSentMessage() {
        return lastSentMessage;
    }

    /**
     * sets the messageID
     *
     * @param messageID the messageID to set
     */
    public void setMessageID(final String messageID) {
        this.messageID = messageID;
    }

    /**
     * sets the last sent message
     *
     * @param lastSentMessage the lastSentMessage to set
     */
    public void setLastSentMessage(final MimeMessage lastSentMessage) {
        this.lastSentMessage = lastSentMessage;
    }
}
