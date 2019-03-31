package br.com.elo7.spacetravel.dominio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PontoTest {
	
	@Test
	public void somarPontoComPontoQueAlteraACoordenadaX() {
		Ponto umPonto = new Ponto(0, 0);
		
		Ponto soma = new Ponto(1, 0);
		Ponto novoPonto = umPonto.somarCom(soma);
		assertThat(novoPonto, is(equalTo(soma)));
		
		soma = new Ponto(-1, 0);
		novoPonto = novoPonto.somarCom(soma);
		assertThat(novoPonto, is(equalTo(umPonto)));
	}
	
	@Test
	public void somarPontoComPontoQueAlteraACoordenadaY() {
		Ponto umPonto = new Ponto(0, 0);
		
		Ponto soma = new Ponto(0, 1);
		Ponto novoPonto = umPonto.somarCom(soma);
		assertThat(novoPonto, is(equalTo(soma)));
		
		soma = new Ponto(0, -1);
		novoPonto = novoPonto.somarCom(soma);
		assertThat(novoPonto, is(equalTo(umPonto)));
	}
}
