package br.edu.fanor.progweb.arquitetura.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.arquitetura.entity.Campeonatos;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CampeonatoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Campeonatos campeonato) {
		entityManager.persist(campeonato);
	}

	public void atualiza(Campeonatos campeonato) {
		entityManager.merge(campeonato);
	}

	public void excluir(Campeonatos campeonato) {
		entityManager.remove(campeonato);
	}

}
