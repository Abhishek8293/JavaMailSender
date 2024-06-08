package com.mail.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.dto.EMailDto;
import com.mail.service.EmailServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class MailController {

	private final EmailServiceImpl mailServiceiImpl;

	@PostMapping
	public ResponseEntity<?> sendSimpleMail(@RequestBody EMailDto eMailDto) {
		mailServiceiImpl.sendSimpleMessage(eMailDto.getTo(), eMailDto.getSubject(), eMailDto.getMessage());
		return ResponseEntity.ok("Email Sent Successfully.");
	}

	@PostMapping
	public ResponseEntity<?> sendMimeMessage(@RequestBody EMailDto eMailDto) {
		mailServiceiImpl.sendeMimeMessage(eMailDto.getTo(), eMailDto.getSubject(), eMailDto.getMessage());
		return ResponseEntity.ok("Email Sent Successfully");
	}

}
