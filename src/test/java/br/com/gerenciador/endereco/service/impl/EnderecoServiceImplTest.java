package br.com.gerenciador.endereco.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.gerenciador.endereco.builder.EnderecoBuilder;
import br.com.gerenciador.endereco.domain.Endereco;
import br.com.gerenciador.endereco.repository.EnderecoRepository;

public class EnderecoServiceImplTest {
	@InjectMocks
	@Spy
	EnderecoServiceImpl enderecoService = new EnderecoServiceImpl();
	
	private EnderecoBuilder enderecoBuilder;

	@Mock
	EnderecoRepository enderecoRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		enderecoBuilder = new EnderecoBuilder();
	}

	@Test
	public void deveConsultarEnderecoPorCep() {
		String cep = "04377190";

		enderecoBuilder
			.withCep("04377190")
			.withLogradouro("Rua Boçoroca")
			.withBairro("Vila Mira")
			.withCidade("São Paulo")
			.withEstado("SP");
										  
		Endereco expectedEndereco = enderecoBuilder.build();								
				
		assertEquals(expectedEndereco, enderecoService.get(cep));
	}

}
