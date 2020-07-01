package com.mcexpress.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfig {
// https://stackoverflow.com/questions/41452598/overcome-can-not-construct-instance-ofinterfaceclass-without-hinting-the-pare
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				//objectMapper.registerSubtypes(PagamentoComCartao.class); //Sub classes do projeto que temos que registrar. (Adequar ao projeto)
				//objectMapper.registerSubtypes(PagamentoComBoleto.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}
// Essa é uma classe de configuração com um método @Bean para registrar as subclasses:
// Essa classe tem algum metodo / alguma informação que vai estar disponível no meu sistema e vai
// ser configurada no inicio da execução da aplicação.	
// Na classe anotamos @configuration na classe e @ Bean nos metodos que vão conter a informação de configuração.