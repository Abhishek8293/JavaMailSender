package com.mail.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.dto.MailDto;
import com.mail.service.MailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailController {

	private final MailService mailService;

	@PostMapping
	public ResponseEntity<Object> sendMail(@RequestBody MailDto mailDto) {
		mailService.sendMail(mailDto);
		return new ResponseEntity<Object>("Mail is sent successfully to "+mailDto.getTo(), HttpStatus.OK);
	}

}
