package br.com.consumer.service;

import org.apache.log4j.Logger;
import org.springframework.amqp.AmqpTimeoutException;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.consumer.enumeration.Fila;
import br.com.consumer.enumeration.Prioridade;
import br.com.consumer.listener.AtendimentoListener;

/**
 * 
 * Classe responsável por prover o serviço responsável por consumir protocolo de atendimento
 * 
 * @author Renan Lalier <renanlalier@yahoo.com.br>
 * @since 29 de ago de 2016
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/atendimento")
public class ServiceAtendimento {
	
	@Autowired
	private ConnectionFactory factory;
	
	@Autowired
	private AtendimentoListener atendimentoListener;
	
	private Logger logger = Logger.getLogger(ServiceAtendimento.class);
	
	/**
	 * 
	 * Método responsável por consumir protocolo de uma fila específica com base no código da fila informado 
	 * 
	 * @author Renan Lalier <renanlalier@yahoo.com.br>
	 * @since 29 de ago de 2016
	 * @param codigoPrioridade
	 */
	@RequestMapping(value = "/atender", method=RequestMethod.POST)
	private void atenderSolicitacao(String codigoPrioridade) {
		
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(factory);
		container.setMessageListener(new MessageListenerAdapter(atendimentoListener));	

		try {
			
			if(codigoPrioridade.equals(Prioridade.EMERGENCIA.toString())){
				container.setQueueNames(Fila.QUEUE_EMERGENCIA.getQueueName());
			}
			
			if(codigoPrioridade.equals(Prioridade.ALTA.toString())){
				container.setQueueNames(Fila.QUEUE_ALTA_PRIORIDADE.getQueueName());
			}
			
			if(codigoPrioridade.equals(Prioridade.BAIXA.toString())){
				container.setQueueNames(Fila.QUEUE_BAIXA_PRIORIDADE.getQueueName());
			}
			
			container.start();
			
		} catch (AmqpTimeoutException e) {
			logger.error("Ocorreu um erro ao obter protocolo na fila " + e.getMessage());
		} finally{
			container.stop();
		}

	}

	
}
