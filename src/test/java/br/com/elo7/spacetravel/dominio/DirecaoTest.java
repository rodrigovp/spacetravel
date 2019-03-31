package br.com.elo7.spacetravel.dominio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DirecaoTest {
	
	@Test
	public void direcionar90GrausParaEsquerda() {
		Direcao direcao = Direcao.NORTE;
		assertThat(direcao.redirecionar(Movimento.L), is(equalTo(Direcao.OESTE)));
		
		direcao = Direcao.OESTE;
		assertThat(direcao.redirecionar(Movimento.L), is(equalTo(Direcao.SUL)));
		
		direcao = Direcao.SUL;
		assertThat(direcao.redirecionar(Movimento.L), is(equalTo(Direcao.LESTE)));
		
		direcao = Direcao.LESTE;
		assertThat(direcao.redirecionar(Movimento.L), is(equalTo(Direcao.NORTE)));
	}
	
	@Test
	public void direcionar90GrausParaDireita() {
		Direcao direcao = Direcao.NORTE;
		assertThat(direcao.redirecionar(Movimento.R), is(equalTo(Direcao.LESTE)));
		
		direcao = Direcao.OESTE;
		assertThat(direcao.redirecionar(Movimento.R), is(equalTo(Direcao.NORTE)));
		
		direcao = Direcao.SUL;
		assertThat(direcao.redirecionar(Movimento.R), is(equalTo(Direcao.OESTE)));
		
		direcao = Direcao.LESTE;
		assertThat(direcao.redirecionar(Movimento.R), is(equalTo(Direcao.SUL))); 
	}
	
	@Test
	public void manterADirecao() {
		Direcao direcao = Direcao.NORTE;
		assertThat(direcao.redirecionar(Movimento.M), is(equalTo(Direcao.NORTE)));
		
		direcao = Direcao.OESTE;
		assertThat(direcao.redirecionar(Movimento.M), is(equalTo(Direcao.OESTE)));
		
		direcao = Direcao.SUL;
		assertThat(direcao.redirecionar(Movimento.M), is(equalTo(Direcao.SUL)));
		
		direcao = Direcao.LESTE;
		assertThat(direcao.redirecionar(Movimento.M), is(equalTo(Direcao.LESTE))); 
	}
}
