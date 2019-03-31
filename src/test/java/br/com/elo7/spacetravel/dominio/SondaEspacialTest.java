package br.com.elo7.spacetravel.dominio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SondaEspacialTest {
	
	@Test
	public void movimentarSonda() {
		Ponto ponto = new Ponto(15, 2);
		Posicao posicao = new Posicao(Direcao.NORTE, ponto);
		SondaEspacial sonda = new SondaEspacial(posicao);
		
		sonda.movimentar(Movimento.L);
		
		Posicao posicaoAtualDaSonda = sonda.lerPosicaoAtual();
		Posicao posicaoEsperada = new Posicao(Direcao.OESTE, ponto);
		
		assertThat(posicaoAtualDaSonda, is(equalTo(posicaoEsperada)));
	}
}
