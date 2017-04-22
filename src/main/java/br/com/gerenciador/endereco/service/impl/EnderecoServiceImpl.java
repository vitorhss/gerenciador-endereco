package br.com.gerenciador.endereco.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.gerenciador.endereco.domain.Endereco;
import br.com.gerenciador.endereco.domain.Message;
import br.com.gerenciador.endereco.exception.BusinessException;
import br.com.gerenciador.endereco.json.EnderecoJSON;
import br.com.gerenciador.endereco.repository.EnderecoRepository;
import br.com.gerenciador.endereco.service.EnderecoService;
import br.com.gerenciador.endereco.utils.Utils;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;

	final String url = "http://api.postmon.com.br/v1/cep/{cep}";

	@Override
	public Endereco get(String cep) {
		Endereco endereco = new Endereco();
		Integer count = 0;
		Integer inverseCount = cep.length() - 1;

		Map<String, String> params = new HashMap<String, String>();
		RestTemplate restTemplate = new RestTemplate();

		while (endereco.getCep() == null && cep.length() > count) {
			try {
				params.put("cep", cep);
				endereco = restTemplate.getForObject(url, Endereco.class, params);

			} catch (HttpClientErrorException ex) {

			} finally {
				cep = Utils.replaceToString(cep, inverseCount);
				count++;
				inverseCount--;
			}
		}

		if (endereco.getCep() == null) {
			throw new BusinessException("Cep inválido");
		}
		return endereco;
	}

	@Override
	public List<Endereco> listar() {
		return enderecoRepository.findAll();
	}

	@Override
	public Message incluir(EnderecoJSON endereco) {
		Endereco enderecoVerificado = get(endereco.getEndereco().getCep());
		
		if(enderecoRepository.findByCep(endereco.getEndereco().getCep()) != null){
			throw new BusinessException("Este cep já está cadastrado na base de endereços");
		}
		enderecoRepository.save(endereco.getEndereco());
		
		return new Message("Endereço incluido com sucesso");
	}

	@Override
	public Endereco alterar(Integer idEndereco, EnderecoJSON endereco) {
		validaEndereco(idEndereco);

		endereco.getEndereco().setId(idEndereco);

		enderecoRepository.save(endereco.getEndereco());

		return enderecoRepository.findOne(idEndereco);
	}

	@Override
	public Message remover(Integer idEndereco) {
		validaEndereco(idEndereco);
		
		enderecoRepository.delete(idEndereco);
		
		return new Message("Endereço removido com sucesso");
	}

	protected void validaEndereco(Integer idEndereco) {
		if (!enderecoRepository.exists(idEndereco)) {
			throw new ResourceNotFoundException("Não há um endereço correspondente ao ID informando");
		}
	}

}
