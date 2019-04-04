package br.com.elo7.spacetravel.dominio;

public class SondaEspacial {
	
	private Posicao posicaoAtual;
	
	public SondaEspacial(Posicao posicaoInicial) {
		this.posicaoAtual = posicaoInicial;
	}

	public void movimentar(Movimento movimento) {
		posicaoAtual = posicaoAtual.reposicionar(movimento);
	}

	public Posicao lerPosicaoAtual() {
		return posicaoAtual;
	}
}
