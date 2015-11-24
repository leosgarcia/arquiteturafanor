package br.edu.fanor.progweb.arquitetura.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	public List<Jogos> listaTodos() {
		String jpql = "select j from Jogos j";
		TypedQuery<Jogos> query = entityManager.createQuery(jpql, Jogos.class);
		return query.getResultList();
	}

	public Jogos buscaPorId(Integer id) {
		Jogos jogo = entityManager.find(Jogos.class, id);
		return jogo;
	}

}
