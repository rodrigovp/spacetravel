package br.com.elo7.spacetravel.dominio;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Ponto {

	private final int x;
	private final int y;
	
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Ponto somarCom(Ponto pontoParaSoma) {
		int x = this.x + pontoParaSoma.x;
		int y = this.y + pontoParaSoma.y;
		return new Ponto(x, y);
	}
}
