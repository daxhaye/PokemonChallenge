package com.pokedex.repository.Interface;

import com.pokedex.model.DescriptionList;
import com.pokedex.model.Evolution;
import com.pokedex.model.ListPokemon;
import com.pokedex.model.Pokemon;

import java.net.URI;

public interface IPokemonRepository {

    ListPokemon findAll(int offset, int  limit);
    Pokemon findByUri(URI uri);
    Pokemon findById(Long id);
    Evolution findEvolutionById(Long id);
    DescriptionList findDescriptionById(Long id);
}
