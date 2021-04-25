package com.orangetalents.restapi.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.)
	@ApiModelProperty(hidden = true)
	private long id;

	@Column(name = "nome", nullable = false)
	@Length(min = 2, max = 50)
	private String nome;

	@Column(name = "email", nullable = false, unique=true)
	@Email
	private String email;

	@Column(name = "cpf", nullable = false, unique=true)
	@CPF
	private String cpf;

	@Column(name = "data_nascimento", nullable = false)
	private String dataNascimento;

	// Relacionamento
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ApiModelProperty(hidden = true)
	private Set<Endereco> enderecos;

	public Usuario() {
	}

	public Usuario(long id,
				   String nome,
				   String email,
				   String cpf,
				   String dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public Usuario(String nome,
				   String email,
				   String cpf,
				   String dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
