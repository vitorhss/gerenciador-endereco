package br.com.gerenciador.endereco.builder;

import br.com.gerenciador.endereco.domain.Endereco;

public class EnderecoBuilder {
	private Integer id;
	
	private String logradouro;
	
	private String cidade;
	
	private String estado;
	
	private String cep;
	
	private String complemento;
	
	private String bairro;
	
	public EnderecoBuilder withLogradouro(String logradouro){
		this.logradouro = logradouro;
		return this;
	}
	
	public EnderecoBuilder withCidade(String cidade){
		this.cidade = cidade;
		return this;
	}
	
	public EnderecoBuilder withEstado(String estado){
		this.estado = estado;
		return this;
	}
	
	public EnderecoBuilder withCep(String cep){
		this.cep = cep;
		return this;
	}
	
	public EnderecoBuilder withComplemento(String complemento){
		this.complemento = complemento;
		return this;
	}
	
	public EnderecoBuilder withBairro(String bairro){
		this.bairro = bairro;
		return this;
	}
	
	public Endereco build(){
		Endereco endereco = new Endereco();
		
		endereco.setId(id);
		endereco.setLogradouro(logradouro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setCep(cep);
		endereco.setComplemento(complemento);
		endereco.setBairro(bairro);
		
		return endereco;
	}
}
