package com.mcexpress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mcexpress.services.S3Service;


@SpringBootApplication // Essa implementação executa a instanciação no momento em que a aplicação
						// iniciar
public class McexpressxApplication implements CommandLineRunner {
	
	@Autowired
	private S3Service s3Service;
	
	public static void main(String[] args) {
		
		SpringApplication.run(McexpressxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uploadFile("C:\\Users\\eliseu\\Pictures\\farley.jpg");
	}
	

}
