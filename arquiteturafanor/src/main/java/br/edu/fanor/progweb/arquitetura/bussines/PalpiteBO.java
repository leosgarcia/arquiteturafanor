package br.edu.fanor.progweb.arquitetura.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fanor.progweb.arquitetura.aspectj.Loggable;
import br.edu.fanor.progweb.arquitetura.aspectj.PermitAll;
import br.edu.fanor.progweb.arquitetura.dao.PalpiteDAO;
import br.edu.fanor.progweb.arquitetura.entity.Palpites;

@Loggable
@Service
public class PalpiteBO {
	
	@Autowired
	private PalpiteDAO palpiteDAO;
	
	@PermitAll
	public void salvar(Palpites palpite) {
		palpiteDAO.salvar(palpite);
	}


}
