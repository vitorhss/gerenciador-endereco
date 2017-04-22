package br.com.gerenciador.endereco.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.web.client.RestTemplate;

import br.com.gerenciador.endereco.builder.EnderecoBuilder;
import br.com.gerenciador.endereco.domain.Endereco;
import br.com.gerenciador.endereco.domain.Message;
import br.com.gerenciador.endereco.json.EnderecoJSON;
import br.com.gerenciador.endereco.repository.EnderecoRepository;

public class EnderecoServiceImplTest {
	@InjectMocks
	@Spy
	EnderecoServiceImpl enderecoService = new EnderecoServiceImpl();

	private EnderecoBuilder enderecoBuilder;

	private final String url = "http://api.postmon.com.br/v1/cep/{cep}";

	@Mock
	EnderecoRepository enderecoRepository;

	@Mock
	RestTemplate restTemplate;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		enderecoBuilder = new EnderecoBuilder();
	}

	@Test
	public void deveConsultarEnderecoPorCep() {
		String cep = "04377190";
		Map<String, String> params = new HashMap<String, String>();

		enderecoBuilder.withCep("04377190").withLogradouro("Rua Boçoroca").withBairro("Vila Mira")
				.withCidade("São Paulo").withEstado("SP");

		Endereco expectedEndereco = enderecoBuilder.build();
		when(restTemplate.getForObject(url, Endereco.class, params)).thenReturn(expectedEndereco);

		assertEquals(expectedEndereco, enderecoService.get(cep));
	}

	@Test
	public void deveIncluirEndereco() {

		enderecoBuilder.withCep("04377190").withLogradouro("Rua Boçoroca").withBairro("Vila Mira")
				.withCidade("São Paulo").withEstado("SP");

		Message message = new Message("Endereço incluido com sucesso");

		Endereco expectedEndereco = enderecoBuilder.build();

		EnderecoJSON enderecoJSON = new EnderecoJSON();
		enderecoJSON.setEndereco(expectedEndereco);

		when(enderecoRepository.save(expectedEndereco)).thenReturn(null);

		assertEquals(message, enderecoService.incluir(enderecoJSON));
		verify(enderecoRepository).save(expectedEndereco);
	}

	@Test
	public void deveListarEndereco() {
		List<Endereco> lstEnderecos = new ArrayList<Endereco>();

		when(enderecoRepository.findAll()).thenReturn(lstEnderecos);

		assertEquals(lstEnderecos, enderecoService.listar());
		verify(enderecoRepository).findAll();
	}

	@Test
	public void deveRemoverEndereco() {
		Integer idEndereco = 1;
		Message expectedMessage = new Message("Endereço removido com sucesso");

		when(enderecoRepository.exists(idEndereco)).thenReturn(true);

		assertEquals(expectedMessage, enderecoService.remover(idEndereco));
		verify(enderecoRepository).delete(idEndereco);
	}

	@Test
	public void deveAlterarEndereco() {
		Integer idEndereco = 1;
		
		EnderecoJSON enderecoJson = new EnderecoJSON();

		when(enderecoRepository.exists(idEndereco)).thenReturn(true);
		
		Endereco endereco  = enderecoBuilder
								.withCep("04377190")
								.withLogradouro("Rua Boçoroca")
								.withBairro("Vila Mira")
								.withCidade("São Paulo")
								.withEstado("SP")
								.build();
		
		when(enderecoRepository.findOne(idEndereco)).thenReturn(endereco);
		
		enderecoJson.setEndereco(endereco);
							
		assertEquals(endereco, enderecoService.alterar(idEndereco, enderecoJson));

	}
}
