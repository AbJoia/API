package org.g2ac.javabackendMarketplace.projetoFinal.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pedido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
	private Date data_Pedido;	
	
	@ManyToOne
	@JoinColumn(name = "usuario_comprador", referencedColumnName = "id_usuario")
	private Usuario usuario_Comprador;	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id_Pedido")	
	private Set<Item_Pedido> itensPedido;	

	public Usuario getUsuario_Comprador() {
		return usuario_Comprador;
	}	

	public void setUsuario_Comprador(Usuario usuario_Comprador) {
		this.usuario_Comprador = usuario_Comprador;
	}	

	public Set<Item_Pedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(Set<Item_Pedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public Integer getId_Pedido() {
		return id_pedido;
	}

	public Date getData_Pedido() {
		return data_Pedido;
	}

	public Usuario getUsuario() {
		return usuario_Comprador;
	}

	public void setId_Pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}

	public void setData_Pedido(Date data_Pedido) {
		this.data_Pedido = data_Pedido;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario_Comprador = usuario;
	}

}
