package br.edu.fanor.progweb.arquitetura.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.edu.fanor.progweb.arquitetura.entity.Clientes;

@Repository
public class ClienteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Clientes cliente){
		em.persist(cliente);
	}
	
	public void atualizar(Clientes cliente){
		em.merge(cliente);
	}
	
	public Clientes buscarPorId(Long id){
		return em.find(Clientes.class, id);
	}
	
	public void excluir(Clientes cliente){
		em.remove(cliente);
	}
	
	public Clientes buscarPorCPF(String cpf){
		Query query = em.createQuery("select c.nome from Clientes c where c.cpf = :cpf");
		query.setParameter("cpf", cpf);
		return (Clientes) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Clientes> buscarPorNome(String nome){
		Query query = em.createQuery("select c from Clientes c where c.nome = :nome");
		query.setParameter("nome", nome);
		return query.getResultList();
	}

}
