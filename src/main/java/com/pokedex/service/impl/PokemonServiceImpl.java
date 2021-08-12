package com.pokedex.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.model.ListPokemon;
import com.pokedex.model.NamedAPIResource;
import com.pokedex.model.Pokemon;
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

    //Variable Global Lista de Pokemon
    public List<Pokemon> pokemonList = new ArrayList<Pokemon>();

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Pokemon> findAll(int offset, int limit) throws IOException {


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
        for(Pokemon pokemon : pokemonList) {
            if(id == pokemon.getId()) {
                return pokemon;
            }
        }
        return null;
    }

}
