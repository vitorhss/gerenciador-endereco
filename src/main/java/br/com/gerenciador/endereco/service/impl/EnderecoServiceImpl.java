package br.com.gerenciador.endereco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciador.endereco.domain.Endereco;
import br.com.gerenciador.endereco.exception.BusinessException;
import br.com.gerenciador.endereco.repository.EnderecoRepository;
import br.com.gerenciador.endereco.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Endereco getEndereco(String cep) {
		if(!isValidCep(cep)){
			throw new BusinessException("O cep informado não é válido");
		}
		Endereco endereco = enderecoRepository.findByCep(cep); 
		
		return endereco;
	}
	
	private boolean isValidCep(String cep){
		return true;
	}

}
