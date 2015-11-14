package br.edu.fanor.progweb.arquitetura.manager.apostas;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fanor.progweb.arquitetura.bussines.PalpiteBO;
import br.edu.fanor.progweb.arquitetura.entity.Palpites;
import br.edu.fanor.progweb.arquitetura.utils.MessagesUtils;
import br.edu.fanor.progweb.arquitetura.utils.Navigation;

@RequestScoped
@ManagedBean(name = "realizarApostas")
@Component(value = "realizarApostas")
public class PalpitesManager {

	@Autowired
	private PalpiteBO palpitesBO;
	private Integer placarCasa;
	private Integer placarVisitante;
	private String equipeCasa;
	private String equipeVisitante;

	public String salvar() {
		Palpites palpites = new Palpites();
		palpites.setPlacarVisitante(placarVisitante);
		palpitesBO.salvar(palpites);
		MessagesUtils.info("palpites salvo com sucesso!");
		return Navigation.SUCESSO;
	}

	public String preparaSalvar() {
		this.limpaDados();
		return Navigation.CADASTRO;
	}

	public String voltar() {
		return Navigation.VOLTAR;
	}

	public void limpaDados() {
		this.placarVisitante = 0;
		this.placarCasa = 0;
		this.equipeCasa = "";
		this.equipeVisitante = "";
	}

	public PalpiteBO getPalpitesBO() {
		return palpitesBO;
	}

	public void setPalpitesBO(PalpiteBO palpitesBO) {
		this.palpitesBO = palpitesBO;
	}

	public int getPlacarCasa() {
		return placarCasa;
	}

	public void setPlacarCasa(Integer placarCasa) {
		this.placarCasa = placarCasa;
	}

	public int getPlacarVisitante() {
		return placarVisitante;
	}

	public void setPlacarVisitante(Integer placarVisitante) {
		this.placarVisitante = placarVisitante;
	}

	public String getEquipeCasa() {
		return equipeCasa;
	}

	public void setEquipeCasa(String equipeCasa) {
		this.equipeCasa = equipeCasa;
	}

	public String getEquipeVisitante() {
		return equipeVisitante;
	}

	public void setEquipeVisitante(String equipeVisitante) {
		this.equipeVisitante = equipeVisitante;
	}

	

}
