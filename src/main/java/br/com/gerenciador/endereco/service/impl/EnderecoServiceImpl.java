package br.com.gerenciador.endereco.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciador.endereco.domain.Endereco;
import br.com.gerenciador.endereco.exception.BusinessException;
import br.com.gerenciador.endereco.repository.EnderecoRepository;
import br.com.gerenciador.endereco.service.EnderecoService;
import br.com.gerenciador.endereco.utils.Utils;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Endereco getEndereco(String cep) {
		Endereco endereco = new Endereco();

		if (!Utils.isValidCep(cep)) {
			throw new BusinessException("O cep informado não é válido");
		}

		endereco = enderecoRepository.findByCep(cep);

		return endereco;
	}

	@Override
	public List<Endereco> listarEnderecos() {
		return enderecoRepository.findAll();
	}

}
