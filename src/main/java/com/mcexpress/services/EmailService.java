package com.mcexpress.services;

import org.springframework.mail.SimpleMailMessage;

import com.mcexpress.domain.Tusuarios;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Tusuarios obj);
	
	void sendEmail(SimpleMailMessage msg);
}
