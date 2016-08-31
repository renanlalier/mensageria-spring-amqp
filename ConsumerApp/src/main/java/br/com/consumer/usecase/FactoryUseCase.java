package br.com.consumer.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryUseCase {

	@Bean
	public AtendimentoUseCase createAtendimentoUseCase(){
		return new AtendimentoUseCase();
	}
	
}
