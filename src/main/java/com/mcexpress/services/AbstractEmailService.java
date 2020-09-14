package com.mcexpress.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.mcexpress.domain.Tusuarios;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
	
	@Override
	public void sendOrderConfirmationEmail(Tusuarios obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromUsuario(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromUsuario(Tusuarios obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo("123testes.testes@gmail.com");
		sm.setFrom(sender);
		sm.setSubject("Usuário cadastrado! Login: "+ obj.getLogin());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}

}
