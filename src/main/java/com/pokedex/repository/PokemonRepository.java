package com.pokedex.repository;

import com.pokedex.model.DescriptionList;
import com.pokedex.model.Evolution;
import com.pokedex.model.ListPokemon;
import com.pokedex.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Repository
public class PokemonRepository {
    @Autowired
    private RestTemplate restTemplate;

    public ListPokemon findAll(URI uri) {
       return restTemplate.getForObject(uri, ListPokemon.class);
    }

    public Pokemon findById(URI uri) {
        return restTemplate.getForObject(uri, Pokemon.class);
    }

    public Evolution findEvolutionById(URI uri) {
        return restTemplate.getForObject(uri, Evolution.class);
    }

    public DescriptionList findDescriptionById(URI uri) {
        return restTemplate.getForObject(uri, DescriptionList.class);
    }


}
