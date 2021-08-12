package com.pokedex.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.dto.PokemonDto;
import com.pokedex.dto.PokemonDtoComp;
import com.pokedex.model.*;
import com.pokedex.repository.PokemonRepository;
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
    private PokemonRepository repository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public List<PokemonDto> findAll(int offset, int limit) throws IOException {
        URI uri = URI.create("https://pokeapi.co/api/v2/pokemon?offset=" + offset + "&limit" + limit);
        List<PokemonDto> pokemonList = new ArrayList<>();

        ListPokemon responseList = repository.findAll(uri);

        for(NamedAPIResource na : responseList.getResults()) {
            Pokemon pokemon = repository.findById(URI.create(na.getUrl()));
            PokemonDto dto = mapper.convertValue(pokemon, PokemonDto.class);
            pokemonList.add(dto);
        }

        return pokemonList;
    }

    @Override
    public PokemonDtoComp findById(Long id) throws JsonProcessingException {
        URI uri = URI.create("https://pokeapi.co/api/v2/pokemon/" + id);

        Pokemon pokemon = repository.findById(uri);

        Evolution evolution =
                repository.findEvolutionById(URI.create("https://pokeapi.co/api/v2/evolution-chain/" + id));

        DescriptionList descriptions =
                repository.findDescriptionById(URI.create("https://pokeapi.co/api/v2/characteristic/" + id));

        pokemon.setDescriptions(descriptions.getDescriptions().get(1).getDescription());
        pokemon.setEvolutions(evolution.getChain().getEvolves_to().get(0).getSpecies().getName());

        return mapper.convertValue(pokemon, PokemonDtoComp.class);
    }

}
