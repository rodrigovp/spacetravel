package br.com.elo7.spacetravel.dominio;

import static java.util.Map.entry;

import java.util.EnumSet;
import java.util.Map;

public enum Direcao {
	NORTE("N", new Ponto(0, 1), Map.ofEntries(entry(Movimento.L, "OESTE"), entry(Movimento.R, "LESTE"), entry(Movimento.M, "NORTE"))),
	SUL("S", new Ponto(0, -1), Map.ofEntries(entry(Movimento.L, "LESTE"), entry(Movimento.R, "OESTE"), entry(Movimento.M, "SUL"))),
	LESTE("E", new Ponto(1, 0), Map.ofEntries(entry(Movimento.L, "NORTE"), entry(Movimento.R, "SUL"), entry(Movimento.M, "LESTE"))),
	OESTE("W", new Ponto(-1, 0), Map.ofEntries(entry(Movimento.L, "SUL"), entry(Movimento.R, "NORTE"), entry(Movimento.M, "OESTE")));
	
	private String identificacao;
	private Ponto pontoParaSoma;
	private Map<Movimento, String> direcoes;
	
	private Direcao(String identificacao, Ponto pontoParaSoma, Map<Movimento, String> direcoes) {
		this.identificacao = identificacao;
		this.pontoParaSoma = pontoParaSoma;
		this.direcoes = direcoes;
	}
	
	public Posicao redirecionar2(Ponto pontoAtual, Movimento movimento) {
		Direcao direcao = redirecionar(movimento);
		Ponto novoPonto = mover(pontoAtual, movimento);
		return new Posicao(direcao, novoPonto);
	}
	
	public Direcao redirecionar(Movimento movimento) {
		String nomeDaDirecao = direcoes.get(movimento);
		return Direcao.valueOf(nomeDaDirecao);
	}

	public Ponto mover(Ponto ponto, Movimento movimento) {
		return movimento.calcularNovoPonto(ponto, pontoParaSoma);
	}

	public static Direcao identificadaPor(String identificacao) {
		return EnumSet.allOf(Direcao.class).stream()
				.filter(direcao -> direcao.identificacao.equals(identificacao))
				.findFirst().get();
	}
	
	
}
