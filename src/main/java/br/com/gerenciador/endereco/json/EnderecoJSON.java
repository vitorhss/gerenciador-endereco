package br.com.gerenciador.endereco.json;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.gerenciador.endereco.domain.Endereco;

public class EnderecoJSON {

	@Valid
	@NotNull
	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
