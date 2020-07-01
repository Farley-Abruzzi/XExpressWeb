package com.mcexpress.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test") // esse arquivo é de configuração somente de teste, então todos os Beans que estiver nesta classe serão somente para teste.
public class TestConfig {
	
	//Instanciar a DBService
	@Autowired
	//private DBService dbService;
	
	@Bean
	public boolean instanciateDatabase() throws ParseException {
		
		//dbService.instantiateTestDatabase(); //Ao invés de usar o arquivo principal instanciando os dados eu chamo a instanciação de teste que está numa classe de serviço.
		return true;
	}

}
