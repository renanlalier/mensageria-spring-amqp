package br.com.sender.enumeration;

public enum Fila {

	QUEUE_EMERGENCIA("QUEUE_EMERGENCIA"),
	QUEUE_ALTA_PRIORIDADE("QUEUE_ALTA_PRIORIDADE"),
	QUEUE_BAIXA_PRIORIDADE("QUEUE_BAIXA_PRIORIDADE");
	
	private String queueName;
	
	private Fila(String queueName) {
		this.queueName = queueName;
	}
	
	public String getQueueName() {
		return queueName;
	}
}
