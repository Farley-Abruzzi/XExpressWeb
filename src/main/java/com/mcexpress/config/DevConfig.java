package com.mcexpress.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev") // esse arquivo é de configuração somente de teste, então todos os Beans que estiver nesta classe serão somente para teste.
public class DevConfig {
	
	//Instanciar a DBService
	@Autowired
	//private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}") //Pega o valor da chave
	private String strategy;
	
	@Bean
	public boolean instanciateDatabase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			System.out.println("falso");
			return false;
		}
		System.out.println("verdadeiro");
		//dbService.instantiateTestDatabase(); //Ao invés de usar o arquivo principal instanciando os dados eu chamo a instanciação de teste ou dev que está numa classe de serviço.
		return true;
	}
	
}
