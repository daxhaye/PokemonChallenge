package com.pokedex.repository.impl;

import com.pokedex.model.DescriptionList;
import com.pokedex.model.Evolution;
import com.pokedex.model.ListPokemon;
import com.pokedex.model.Pokemon;
import com.pokedex.repository.Interface.IPokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class PokemonRepositoryImpl implements IPokemonRepository {

    private final RestTemplate restTemplate;

    public PokemonRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ListPokemon findAll(int offset,int  limit) {
        URI uri = URI.create("https://pokeapi.co/api/v2/pokemon?offset=" + offset + "&limit" + limit);

        return restTemplate.getForObject(uri, ListPokemon.class);
    }

    @Override
    public Pokemon findByUri(URI uri) {
        return restTemplate.getForObject(uri, Pokemon.class);
    }

    @Override
    public Pokemon findById(Long id){
        URI uri = URI.create("https://pokeapi.co/api/v2/pokemon/" + id);

        return restTemplate.getForObject(uri, Pokemon.class);
    }

    @Override
    public Evolution findEvolutionById(Long id) {
        URI uri= URI.create("https://pokeapi.co/api/v2/evolution-chain/" + id);
        try {
            return restTemplate.getForObject(uri, Evolution.class);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public DescriptionList findDescriptionById(Long id) {
        URI uri = URI.create("https://pokeapi.co/api/v2/characteristic/" + id);
        try {
            return restTemplate.getForObject(uri, DescriptionList.class);
        } catch (Exception e) {
            return null;
        }
    }

}

