package br.edu.fanor.progweb.arquitetura.manager.clube;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fanor.progweb.arquitetura.bussines.ClubeBO;
import br.edu.fanor.progweb.arquitetura.bussines.UsuarioBO;
import br.edu.fanor.progweb.arquitetura.entity.Clubes;
import br.edu.fanor.progweb.arquitetura.utils.MessagesUtils;
import br.edu.fanor.progweb.arquitetura.utils.Navigation;

@RequestScoped
@ManagedBean(name = "cadClube")
@Component(value = "cadClube")

public class CadClubeManager {

	@Autowired
	private ClubeBO clubeBO;
	private String nome;

	public String salvar() {
		Clubes clube = new Clubes();
		clube.setNome(nome);
		clubeBO.salvar(clube);
		MessagesUtils.info("clube salvo com sucesso!");
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
		this.nome = "";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
