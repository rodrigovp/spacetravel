package br.com.elo7.spacetravel.service;

import java.util.List;

import br.com.elo7.spacetravel.dominio.Direcao;
import br.com.elo7.spacetravel.dominio.Movimento;
import br.com.elo7.spacetravel.dominio.Ponto;
import br.com.elo7.spacetravel.dominio.Posicao;
import br.com.elo7.spacetravel.dominio.SondaEspacial;

public class SondaEspacialService {

	public SondaEspacial criarEMovimentarSonda(Direcao direcaoInicial, Ponto pontoInicial, List<Movimento> movimentos) {
		SondaEspacial sonda = new SondaEspacial(new Posicao(direcaoInicial, pontoInicial));
		movimentos.stream().forEach(movimento -> {
			sonda.movimentar(movimento);
		});
		return sonda;
	}

}
