package com.mail.service;

import jakarta.mail.MessagingException;

public interface EMailService {

	void sendSimpleMessage(String to, String subject, String text);

	void sendeMimeMessage(String to, String subject, String text) throws MessagingException;

}
