package com.mcexpress.services.exceptions;

//criação de exceção personalisada
public class AuthorizationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuthorizationException(String msg) {
		super(msg); //A super classe é RuntimeException, pois estamos aproveitando a estrutura de exceção da linguagem java.
	}
	
	//Sobrecarca do construtor que recebe a mensagem e uma causa do que aconteceu antes
	public AuthorizationException(String msg, Throwable cause) {
		super(msg,cause);
	}	

}
