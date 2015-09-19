package br.edu.fanor.progweb.arquitetura.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.arquitetura.entity.Rodadas;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class RodadaDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Rodadas rodada) {
		entityManager.persist(rodada);
	}

	public void atualiza(Rodadas rodada) {
		entityManager.merge(rodada);
	}

	public void excluir(Rodadas rodada) {
		entityManager.remove(rodada);
	}

}
