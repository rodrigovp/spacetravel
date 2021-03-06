package br.com.elo7.spacetravel.service;

import static br.com.elo7.spacetravel.dominio.Movimento.L;
import static br.com.elo7.spacetravel.dominio.Movimento.M;
import static br.com.elo7.spacetravel.dominio.Movimento.R;
import static br.com.elo7.spacetravel.dominio.PosicaoTest.POSICAO_PRIMEIRO_EXEMPLO_DESCRITO;
import static br.com.elo7.spacetravel.dominio.PosicaoTest.POSICAO_SEGUNDO_EXEMPLO_DESCRITO;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.elo7.spacetravel.dominio.Direcao;
import br.com.elo7.spacetravel.dominio.Movimento;
import br.com.elo7.spacetravel.dominio.Ponto;
import br.com.elo7.spacetravel.dominio.SondaEspacial;

public class SondaEspacialServiceTest {

	private SondaEspacialService service;
	
	@Before
	public void setUp() {
		service = new SondaEspacialService();
	}
	
	@Test
	public void sondaEspacialQueUsaOsDadosDoPrimeiroExemplo() {
		Direcao direcaoInicial = Direcao.NORTE;
		Ponto pontoInicial = new Ponto(1, 2);
		List<Movimento> movimentos = Arrays.asList(L, M, L, M, L, M, L, M, M); 
		
		SondaEspacial sonda = service.criarEMovimentarSonda(direcaoInicial, pontoInicial, movimentos);
		
		assertThat(sonda.lerPosicaoAtual(), is(equalTo(POSICAO_PRIMEIRO_EXEMPLO_DESCRITO)));
	}
	
	@Test
	public void sondaEspacialQueUsaOsDadosDoSegundoExemplo() {
		Direcao direcaoInicial = Direcao.LESTE;
		Ponto pontoInicial = new Ponto(3, 3);
		List<Movimento> movimentos = Arrays.asList(M, M, R, M, M, R, M, R, R, M); 
		
		SondaEspacial sonda = service.criarEMovimentarSonda(direcaoInicial, pontoInicial, movimentos);
		
		
		assertThat(sonda.lerPosicaoAtual(), is(equalTo(POSICAO_SEGUNDO_EXEMPLO_DESCRITO)));
	}
}
