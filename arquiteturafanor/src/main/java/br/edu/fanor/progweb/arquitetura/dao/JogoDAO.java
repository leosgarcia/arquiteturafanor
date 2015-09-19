package br.edu.fanor.progweb.arquitetura.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.arquitetura.entity.Jogos;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class JogoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Jogos jogo) {
		entityManager.persist(jogo);
	}

	public void atualiza(Jogos jogo) {
		entityManager.merge(jogo);
	}

	public void excluir(Jogos jogo) {
		entityManager.remove(jogo);
	}

}
