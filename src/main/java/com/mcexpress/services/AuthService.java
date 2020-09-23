 package com.mcexpress.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mcexpress.domain.Tusuarios;
import com.mcexpress.repositories.TusuariosRepository;
import com.mcexpress.services.exceptions.ObjectNotFountException;

	@Service
	public class AuthService {
	
	@Autowired
	private TusuariosRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) { 
		
		Tusuarios usuario = usuarioRepository.findByEmail(email);
		if (usuario == null) {
			throw new ObjectNotFountException("Email não encontrado");
		}
		
		String newPass = newPassword();
		usuario.setSENHA(pe.encode(newPass));
		
		usuarioRepository.save(usuario);
		emailService.sendNewPasswordEmail(usuario, newPass);

	}

	private String newPassword() {
		char[] vet = new char[7];
		for (int i=0; i<7; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) {//gera um digito
			return (char) (rand.nextInt(7) + 48);
		}
		else if (opt == 1) {//gera letra maíscula
			return (char) (rand.nextInt(7) + 65);
		}
		else {//gera letra minúscula
			return (char) (rand.nextInt(7) + 97);
		}
	}
}
