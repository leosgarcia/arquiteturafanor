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
public class UsuariosJogosPalpites {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "usuarios_id", referencedColumnName = "id")
	private Usuarios usuariosId;

	@ManyToOne
	@JoinColumn(name = "jogos_id", referencedColumnName = "id")
	private Jogos jogosId;

	@ManyToOne
	@JoinColumn(name = "palpites_id", referencedColumnName = "id")
	private Palpites palpitesId;

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuarios getUsuariosId() {
		return usuariosId;
	}

	public void setUsuariosId(Usuarios usuariosId) {
		this.usuariosId = usuariosId;
	}

	public Jogos getJogosId() {
		return jogosId;
	}

	public void setJogosId(Jogos jogosId) {
		this.jogosId = jogosId;
	}

	public Palpites getPalpitesId() {
		return palpitesId;
	}

	public void setPalpitesId(Palpites palpitesId) {
		this.palpitesId = palpitesId;
	}

}
