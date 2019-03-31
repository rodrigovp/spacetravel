package br.com.elo7.spacetravel.dominio;

import static java.util.Map.entry;

import java.util.Map;

public enum Direcao {
	NORTE(new Ponto(0, 1), Map.ofEntries(entry(Movimento.L, "OESTE"), entry(Movimento.R, "LESTE"), entry(Movimento.M, "NORTE"))),
	SUL(new Ponto(0, -1), Map.ofEntries(entry(Movimento.L, "LESTE"), entry(Movimento.R, "OESTE"), entry(Movimento.M, "SUL"))),
	LESTE(new Ponto(1, 0), Map.ofEntries(entry(Movimento.L, "NORTE"), entry(Movimento.R, "SUL"), entry(Movimento.M, "LESTE"))),
	OESTE(new Ponto(-1, 0), Map.ofEntries(entry(Movimento.L, "SUL"), entry(Movimento.R, "NORTE"), entry(Movimento.M, "OESTE")));
	
	private Ponto pontoParaSoma;
	private Map<Movimento, String> direcoes;
	
	private Direcao(Ponto pontoParaSoma, Map<Movimento, String> direcoes) {
		this.pontoParaSoma = pontoParaSoma;
		this.direcoes = direcoes;
	}
	
	public Direcao redirecionar(Movimento movimento) {
		String nomeDaDirecao = direcoes.get(movimento);
		return Direcao.valueOf(nomeDaDirecao);
	}

	public Ponto mover(Ponto ponto, Movimento movimento) {
		return movimento.calcularNovoPonto(ponto, pontoParaSoma);
	}
}
