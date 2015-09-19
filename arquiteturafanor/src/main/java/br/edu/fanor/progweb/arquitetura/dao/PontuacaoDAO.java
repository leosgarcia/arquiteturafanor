package br.edu.fanor.progweb.arquitetura.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.arquitetura.entity.Pontuacoes;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class PontuacaoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Pontuacoes pontuacao) {
		entityManager.persist(pontuacao);
	}

	public void atualiza(Pontuacoes pontuacao) {
		entityManager.merge(pontuacao);
	}

	public void excluir(Pontuacoes pontuacao) {
		entityManager.remove(pontuacao);
	}
}
