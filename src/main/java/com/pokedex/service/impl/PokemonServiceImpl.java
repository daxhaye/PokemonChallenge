package com.pokedex.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.dto.PokemonDto;
import com.pokedex.dto.PokemonDtoComp;
import com.pokedex.model.*;
import com.pokedex.repository.Interface.IPokemonRepository;
import com.pokedex.service.Interface.IPokemonService;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements IPokemonService {

    final
    IPokemonRepository repository;

    final
    ObjectMapper mapper;

    public PokemonServiceImpl(IPokemonRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PokemonDto> findAll(int offset, int limit) {
        return repository.findAll(offset, limit).getResults()
                .stream().parallel()
                .map(na -> {
                    Pokemon pokemon = repository.findByUri(URI.create(na.getUrl()));
                    return mapper.convertValue(pokemon, PokemonDto.class);
                })
                .collect(Collectors.toList());
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
