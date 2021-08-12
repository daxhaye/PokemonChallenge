package com.pokedex.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.model.Descriptions;
import com.pokedex.model.ListPokemon;
import com.pokedex.model.NamedAPIResource;
import com.pokedex.model.Pokemon;
import com.pokedex.service.Interface.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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
    public List<Pokemon> findById() throws JsonProcessingException {
        return null;
    }

}
