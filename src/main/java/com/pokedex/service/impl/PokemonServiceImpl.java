package com.pokedex.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.dto.PokemonDto;
import com.pokedex.model.ListPokemon;
import com.pokedex.model.NamedAPIResource;
import com.pokedex.model.Pokemon;
import com.pokedex.service.Interface.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;
import java.net.URLPermission;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonServiceImpl implements IPokemonService {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ListPokemon findAll(int offset, int limit) throws JsonProcessingException {

        ListPokemon pokemonList =
                    restTemplate.getForObject(URI.create("https://pokeapi.co/api/v2/pokemon?offset=" + offset + "&limit" + limit), ListPokemon.class);
        return pokemonList;
    }

    @Override
    public List<Pokemon> findById() throws JsonProcessingException {

        List<Pokemon> pokemonList = new ArrayList<Pokemon>();
        for (int i = 1; i < 21; i++) {
            ResponseEntity<String> response =
                    restTemplate.getForEntity(URI.create("https://pokeapi.co/api/v2/pokemon/" + i), String.class);

            JsonNode root = mapper.readTree(response.getBody());
            JsonNode sprites = root.path("sprites");

            JsonNode abilities = root.path("abilities");

            Pokemon pokemon = new Pokemon();
            pokemon.setName(root.path("name").asText());
            pokemon.setId(root.path("id").asLong());
            pokemon.setWeight(root.path("weight").asInt());
            pokemon.setSprites(sprites.path("front_default").asText());
            pokemonList.add(pokemon);
        }

        return pokemonList;
    }

}
