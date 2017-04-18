package br.com.gerenciador.endereco.service;

import br.com.gerenciador.endereco.domain.Endereco;

public interface EnderecoService {
	Endereco getEndereco(String cep);
}
