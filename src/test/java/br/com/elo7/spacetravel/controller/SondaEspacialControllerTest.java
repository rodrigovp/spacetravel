package br.com.elo7.spacetravel.controller;

import static br.com.elo7.spacetravel.dominio.Movimento.L;
import static br.com.elo7.spacetravel.dominio.Movimento.M;
import static br.com.elo7.spacetravel.dominio.Movimento.R;
import static br.com.elo7.spacetravel.dominio.PosicaoTest.POSICAO_PRIMEIRO_EXEMPLO_DESCRITO;
import static br.com.elo7.spacetravel.dominio.PosicaoTest.POSICAO_SEGUNDO_EXEMPLO_DESCRITO;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.elo7.spacetravel.dominio.Direcao;
import br.com.elo7.spacetravel.dominio.Movimento;
import br.com.elo7.spacetravel.dominio.Ponto;
import br.com.elo7.spacetravel.dominio.SondaEspacial;
import br.com.elo7.spacetravel.service.SondaEspacialService;

public class SondaEspacialControllerTest {
	
	private SondaEspacialController controller;
	private SondaEspacialService service;
	
	@Before
	public void setUp() {
		service = mock(SondaEspacialService.class);
		controller = new SondaEspacialController(service);
	}
	
	@Test
	public void executarSondaComDadosDoPrimeiroExemplo() {
		List<Movimento> movimentos = Arrays.asList(L, M, L, M, L, M, L, M, M); 
		
		SondaEspacial sondaEsperada = new SondaEspacial(POSICAO_PRIMEIRO_EXEMPLO_DESCRITO);
		when(service.criarEMovimentarSonda(Direcao.NORTE, new Ponto(1, 2), movimentos)).thenReturn(sondaEsperada);
		SondaEspacial sonda = controller.executarSonda("1", "2", "N", "LMLMLMLMM");
		
		assertThat(sonda, is(equalTo(sondaEsperada)));
		
		assertThat(sonda.lerPosicaoAtual(), is(equalTo(POSICAO_PRIMEIRO_EXEMPLO_DESCRITO)));
	}
	
	@Test
	public void executarSondaComDadosDoSegundoExemplo() {
		List<Movimento> movimentos = Arrays.asList(M, M, R, M, M, R, M, R, R, M); 
		
		SondaEspacial sondaEsperada = new SondaEspacial(POSICAO_SEGUNDO_EXEMPLO_DESCRITO);
		when(service.criarEMovimentarSonda(Direcao.LESTE, new Ponto(3, 3), movimentos)).thenReturn(sondaEsperada);
		SondaEspacial sonda = controller.executarSonda("3", "3", "E", "MMRMMRMRRM");
		
		assertThat(sonda, is(equalTo(sondaEsperada)));
		
		assertThat(sonda.lerPosicaoAtual(), is(equalTo(POSICAO_SEGUNDO_EXEMPLO_DESCRITO)));
	}
}
