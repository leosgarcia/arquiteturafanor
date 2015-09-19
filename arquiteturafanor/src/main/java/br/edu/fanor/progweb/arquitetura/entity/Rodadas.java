package br.edu.fanor.progweb.arquitetura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rodadas")
public class Rodadas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private Integer numero;

	@ManyToOne
	@JoinColumn(name = "campeonatos_id", referencedColumnName = "id")
	private Campeonatos campeonatosId;

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Campeonatos getCampeonatosId() {
		return campeonatosId;
	}

	public void setCampeonatosId(Campeonatos campeonatosId) {
		this.campeonatosId = campeonatosId;
	}

}
