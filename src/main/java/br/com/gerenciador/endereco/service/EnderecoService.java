package br.com.gerenciador.endereco.service;

import java.util.List;

import br.com.gerenciador.endereco.domain.Endereco;

public interface EnderecoService {
	Endereco getEndereco(String cep);
	List<Endereco> listarEnderecos();
}
