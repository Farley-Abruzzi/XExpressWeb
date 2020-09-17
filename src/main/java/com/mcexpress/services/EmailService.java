package com.mcexpress.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.mcexpress.domain.Tusuarios;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Tusuarios obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Tusuarios obj);
	
	void sendHtmlEmail(MimeMessage msg);
}
