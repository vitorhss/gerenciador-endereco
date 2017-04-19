package br.com.gerenciador.endereco.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity(name = "endereco")
public class Endereco {
	@Id
	@GeneratedValue
	@Column(updatable = false, insertable = true)
	private Integer id;

	@NotNull
	@Length(max = 50)
	private String lodradouro;

	@NotNull
	@Length(max = 50)
	private String cidade;

	@NotNull
	@Length(max = 2)
	private String estado;

	@NotNull
	@Length(max = 9)
	private String cep;

	@Length(max = 50)
	private String complemento;

	@Length(max = 50)
	private String bairro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLodradouro() {
		return lodradouro;
	}

	public void setLodradouro(String lodradouro) {
		this.lodradouro = lodradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

}