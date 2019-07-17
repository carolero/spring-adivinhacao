package com.br.jogo.adivinhacao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.jogo.adivinhacao.models.Vencedor;

@Repository
public interface VencedorRepository extends CrudRepository<Vencedor, Integer> {

}
