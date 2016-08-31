package br.com.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("br.com.sender")
public class ApplicationSender {

	public static void main(String[] args) {
		
		SpringApplication.run(ApplicationSender.class, args);
	}
	
}
