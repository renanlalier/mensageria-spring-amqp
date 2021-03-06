package br.com.consumer.domain;

import java.time.LocalDate;

/**
 * 
 * Classe responsável por representar o objeto de solicitação de atendimento 
 * @author Renan Lalier <renanlalier@yahoo.com.br>
 * @since 25 de ago de 2016
 * @version 1.0
 */
public class SolicitacaoAtendimentoDomain {
	
	private String nome;
	
	private String email;
	
	private String codigoPrioridade;
	
	private String descricao;
	
	private LocalDate dataEncerramento;
	
	public SolicitacaoAtendimentoDomain(String nome, String email, String codigoPrioridade, String descricao) {
		this.nome = nome;
		this.email = email;
		this.codigoPrioridade = codigoPrioridade;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigoPrioridade() {
		return codigoPrioridade;
	}

	public void setCodigoPrioridade(String codigoPrioridade) {
		this.codigoPrioridade = codigoPrioridade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public LocalDate getDataEncerramento() {
		return dataEncerramento;
	}
	
	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	

}
