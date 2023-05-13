package com.dailycodebuffer.springemailclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class SpringEmailClientApplication {

	@Autowired
	private EmailSenderService emailSenderService;
	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
//		emailSenderService.sendSimpleEmail("tienphambmt2911@gmail.com", "hehe body", "hehe subject");
		emailSenderService.sendEmailWithAttachment("tienphambmt2911@gmail.com", "hehe body", "hehe subject", "C:\\Users\\Hp\\Downloads\\SE160239_-SWE201c_PE_02.docx");
	}

}
