package br.com.consumer.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryListener {

	@Bean
	public AtendimentoListener createAtendimentoListener(){
		return new AtendimentoListener();
	}
	
}
