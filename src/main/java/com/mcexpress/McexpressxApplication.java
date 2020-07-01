package com.mcexpress;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication // Essa implementação executa a instanciação no momento em que a aplicação
						// iniciar
public class McexpressxApplication implements CommandLineRunner {

	public static void main(String[] args) {
		
		SpringApplication.run(McexpressxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Aqui vou instanciar os meus objetos

	}
	

}
