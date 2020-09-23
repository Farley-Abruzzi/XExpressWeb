package com.mcexpress.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.mcexpress.domain.Tusuarios;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendOrderConfirmationEmail(Tusuarios obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromUsuario(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromUsuario(Tusuarios obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo("123testes.testes@gmail.com");
		sm.setFrom(sender);
		sm.setSubject("Usuário cadastrado!");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
	
	protected String htmlFromTemplateUsuario(Tusuarios obj) {
		Context context = new Context();
		context.setVariable("usuario", obj);
		return templateEngine.process("email/usuarioCadastrado", context);
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Tusuarios obj) {
		try {
			MimeMessage mm = prepareMimeMessageFromUsuario(obj);
			sendHtmlEmail(mm);
		}
		catch (MessagingException e) {
			sendOrderConfirmationEmail(obj);
		}
	}

	protected MimeMessage prepareMimeMessageFromUsuario(Tusuarios obj) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo("123testes.testes@gmail.com");
		mmh.setFrom(sender);
		mmh.setSubject("Usuário cadastrado!");
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateUsuario(obj), true);
		return mimeMessage;
	}
	
	@Override
	public void sendNewPasswordEmail(Tusuarios usuario, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(usuario, newPass);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareNewPasswordEmail(Tusuarios usuario, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo("123testes.testes@gmail.com");
		sm.setFrom(sender);
		sm.setSubject("Alteração de senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: "+ newPass);
		return sm;
	}

}
