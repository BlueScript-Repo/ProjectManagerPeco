package com.projectmanager.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.annotation.ManagedBean;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.RawMessage;
import com.amazonaws.services.simpleemail.model.SendRawEmailRequest;

@ManagedBean
public class EmailUtils {

	@Autowired
	ConfigProperties configProperties;

	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		// mailSender.setPort(25);
		mailSender.setUsername("ProjectInvManager@gmail.com");
		mailSender.setPassword("ProjectInvManager12");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "false");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		props.put("multipart/*", "x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.ssl.enable", "true");

		MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
		mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc.addMailcap("message/rfc822;; x-java-content- handler=com.sun.mail.handlers.message_rfc822");

		return mailSender;
	}

	public void sendMessageWithAttachment(String sender, String recipient, String subject, String text,
			String fileToAttach, String userName) {

		String[] attachments = fileToAttach.split(",");

		String pathToInvoice = System.getProperty("java.io.tmpdir") + "/" + userName + "/" + attachments[0];



		File[] file = {};

		if(attachments.length>1 && !("".equals(attachments[1].trim())))
		{
			String pathToAnnextur = System.getProperty("java.io.tmpdir") + "/" + userName + "/" + attachments[1];
			file = new File[]{new File(pathToInvoice.trim()), new File(pathToAnnextur.trim())};
		}
		else
		{
			file = new File[]{ new File(pathToInvoice.trim())};
		}

		sendEmail(subject, sender, recipient, text, file);

	}

	public void sendInquiry(String sender, String recipient, byte[] fileBytes, String inquiryName, File file) {
		String subject = "PECO Projects : Inventory Inquiry";

		String text = "Greeting of thr day from PECO . Please find attached the Inventory requirment. Pleaase update the same and respond.";

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(fileBytes);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File[] filesToattach = { file };
		sendEmail(subject, sender, recipient, text, filesToattach);
	}

	public void sendEmail(String subject, String sender, String recipient, String text, File[] file) {
		try {
			if (sender.isEmpty()) {
				sender = "ProjectInvManager@gmail.com";
			}
			final String awsAccessKeyId = configProperties.getPropValues("AWS_ACCESS_KEY_ID");
			final String awsSecretAccessKey = configProperties.getPropValues("AWS_SECRET_ACCESS_KEY");
			final AWSCredentials reqCredentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
					.withRegion(Regions.AP_SOUTH_1).build();

			Session session = Session.getDefaultInstance(new Properties());

			// Create a new MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Add subject, from and to lines.
			message.setSubject(subject, "UTF-8");
			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("admin@pecoprojects.com"));

			// Create a multipart/alternative child container.
			MimeMultipart msg_body = new MimeMultipart("alternative");

			// Create a wrapper for the HTML and text parts.
			MimeBodyPart wrap = new MimeBodyPart();

			// Define the text part.
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setContent(text, "text/plain; charset=UTF-8");

			// Add the text and HTML parts to the child container.
			msg_body.addBodyPart(textPart);

			// Add the child container to the wrapper object.
			wrap.setContent(msg_body);

			// Create a multipart/mixed parent container.
			MimeMultipart msg = new MimeMultipart("mixed");

			// Add the parent container to the message.
			message.setContent(msg);

			// Add the multipart/alternative part to the message.
			msg.addBodyPart(wrap);

			MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
			mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
			mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
			mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
			mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
			mc.addMailcap("message/rfc822;; x-java-content- handler=com.sun.mail.handlers.message_rfc822");

			if(file != null){
				for (File file1 : file) {
					// Define the attachment
					MimeBodyPart att = new MimeBodyPart();

					DataSource fds = new FileDataSource(file1);
					att.setDataHandler(new DataHandler(fds));
					att.setFileName(fds.getName());

					// Add the attachment to the message.
					msg.addBodyPart(att);
				}

			}			// Send the email.
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			message.writeTo(outputStream);
			RawMessage rawMessage = new RawMessage(ByteBuffer.wrap(outputStream.toByteArray()));

			SendRawEmailRequest rawEmailRequest = new SendRawEmailRequest(rawMessage);
			rawEmailRequest.setRequestCredentials(reqCredentials);
			client.sendRawEmail(rawEmailRequest);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
