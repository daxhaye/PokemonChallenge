package com.pokedex.service.Interface;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokedex.model.Pokemon;

import java.io.IOException;
import java.util.List;

public interface IPokemonService {

    List<Pokemon> findAll(int offset, int limit) throws IOException;

    Pokemon findById(Long id) throws JsonProcessingException;
}
