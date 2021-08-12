package com.pokedex.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.model.*;
import com.pokedex.service.Interface.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonServiceImpl implements IPokemonService {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Pokemon> findAll(int offset, int limit) throws IOException {
        List<Pokemon> pokemonList = new ArrayList<Pokemon>();

        ListPokemon responseList =
                    restTemplate.getForObject(URI.create("https://pokeapi.co/api/v2/pokemon?offset=" + offset + "&limit" + limit), ListPokemon.class);

        for(NamedAPIResource na : responseList.getResults()) {
            Pokemon pokemon = restTemplate.getForObject(na.getUrl() , Pokemon.class);
            pokemonList.add(pokemon);
        }

        return pokemonList;
    }

    @Override
    public Pokemon findById(Long id) throws JsonProcessingException {

        Pokemon pokemon =
                restTemplate.getForObject(URI.create("https://pokeapi.co/api/v2/pokemon/" + id), Pokemon.class);

        Evolution evolution =
                restTemplate.getForObject(URI.create("https://pokeapi.co/api/v2/evolution-chain/" + id), Evolution.class);


        DescriptionList descriptions =
                restTemplate.getForObject(URI.create("https://pokeapi.co/api/v2/characteristic/" + id), DescriptionList.class);

        pokemon.setDescriptions(descriptions.getDescriptions().get(1).getDescription());
        pokemon.setEvolutions(evolution.getChain().getEvolves_to().get(0).getSpecies().getName());
        return pokemon;
    }

}
