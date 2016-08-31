package br.com.consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.consumer.domain.SolicitacaoAtendimentoDomain;

public interface SolicitacaoAtendimentoRepository extends MongoRepository<SolicitacaoAtendimentoDomain, Long>{

}
