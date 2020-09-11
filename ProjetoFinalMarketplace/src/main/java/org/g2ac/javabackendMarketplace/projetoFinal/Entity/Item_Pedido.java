package org.g2ac.javabackendMarketplace.projetoFinal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Item_Pedido")
public class Item_Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_item_pedido;
	
	@Valid
	@NotNull
	@ManyToOne
	@JoinColumn(name = "produto", referencedColumnName = "id_produto")
	private Produto produto;

	@NotNull
	@Column(name = "Quantidade", nullable = false, length = 10)
	private int quantidade;	
	

	public Integer getId_item_pedido() {
		return id_item_pedido;
	}

	public Produto getProduto() {
		return produto;
	}	

	public int getQuantidade() {
		return quantidade;
	}	

	public void setId_item_pedido(Integer id_item_pedido) {
		this.id_item_pedido = id_item_pedido;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}	

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}	
}
