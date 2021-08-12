package com.pokedex.service.Interface;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokedex.model.ListPokemon;
import com.pokedex.model.Pokemon;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.http.HttpRequest;
import java.util.List;

public interface IPokemonService {

    public List<Pokemon> findAll(int offset, int limit) throws IOException;

    public Pokemon findById(Long id) throws JsonProcessingException;
}
