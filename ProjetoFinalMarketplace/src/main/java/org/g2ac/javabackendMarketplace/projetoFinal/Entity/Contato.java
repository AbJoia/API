package org.g2ac.javabackendMarketplace.projetoFinal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Contato")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_contato;
	@NotNull
	@Column(name = "ddd", nullable = false, length = 2)
	private String ddd;
	@Column(name = "fixo", nullable = true, length = 8)
	private String fixo;
	@Column(name = "movel", nullable = true, length = 9)
	private String movel;	

	public Integer getId_Contato() {
		return id_contato;
	}

	public String getDdd() {
		return ddd;
	}

	public String getFixo() {
		return fixo;
	}

	public String getMovel() {
		return movel;
	}	

	public void setId_Contato(Integer id_contato) {
		this.id_contato = id_contato;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public void setMovel(String movel) {
		this.movel = movel;
	}	

}
