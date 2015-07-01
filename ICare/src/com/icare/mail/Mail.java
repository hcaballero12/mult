package com.icare.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	
	
	public  void sendEmail() {
		String host = "smtp.mail.yahoo.com";
		String from = "icaremanagersystem@yahoo.com";
		String to = "icaremanagersystem@yahoo.com";
		
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("icaremanagersystem@yahoo.com", "multivision");
			}
		  });
		
		MimeMessage message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(from));			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Java Mail");
			message.setText("Java");
			Transport.send(message);
		}
		catch (AddressException e) {
			
		}
		catch (MessagingException e) {
			
		}
	}
}