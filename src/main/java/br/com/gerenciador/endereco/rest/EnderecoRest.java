package br.com.gerenciador.endereco.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciador.endereco.domain.Endereco;
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
	public ResponseEntity<Endereco> getEndereco( @PathVariable("cep") String cep){
		return responseOk(enderecoService.getEndereco(cep));
	}

}
