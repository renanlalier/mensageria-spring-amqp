package br.com.sender.service;

import org.apache.log4j.Logger;
import org.springframework.amqp.AmqpTimeoutException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sender.dto.SolicitacaoAtendimentoDTO;
import br.com.sender.enumeration.Fila;
import br.com.sender.enumeration.Prioridade;
import br.com.sender.utils.Converter;

/**
 * 
 * Classe responsável por fornecer serviço para envio de protocolo
 * @author Renan Lalier <renanlalier@yahoo.com.br>
 * @since 25 de ago de 2016
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/atendimento")
public class ServiceAtendimento {
	
	@Autowired
	private RabbitTemplate template;
	
	private Logger logger = Logger.getLogger(ServiceAtendimento.class);
	
	/**
	 * 
	 * Método responsável por receber protocolo via rest e encaminhar para a fila específica de acordo
	 * com a prioridade informada pelo atendente com base nos detalhes informados pelo usuário/cliente.
	 * 
	 * @author Renan Lalier <renanlalier@yahoo.com.br>
	 * @since 25 de ago de 2016
	 * @param nome
	 * @param email
	 * @param codigoPrioridade
	 * @param descricao
	 */
	@RequestMapping(value = "/protocolo", method=RequestMethod.POST)
	private void abrirChamado(String nome, String email, String codigoPrioridade, String descricao){
		
		try {
			
			String json = Converter.converterObjToJson(preencherSolicitacao(nome, email, codigoPrioridade, descricao));
			
			if(codigoPrioridade.equals(Prioridade.EMERGENCIA.toString())){
				template.convertAndSend(Fila.QUEUE_EMERGENCIA.getQueueName(), json);
			}
			
			if(codigoPrioridade.equals(Prioridade.ALTA.toString())){
				template.convertAndSend(Fila.QUEUE_ALTA_PRIORIDADE.getQueueName(), json);
			}
			
			if(codigoPrioridade.equals(Prioridade.BAIXA.toString())){
				template.convertAndSend(Fila.QUEUE_BAIXA_PRIORIDADE.getQueueName(), json);
			}
			
		} catch (AmqpTimeoutException e) {
			logger.error("Ocorreu um erro ao solicitação entrar na fila " + e.getMessage());
		}
		
	}
	
	/**
	 * 
	 * Método responsável por preencher o objeto que representa a solicitação de atendimento
	 * 
	 * @author Renan Lalier <renanlalier@yahoo.com.br>
	 * @since 25 de ago de 2016
	 * @param nome
	 * @param email
	 * @param codigoPrioridade
	 * @param descricao
	 * @return
	 */
	private SolicitacaoAtendimentoDTO preencherSolicitacao(String nome, String email, String codigoPrioridade, String descricao){
		return new SolicitacaoAtendimentoDTO(nome, email, codigoPrioridade, descricao);
	}

}
