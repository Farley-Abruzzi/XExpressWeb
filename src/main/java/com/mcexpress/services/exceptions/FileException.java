package com.mcexpress.services.exceptions;

//criação de exceção personalisada
public class FileException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FileException(String msg) {
		super(msg); //A super classe é RuntimeException, pois estamos aproveitando a estrutura de exceção da linguagem java.
	}
	
	//Sobrecarca do construtor que recebe a mensagem e uma causa do que aconteceu antes
	public FileException(String msg, Throwable cause) {
		super(msg, cause);
	}	

}
