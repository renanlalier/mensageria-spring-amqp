package br.com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("br.com.consumer")
public class ApplicationConsumer {

	public static void main(String[] args) {
		
		SpringApplication.run(ApplicationConsumer.class, args);
	}
	
}
