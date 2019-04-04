package br.com.elo7.spacetravel.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.elo7.spacetravel.dominio.Direcao;
import br.com.elo7.spacetravel.dominio.Movimento;
import br.com.elo7.spacetravel.dominio.Ponto;
import br.com.elo7.spacetravel.dominio.SondaEspacial;
import br.com.elo7.spacetravel.service.SondaEspacialService;

public class SondaEspacialController {

	private final SondaEspacialService service;
	
	public SondaEspacialController(SondaEspacialService service) {
		this.service = service;
	}

	public SondaEspacial executarSonda(String x, String y, String idDirecao, String movimentosString) {
		int coordenadaX = Integer.valueOf(x);
		int coordenadaY = Integer.valueOf(y);
		Ponto pontoInicial = new Ponto(coordenadaX, coordenadaY);
		Direcao direcaoInicial = Direcao.identificadaPor(idDirecao);
		List<Movimento> movimentos = lerMovimentos(movimentosString);
		return service.criarEMovimentarSonda(direcaoInicial, pontoInicial, movimentos);
	}

	private List<Movimento> lerMovimentos(String movimentosString) {
		List<Movimento> movimentos = new ArrayList<>();
		movimentosString.chars().forEachOrdered(i -> {
			String movimentoString = Character.toString((char)i);
			movimentos.add(Movimento.valueOf(movimentoString));
		});
		return movimentos;
	}

}
