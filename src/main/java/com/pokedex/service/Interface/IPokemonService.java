package com.pokedex.service.Interface;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokedex.model.ListPokemon;
import com.pokedex.model.Pokemon;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface IPokemonService {

    public List<Pokemon> findAll(int offset, int limit) throws IOException;

    public List<Pokemon> findById() throws JsonProcessingException;
}
