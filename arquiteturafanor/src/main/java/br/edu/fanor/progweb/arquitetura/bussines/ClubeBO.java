package br.edu.fanor.progweb.arquitetura.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fanor.progweb.arquitetura.aspectj.Loggable;
import br.edu.fanor.progweb.arquitetura.aspectj.PermitAll;
import br.edu.fanor.progweb.arquitetura.dao.ClubeDAO;
import br.edu.fanor.progweb.arquitetura.entity.Clubes;

/**
 * @author didi 08/11/2015
 * 
 */
@Loggable
@Service
public class ClubeBO {

	@Autowired
	private ClubeDAO clubeDAO;

	@PermitAll
	public void salvar(Clubes clube) {
		clubeDAO.salvar(clube);
	}

	@PermitAll
	public void atualizar(Clubes clube) {
		clubeDAO.atualizar(clube);
	}

}
