package br.com.gerenciador.endereco.service;

import java.util.List;

import br.com.gerenciador.endereco.domain.Endereco;
import br.com.gerenciador.endereco.domain.Message;
import br.com.gerenciador.endereco.json.EnderecoJSON;

public interface EnderecoService {
	Endereco get(String cep);
	List<Endereco> listar();
	Message incluir(EnderecoJSON endereco);
	Endereco alterar(Integer idEndereco, EnderecoJSON endereco);
	Message remover(Integer idEndereco);
}
