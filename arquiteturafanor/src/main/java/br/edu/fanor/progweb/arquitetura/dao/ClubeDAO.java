package br.edu.fanor.progweb.arquitetura.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.arquitetura.entity.Clubes;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class ClubeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Clubes clube) {
		entityManager.persist(clube);
	}

	public void atualiza(Clubes clube) {
		entityManager.merge(clube);
	}

	public void excluir(Clubes clube) {
		entityManager.remove(clube);
	}

}
