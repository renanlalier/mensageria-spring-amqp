package br.com.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.consumer.usecase.AtendimentoUseCase;

/**
 * 
 * Classe responsável por representar o listener responsável por consumir as mensagens das filas
 * 
 * @author Renan Lalier <renanlalier@yahoo.com.br>
 * @since 29 de ago de 2016
 * @version 1.0
 */
public class AtendimentoListener {
	
	@Autowired
	private AtendimentoUseCase atendimentoUseCase;
	
	public void handleMessage(String mensagem) {
		
		atendimentoUseCase.manterAtendimento(mensagem);

	}

}
