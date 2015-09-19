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
@Table(name = "pontuacoes")
public class Pontuacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "clube_vencedor", nullable = false)
	private Integer clubeVencedor;

	@Column(nullable = false)
	private Integer empate;

	@Column(name = "placar_exato", nullable = false)
	private Integer placarExato;

	@Column(name = "gol_um_clube", nullable = false)
	private Integer golUmClube;

	@ManyToOne
	@JoinColumn(name = "usuarios_jogos_palpites_id", referencedColumnName = "id")
	private UsuariosJogosPalpites usuariosJogosPalpitesId;

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClubeVencedor() {
		return clubeVencedor;
	}

	public void setClubeVencedor(Integer clubeVencedor) {
		this.clubeVencedor = clubeVencedor;
	}

	public Integer getEmpate() {
		return empate;
	}

	public void setEmpate(Integer empate) {
		this.empate = empate;
	}

	public Integer getPlacarExato() {
		return placarExato;
	}

	public void setPlacarExato(Integer placarExato) {
		this.placarExato = placarExato;
	}

	public Integer getGolUmClube() {
		return golUmClube;
	}

	public void setGolUmClube(Integer golUmClube) {
		this.golUmClube = golUmClube;
	}

	public UsuariosJogosPalpites getUsuariosJogosPalpitesId() {
		return usuariosJogosPalpitesId;
	}

	public void setUsuariosJogosPalpitesId(UsuariosJogosPalpites usuariosJogosPalpitesId) {
		this.usuariosJogosPalpitesId = usuariosJogosPalpitesId;
	}

}
