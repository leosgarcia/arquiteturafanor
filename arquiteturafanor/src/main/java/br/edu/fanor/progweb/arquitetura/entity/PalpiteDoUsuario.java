package br.edu.fanor.progweb.arquitetura.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios_jogos_palpites")
public class PalpiteDoUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "usuarios_id", referencedColumnName = "id")
	private Usuarios usuario;

	@ManyToOne
	@JoinColumn(name = "jogos_id", referencedColumnName = "id")
	private Jogos jogo;

	@ManyToOne
	@JoinColumn(name = "palpites_id", referencedColumnName = "id")
	private Palpites palpite;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Jogos getJogo() {
		return jogo;
	}

	public void setJogo(Jogos jogo) {
		this.jogo = jogo;
	}

	public Palpites getPalpite() {
		return palpite;
	}

	public void setPalpite(Palpites palpite) {
		this.palpite = palpite;
	}

}
