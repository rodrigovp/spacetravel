package br.com.elo7.spacetravel.dominio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MovimentoTest {

	@Test
	public void calcularNovoPonto() {
		Ponto ponto = new Ponto(0, 0);
		Ponto pontoParaSoma = new Ponto(10, 10);
		
		Ponto pontoObtido = Movimento.L.calcularNovoPonto(ponto, pontoParaSoma);
		assertThat(pontoObtido, is(equalTo(ponto)));
		
		pontoObtido = Movimento.R.calcularNovoPonto(ponto, pontoParaSoma);
		assertThat(pontoObtido, is(equalTo(ponto)));
		
		pontoObtido = Movimento.M.calcularNovoPonto(ponto, pontoParaSoma);
		assertThat(pontoObtido, is(equalTo(pontoParaSoma)));
	}
}
