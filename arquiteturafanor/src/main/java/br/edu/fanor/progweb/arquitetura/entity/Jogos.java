package br.edu.fanor.progweb.arquitetura.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jogos")
public class Jogos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "data_jogo", nullable = false)
	private Date dataJogo;

	@Column(name = "placar_casa")
	private Integer placarCasa;

	@Column(name = "placar_visitante")
	private Integer placarVisitante;

	@ManyToOne
	@JoinColumn(name = "clubes_casa_id", referencedColumnName = "id")
	private Clubes clubesCasaId;

	@ManyToOne
	@JoinColumn(name = "clubes_visitante_id", referencedColumnName = "id")
	private Clubes clubesVisitanteId;

	@ManyToOne
	@JoinColumn(name = "rodadas_id", referencedColumnName = "id")
	private Rodadas rodadasId;

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataJogo() {
		return dataJogo;
	}

	public void setDataJogo(Date dataJogo) {
		this.dataJogo = dataJogo;
	}

	public Integer getPlacarCasa() {
		return placarCasa;
	}

	public void setPlacarCasa(Integer placarCasa) {
		this.placarCasa = placarCasa;
	}

	public Integer getPlacarVisitante() {
		return placarVisitante;
	}

	public void setPlacarVisitante(Integer placarVisitante) {
		this.placarVisitante = placarVisitante;
	}

	public Clubes getClubesCasaId() {
		return clubesCasaId;
	}

	public void setClubesCasaId(Clubes clubesCasaId) {
		this.clubesCasaId = clubesCasaId;
	}

	public Clubes getClubesVisitanteId() {
		return clubesVisitanteId;
	}

	public void setClubesVisitanteId(Clubes clubesVisitanteId) {
		this.clubesVisitanteId = clubesVisitanteId;
	}

	public Rodadas getRodadasId() {
		return rodadasId;
	}

	public void setRodadasId(Rodadas rodadasId) {
		this.rodadasId = rodadasId;
	}

}
