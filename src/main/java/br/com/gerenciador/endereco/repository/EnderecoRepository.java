package br.com.gerenciador.endereco.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.gerenciador.endereco.domain.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {
	Endereco findByCep(String cep);
}
