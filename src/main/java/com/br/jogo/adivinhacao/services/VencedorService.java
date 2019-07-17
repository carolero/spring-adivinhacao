package com.br.jogo.adivinhacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.jogo.adivinhacao.models.Vencedor;
import com.br.jogo.adivinhacao.repositories.VencedorRepository;

@Service
public class VencedorService {
	
	@Autowired
	private VencedorRepository vencedorRepository;
	@Autowired
	private RandomService randomService;
	
	public Iterable<Vencedor> mostrarVencedores() {
		return vencedorRepository.findAll();
	}
	
	public String validarChute(Vencedor vencedor) {
		if(vencedor.getChute() ==  randomService.gerarNumeroAleatorio()) {
			vencedorRepository.save(vencedor);
			return "Você acertou :)";
		} else {
			return "Você errou :( outro número foi sorteado";
		}
	}

}
