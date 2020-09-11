package org.g2ac.javabackendMarketplace.projetoFinal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_endereco;
	@NotNull
	@Column(name = "rua", nullable = false, length = 40)
	private String rua;
	@NotNull
	@Column(name = "numero", nullable = false, length = 15)
	private String numero;
	@NotNull
	@Column(name = "bairro", nullable = false, length = 30)
	private String bairro;
	@NotNull
	@Column(name = "cidade", nullable = false, length = 40)
	private String cidade;
	@NotNull	
	@Size(min=2, max=2)
	@Column(name = "estado", nullable = false, length = 2)
	private String estado;
	@NotNull
	@Size(max = 8)
	@Column(name = "cep", nullable = false, length = 8)
	private String cep;	

	public Integer getId_Endereco() {
		return id_endereco;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}	

	public String getCep() {
		return cep;
	}	

	public void setId_Endereco(Integer id_endereco) {
		this.id_endereco = id_endereco;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}

}
