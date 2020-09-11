package org.g2ac.javabackendMarketplace.projetoFinal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_categoria;
	@NotNull
	@Column(name = "nome", nullable = false, length = 30)
	private String nome;

	@Column(name = "descricao", nullable = false, length = 150)
	private String descricao;

	public Integer getId_Categoria() {
		return id_categoria;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId_Categoria(Integer id_Categoria) {
		this.id_categoria = id_Categoria;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
