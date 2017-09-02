package com.nagarro.imageutility.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.nagarro.imageutility.logger.LoggerInitialize;

/**
 * The Class MailSender.It uses Simple mail transfer protocol for sending the
 * mail and by default its connected by my user Id
 */
public class MailSender {

	/**
	 * Send mail to the user who have requested to the mail.
	 *
	 * @param to
	 *            the to the receipent ID
	 * @param subject
	 *            the subject the subject of the mail
	 * @param msg
	 *            the msg is the body of the email
	 */
	public static void sendMail(final String to, final String subject, final String msg) {

		final String user = "ricktam.nagarro@gmail.com";
		final String pass = "rick3145350";
		final Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		final Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});

		// compose message
		try {
			final MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(to));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(msg);

			// send message
			Transport.send(message);

		} catch (final MessagingException e) {
			LoggerInitialize.LOGGER.debug(e.getMessage());
		}

	}

}
