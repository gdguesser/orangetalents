package com.orangetalents.restapi.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "enderecos")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private Long id;

	@Column(name = "logradouro")
	@ApiModelProperty(hidden = true)
	private String logradouro;

	@Column(name = "numero", nullable = false)
	private String numero;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "bairro")
	@ApiModelProperty(hidden = true)
	private String bairro;

	@Column(name = "localidade")
	@ApiModelProperty(hidden = true)
	private String localidade;

	@Column(name = "estado")
	@Length(min = 2, max = 20)
	@ApiModelProperty(hidden = true)
	private String uf;

	@Column(name = "cep", nullable = false)
	@Pattern(regexp = "[0-9]{5}-[0-9]{3}")
	private String cep;

	@Column(name = "user_id", nullable = false)
	private Long userId;

	public Endereco() {
	}

	public Endereco(String logradouro,
					String numero,
					String complemento,
					String bairro,
					String localidade,
					String uf,
					String cep) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.cep = cep;
	}

	public Endereco(Long id,
					String logradouro,
					String numero,
					String complemento,
					String bairro,
					String localidade,
					String uf,
					String cep){
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
    public String toString() {
        return "Endereco{" +
        		"id='" + id + '\'' +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", estado='" + localidade + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
