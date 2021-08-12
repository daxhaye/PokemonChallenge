package com.pokedex.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.dto.PokemonDto;
import com.pokedex.dto.PokemonDtoComp;
import com.pokedex.model.*;
import com.pokedex.repository.Interface.IPokemonRepository;
import com.pokedex.service.Interface.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonServiceImpl implements IPokemonService {

    @Autowired
    IPokemonRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public List<PokemonDto> findAll(int offset, int limit) {
        List<PokemonDto> pokemonList = new ArrayList<>();

        ListPokemon responseList = repository.findAll(offset, limit);

        for(NamedAPIResource na : responseList.getResults()) {
            Pokemon pokemon = repository.findByUri(URI.create(na.getUrl()));
            PokemonDto dto = mapper.convertValue(pokemon, PokemonDto.class);
            pokemonList.add(dto);
        }

        return pokemonList;
    }

    @Override
    public PokemonDtoComp findById(Long id) {

        Pokemon pokemon = repository.findById(id);

        Evolution evolution =
                repository.findEvolutionById(id);

        DescriptionList descriptions =
                repository.findDescriptionById(id);

        pokemon.setDescriptions(descriptions.getDescriptions().get(1).getDescription());
        pokemon.setEvolutions(evolution.getChain().getEvolves_to().get(0).getSpecies().getName());

        return mapper.convertValue(pokemon, PokemonDtoComp.class);
    }

}
