package br.com.consumer.usecase;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import br.com.consumer.domain.SolicitacaoAtendimentoDomain;
import br.com.consumer.repository.SolicitacaoAtendimentoRepository;

/**
 * 
 * Classe responsável por fornecer operações para manter protocolo de atendimento no MongoDB
 * 
 * @author Renan Lalier <renanlalier@yahoo.com.br>
 * @since 29 de ago de 2016
 * @version 1.0
 */
public class AtendimentoUseCase {
	
	@Autowired
	private SolicitacaoAtendimentoRepository solicitacaoRepository;

	/**
	 * 
	 * Método responsável por manter atendimento. Recebe o protocolo da fila, finaliza atendimento e
	 * insere protoloco no MongoDB
	 * 
	 * @author Renan Lalier <renanlalier@yahoo.com.br>
	 * @since 29 de ago de 2016
	 * @param json
	 */
	public void manterAtendimento(String json){
		
		Gson gson = new Gson();
		SolicitacaoAtendimentoDomain solicitacao = gson.fromJson(json, SolicitacaoAtendimentoDomain.class);
		solicitacao.setDataEncerramento(LocalDate.now());
		solicitacaoRepository.save(solicitacao);
	}
	
}
