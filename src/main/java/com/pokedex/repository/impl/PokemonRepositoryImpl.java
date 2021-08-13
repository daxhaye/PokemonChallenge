package com.pokedex.repository.impl;

import com.pokedex.model.DescriptionList;
import com.pokedex.model.Evolution;
import com.pokedex.model.ListPokemon;
import com.pokedex.model.Pokemon;
import com.pokedex.repository.Interface.IPokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.Cacheable;

import java.net.URI;

@Service
public class PokemonRepositoryImpl implements IPokemonRepository {

    private final RestTemplate restTemplate;

    public PokemonRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Cacheable("pokemons")
    public ListPokemon findAll(int offset,int  limit) {
        URI uri = URI.create("https://pokeapi.co/api/v2/pokemon?offset=" + offset + "&limit" + limit);

        return restTemplate.getForObject(uri, ListPokemon.class);
    }

    @Override
    @Cacheable("pokemon")
    public Pokemon findByUri(URI uri) {
        return restTemplate.getForObject(uri, Pokemon.class);
    }

    @Override
    @Cacheable("pokemon")
    public Pokemon findById(Long id){
        URI uri = URI.create("https://pokeapi.co/api/v2/pokemon/" + id);

        return restTemplate.getForObject(uri, Pokemon.class);
    }

    @Override
    @Cacheable("evolutions")
    public Evolution findEvolutionById(Long id) {
        URI uri= URI.create("https://pokeapi.co/api/v2/evolution-chain/" + id);
        try {
            return restTemplate.getForObject(uri, Evolution.class);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Cacheable("descriptions")
    public DescriptionList findDescriptionById(Long id) {
        URI uri = URI.create("https://pokeapi.co/api/v2/characteristic/" + id);
        try {
            return restTemplate.getForObject(uri, DescriptionList.class);
        } catch (Exception e) {
            return null;
        }
    }

}

