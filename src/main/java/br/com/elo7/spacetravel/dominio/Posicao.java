package br.com.elo7.spacetravel.dominio;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Posicao {

	private final Direcao direcao;
	private final Ponto ponto;
	
	public Posicao(Direcao direcao, Ponto ponto) {
		this.direcao = direcao;
		this.ponto = ponto;
	}

	public Posicao reposicionar(Movimento movimento) {
		Direcao novaDirecao = direcao.redirecionar(movimento);
		Ponto novoPonto = novaDirecao.mover(ponto, movimento);
		
		return new Posicao(novaDirecao, novoPonto);
	}
}
