package com.login.util;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Value("${SMTP_SERVER}")
	private String SMTP_SERVER;

	@Value("${PORT}")
	private String PORT;

	@Value("${FLAG}")
	private String FLAG;

	@Value("${OTP_FORMAT}")
	private String OTP_FORMAT;

	/**
	 * Trigger mail.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public String triggerMail(String username, String password) {

		Properties prop = new Properties();
		prop.put("mail.smtp.host", SMTP_SERVER);
		prop.put("mail.smtp.port", PORT);
		prop.put("mail.smtp.auth", FLAG);
		prop.put("mail.smtp.starttls.enable", FLAG);
		
		String otp = String.valueOf(generateOtp(6));

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
			message.setSubject("EXTERNAL TEAM");
			message.setText("Dear Upendra," + "\n\n Please find your OTP: " + otp);

			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return otp;

	}

	public char[] generateOtp(int len) {

		String numbers = OTP_FORMAT;

		char[] otp = new char[len];

		for (int i = 0; i < len; i++) {

			otp[i] = numbers.charAt(new Random().nextInt(numbers.length()));
		}
		return otp;
	}

}
