package br.edu.fanor.progweb.arquitetura.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.arquitetura.entity.Palpites;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class PalpiteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Palpites palpite) {
		entityManager.persist(palpite);
	}

	public void atualiza(Palpites palpite) {
		entityManager.merge(palpite);
	}

	public void excluir(Palpites palpite) {
		entityManager.remove(palpite);
	}

}
