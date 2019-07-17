package com.br.jogo.adivinhacao.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomService {
	
	@Autowired
	private VencedorService vencedorService;
	
	public int gerarNumeroAleatorio() {
		Random random = new Random();
		int numSorteado = random.nextInt(4);
		return numSorteado;
	}
}
