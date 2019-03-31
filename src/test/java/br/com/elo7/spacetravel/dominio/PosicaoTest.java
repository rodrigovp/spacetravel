package br.com.elo7.spacetravel.dominio;

import static br.com.elo7.spacetravel.dominio.Movimento.L;
import static br.com.elo7.spacetravel.dominio.Movimento.M;
import static br.com.elo7.spacetravel.dominio.Movimento.R;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PosicaoTest {
	
	@Test
	public void reposicionar90GrausAEsquerda() {
		Ponto pontoInicial = new Ponto(0, 0);
		Posicao posicaoInicial = new Posicao(Direcao.NORTE, pontoInicial);
		Posicao novaPosicao = posicaoInicial.reposicionar(L);
		
		Posicao posicaoEsperada = new Posicao(Direcao.OESTE, pontoInicial);
		assertThat(novaPosicao, is(equalTo(posicaoEsperada)));
	}
	
	@Test
	public void reposicionar90GrausADireita() {
		Ponto pontoInicial = new Ponto(0, 0);
		Posicao posicaoInicial = new Posicao(Direcao.NORTE, pontoInicial);
		Posicao novaPosicao = posicaoInicial.reposicionar(R);
		
		Posicao posicaoEsperada = new Posicao(Direcao.LESTE, pontoInicial);
		assertThat(novaPosicao, is(equalTo(posicaoEsperada)));
	}
	
	@Test
	public void reposicionarParaUmNovoPonto() {
		Posicao posicaoInicial = new Posicao(Direcao.NORTE, new Ponto(0, 0));
		Posicao novaPosicao = posicaoInicial.reposicionar(M);
		
		Posicao posicaoEsperada = new Posicao(Direcao.NORTE, new Ponto(0, 1));
		assertThat(novaPosicao, is(equalTo(posicaoEsperada)));
	}
	
	//LM LM LM LMM
	@Test
	public void executarOTesteDaPrimeiraSondaExemplificadaNaDescricaoDoTeste() {
		Posicao posicaoInicial = new Posicao(Direcao.NORTE, new Ponto(1, 2));
		Posicao novaPosicao = posicaoInicial
				.reposicionar(L).reposicionar(M)
				.reposicionar(L).reposicionar(M)
				.reposicionar(L).reposicionar(M)
				.reposicionar(L).reposicionar(M).reposicionar(M);
		
		Posicao posicaoEsperada = new Posicao(Direcao.NORTE, new Ponto(1, 3));
		assertThat(novaPosicao, is(equalTo(posicaoEsperada)));
	}
	
	//MMR MMR MRR M
	@Test
	public void executarOTesteDaSegundaSondaExemplificadaNaDescricaoDoTeste() {
		Posicao posicaoInicial = new Posicao(Direcao.LESTE, new Ponto(3, 3));
		Posicao novaPosicao = posicaoInicial
				.reposicionar(M).reposicionar(M).reposicionar(R)
				.reposicionar(M).reposicionar(M).reposicionar(R)
				.reposicionar(M).reposicionar(R).reposicionar(R)
				.reposicionar(M);
		
		Posicao posicaoEsperada = new Posicao(Direcao.LESTE, new Ponto(5, 1));
		assertThat(novaPosicao, is(equalTo(posicaoEsperada)));
	}
	
	@Test
	public void igualdadeDePosicoes() {
		Direcao direcao = Direcao.LESTE;
		Ponto ponto = new Ponto(4, 4);
		Posicao umaPosicao = new Posicao(direcao, ponto);
		Posicao outraPosicao = new Posicao(direcao, ponto);
		
		assertThat(umaPosicao, is(equalTo(outraPosicao)));
		assertThat(umaPosicao.hashCode(), is(equalTo(outraPosicao.hashCode())));
	}
}
