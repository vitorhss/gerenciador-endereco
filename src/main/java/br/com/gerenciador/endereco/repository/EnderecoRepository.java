package br.com.gerenciador.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador.endereco.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	Endereco findByCep(String cep);
}
