package com.mail.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EMailService {

	private final JavaMailSender javaMailSender;

	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		javaMailSender.send(message);
	}

	@Override
	public void sendeMimeMessage(String to, String subject, String text){
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			String htmlBody = "<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" +
					"<meta charset=\"UTF-8\">" +
					"<title>Email Verification</title>" +
					"<style>body{font-family:sans-serif;}</style>"+
					"</head>" +
					"<body>" +
					"<p>Dear <b>"+"USER_NAME"+"</b>"+
					"<p>We just need to verify your email address before you can access <b>Company Name.</b>"+
					"<p>Please <a href=" +"URL"+ "><b>Click Here<b/> </a>to verify your email.</p>" +
					"</body>" +
					"</html>";

			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(htmlBody, true);
			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
