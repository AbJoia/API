package org.g2ac.javabackendMarketplace.projetoFinal.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_produto;
	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
	private Date data_fabricacao;
	@NotNull
	@Digits(integer = 99999999, fraction = 2)
	@Column(name = "valor_unidade", nullable = false)
	private Double valor_unidade;
	@NotNull
	@Column(name = "quantidade_unidade", nullable = false)
	private Integer quantidade_estoque;
	@NotNull
	@Column(name = "descricao", nullable = false, length = 150)
	private String descricao;
	@NotNull
	@Column(name = "nome", nullable = false, length = 30)
	private String nome_produto;
	
	@ManyToOne()
	@JoinColumn(name = "usuario_vendedor", referencedColumnName = "id_usuario")
	private Usuario usuario_vendedor;

	@ManyToOne()
	@JoinColumn(name = "categoria", referencedColumnName = "id_categoria")
	private Categoria categoria;

	public Integer getId_produto() {
		return id_produto;
	}

	public Date getData_fabricacao() {
		return data_fabricacao;
	}

	public Double getValor_unidade() {
		return valor_unidade;
	}

	public Integer getQuantidade_estoque() {
		return quantidade_estoque;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public Usuario getUsuario_vendedor() {
		return usuario_vendedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public void setData_fabricacao(Date data_fabricacao) {
		this.data_fabricacao = data_fabricacao;
	}

	public void setValor_unidade(Double valor_unidade) {
		this.valor_unidade = valor_unidade;
	}

	public void setQuantidade_estoque(Integer quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public void setUsuario_vendedor(Usuario usuario_vendedor) {
		this.usuario_vendedor = usuario_vendedor;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
