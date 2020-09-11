package org.g2ac.javabackendMarketplace.projetoFinal.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	@NotNull
	@Column(name = "nome", nullable = false, length = 30)
	private String nome;
	@NotNull
	@Size(max = 11, min = 11) 
	@Column(name = "cpf", nullable = false, unique = true, length = 11)
	private String cpf;
	@NotNull
	@Column(name = "email", nullable = false, unique = true, length = 50)
	private String email;
	@NotNull
	@Column(name = "nome_usuario", nullable = false, unique = true, length = 15)
	private String nome_usuario;
	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data_nascimento;
	@Valid
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco", referencedColumnName = "id_endereco")
	private Endereco endereco;
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contato_id")
	private Contato contato;	
	

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Integer getId_Usuario() {
		return id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setId_Usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
