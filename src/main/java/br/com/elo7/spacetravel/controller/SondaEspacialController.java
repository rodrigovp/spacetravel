package br.com.elo7.spacetravel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.elo7.spacetravel.dominio.Direcao;
import br.com.elo7.spacetravel.dominio.Movimento;
import br.com.elo7.spacetravel.dominio.Ponto;
import br.com.elo7.spacetravel.dominio.SondaEspacial;
import br.com.elo7.spacetravel.service.SondaEspacialService;

@RestController
@RequestMapping("/sonda")
public class SondaEspacialController {

	private final SondaEspacialService service;
	
	@Autowired
	public SondaEspacialController(SondaEspacialService service) {
		this.service = service;
	}

	@GetMapping("/x/{x}/y/{y}/direcao/{idDirecao}/movimentos/{movimentosString}")
	@ResponseBody
	public SondaEspacial executarSonda(@PathVariable String x, @PathVariable String y, 
			@PathVariable String idDirecao, @PathVariable String movimentosString) {
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
