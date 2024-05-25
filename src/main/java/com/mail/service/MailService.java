package com.mail.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mail.dto.MailDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {

	private final JavaMailSender javaMailSender;

	public SimpleMailMessage sendMail(MailDto mailDto) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(mailDto.getTo());
		simpleMailMessage.setSubject(mailDto.getSubject());
		simpleMailMessage.setText(mailDto.getMessage());

		javaMailSender.send(simpleMailMessage);
		
		return simpleMailMessage;
	}

}
