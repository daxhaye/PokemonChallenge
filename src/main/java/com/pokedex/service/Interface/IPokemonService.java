package com.pokedex.service.Interface;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokedex.model.ListPokemon;
import com.pokedex.model.Pokemon;

import java.util.List;

public interface IPokemonService {

    public ListPokemon findAll(int offset, int limit) throws JsonProcessingException;

    public List<Pokemon> findById() throws JsonProcessingException;
}
