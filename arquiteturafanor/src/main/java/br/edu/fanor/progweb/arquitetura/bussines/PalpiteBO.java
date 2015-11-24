package br.edu.fanor.progweb.arquitetura.bussines;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fanor.progweb.arquitetura.aspectj.Loggable;
import br.edu.fanor.progweb.arquitetura.aspectj.PermitAll;
import br.edu.fanor.progweb.arquitetura.dao.PalpiteDAO;
import br.edu.fanor.progweb.arquitetura.entity.PalpiteDoUsuario;
import br.edu.fanor.progweb.arquitetura.entity.Palpites;

@Loggable
@Service
public class PalpiteBO {
	
	@Autowired
	private PalpiteDAO palpiteDAO;
	
	@PersistenceContext
	private EntityManager manager;
	
	
	@PermitAll
	public void salvar(Palpites palpite) {
		palpiteDAO.salvar(palpite);
	}

	@Transactional
	public void salvar(List<PalpiteDoUsuario> palpitesDoUsuario) {
		
		for (PalpiteDoUsuario palpiteDoUsuario : palpitesDoUsuario) {
			palpiteDAO.salvar(palpiteDoUsuario.getPalpite()); // salva filho
			salva(palpiteDoUsuario); // salva pai
		}
	}

	@Transactional
	public void remove(PalpiteDoUsuario palpiteDoUsuario) {
		manager.remove(palpiteDoUsuario); // exclui pai
		palpiteDAO.excluir(palpiteDoUsuario.getPalpite()); // exclui filho
	}
	
	private void salva(PalpiteDoUsuario palpiteDoUsuario) {
		manager.persist(palpiteDoUsuario);
	}

}
