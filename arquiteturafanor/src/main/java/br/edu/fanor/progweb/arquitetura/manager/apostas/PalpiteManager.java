package br.edu.fanor.progweb.arquitetura.manager.apostas;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.edu.fanor.progweb.arquitetura.bussines.PalpiteBO;
import br.edu.fanor.progweb.arquitetura.dao.JogoDAO;
import br.edu.fanor.progweb.arquitetura.entity.Jogos;
import br.edu.fanor.progweb.arquitetura.entity.PalpiteDoUsuario;
import br.edu.fanor.progweb.arquitetura.entity.Palpites;
import br.edu.fanor.progweb.arquitetura.to.SegurancaTO;
import br.edu.fanor.progweb.arquitetura.utils.MessagesUtils;

@ViewScoped
@ManagedBean(name = "palpites")
public class PalpiteManager {

	@ManagedProperty("#{palpiteBO}")
	private PalpiteBO palpiteBO;
	
	@ManagedProperty("#{jogoDAO}")
	private JogoDAO jogoDao;
	
	@ManagedProperty("#{segurancaTO}")
	private SegurancaTO segurancaTO;
	
	private PalpiteDoUsuario palpite;
	
	private List<Jogos> jogos = new ArrayList<>();
	
	private List<PalpiteDoUsuario> palpitesDoUsuario = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		this.reseta();
		this.jogos = jogoDao.listaTodos();
	}
	
	public void adicionaNovoPalpite() {
		
		palpite.setJogo(recarrega(palpite.getJogo()));
		palpite.setUsuario(segurancaTO.getUsuario());
		
		this.palpitesDoUsuario.add(palpite);
		this.reseta(); // limpa formulario
	}
	
	public String gravarPalpites() {
		palpiteBO.salvar(palpitesDoUsuario);
		this.reseta(); // limpa formulario
		MessagesUtils.info("Apostas feitas com sucesso!");
		return "/pages/usuario/palpites.xhtml?faces-redirect=true";
	}
	
	public void remove(PalpiteDoUsuario palpiteSelecionado) {
//		palpiteBO.remove(palpiteSelecionado);
		// remover da lista
		this.palpitesDoUsuario.remove(palpiteSelecionado);
	}
	
	private Jogos recarrega(Jogos jogo) {
		return jogoDao.buscaPorId(jogo.getId());
	}
	
	private void reseta() {
		this.palpite = new PalpiteDoUsuario();
		this.palpite.setJogo(new Jogos());
		this.palpite.setPalpite(new Palpites());
	}


	public PalpiteDoUsuario getPalpite() {
		return palpite;
	}
	public void setPalpite(PalpiteDoUsuario palpite) {
		this.palpite = palpite;
	}
	public List<Jogos> getJogos() {
		return jogos;
	}
	public void setJogos(List<Jogos> jogos) {
		this.jogos = jogos;
	}
	public List<PalpiteDoUsuario> getPalpitesDoUsuario() {
		return palpitesDoUsuario;
	}
	public void setPalpitesDoUsuario(List<PalpiteDoUsuario> palpitesDoUsuario) {
		this.palpitesDoUsuario = palpitesDoUsuario;
	}
	public void setPalpiteBO(PalpiteBO palpiteBO) {
		this.palpiteBO = palpiteBO;
	}
	public void setJogoDao(JogoDAO jogoDao) {
		this.jogoDao = jogoDao;
	}
	public void setSegurancaTO(SegurancaTO segurancaTO) {
		this.segurancaTO = segurancaTO;
	}
	
}
