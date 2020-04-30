package chart.email;

import java.security.GeneralSecurityException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.util.MailSSLSocketFactory;

public class Email {

	public static void triggerEmail2(String from, String password, String to, String sub, String msg) throws Exception {
		// Get properties object
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		Properties props = new Properties();
		props.put("mail.imap.ssl.trust", "*");
		props.put("mail.imap.ssl.socketFactory", sf);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public static void triggerEMail() throws Exception {
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);

		Properties props = new Properties();
		props.put("mail.imap.ssl.trust", "*");
		props.put("mail.imap.ssl.socketFactory", sf);
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ravikukrejapune@gmail.com", "Under87Taker");
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ravikukrejapune@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ravikukrejapune@gmail.com"));
			message.setSubject("Weekly Charts");
			BodyPart messageBodyPart1 = new MimeBodyPart();
			String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
			messageBodyPart1.setContent(htmlText, "text/html");
			// messageBodyPart1.setText("dmart");
			MimeMultipart multipart = new MimeMultipart("related");
			// MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			multipart.addBodyPart(messageBodyPart1);

			messageBodyPart1 = new MimeBodyPart();
			String filename = "resources/DMART-30.04.2020.PNG";
			DataSource source = new FileDataSource(filename);
			messageBodyPart1.setDataHandler(new DataHandler(source));
			messageBodyPart1.setHeader("Content-ID", "<image>");
			multipart.addBodyPart(messageBodyPart1);
			
			
			
			
//			messageBodyPart2.setFileName(filename);

//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBodyPart2);
//			multipart.addBodyPart(messageBodyPart1);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("=====Email Sent=====");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}