package br.com.gerenciador.endereco.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciador.endereco.domain.Endereco;
import br.com.gerenciador.endereco.domain.Message;
import br.com.gerenciador.endereco.json.EnderecoJSON;
import br.com.gerenciador.endereco.service.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/enderecos")
@Api("Operações sobre endereços")
public class EnderecoRest extends AbstractRest {
	@Autowired
	private EnderecoService enderecoService;
	
	@ApiOperation("GET de endereço")
	@RequestMapping(value = "/{cep}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> getEndereco(@PathVariable("cep") String cep){
		return responseOk(enderecoService.get(cep));
	}
	
	@ApiOperation("Listagem de Endereços")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Endereco>> listar(){
		return responseOk(enderecoService.listar());
	}
	
	@ApiOperation("Inclusão de Endereço")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Message> incluir(@RequestBody EnderecoJSON endereco){
		return responseOk(enderecoService.incluir(endereco));
	}
	
	@ApiOperation("Alteração de Endereço")
	@RequestMapping(value = "/{idEndereco}", method = RequestMethod.PUT)
	public ResponseEntity<Endereco> alterar(
			@PathVariable("idEndereco") Integer idEndereco, 
			@RequestBody EnderecoJSON endereco){
		return responseOk(enderecoService.alterar(idEndereco, endereco));
	}
	
	@ApiOperation("Remoção de Endereço")
	@RequestMapping(value = "/{idEndereco}", method = RequestMethod.DELETE)
	public ResponseEntity<Message> remover(@PathVariable("idEndereco") Integer idEndereco){
		return responseOk(enderecoService.remover(idEndereco));
	}

}
