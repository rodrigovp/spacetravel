package br.com.elo7.spacetravel.dominio;

public enum Movimento {
	L("vire à esquerda") {
		@Override
		protected Ponto calcularNovoPonto(Ponto ponto, Ponto pontoParaSoma) {
			return ponto;
		}
	},
	R("vire à direita") {
		@Override
		protected Ponto calcularNovoPonto(Ponto ponto, Ponto pontoParaSoma) {
			return ponto;
		}
	},
	M("siga em frente") {
		@Override
		protected Ponto calcularNovoPonto(Ponto ponto, Ponto pontoParaSoma) {
			return ponto.somarCom(pontoParaSoma);
		}
	};

	protected abstract Ponto calcularNovoPonto(Ponto ponto, Ponto pontoParaSoma);
	
	private String instrucao;
	
	private Movimento(String instrucao) {
		this.instrucao = instrucao;
	}	
	
	@Override
	public String toString() {
		return instrucao;
	}
}
