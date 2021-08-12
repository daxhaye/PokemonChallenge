package com.pokedex.service.Interface;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokedex.dto.PokemonDto;
import com.pokedex.dto.PokemonDtoComp;

import java.io.IOException;
import java.util.List;

public interface IPokemonService {

    List<PokemonDto> findAll(int offset, int limit) throws IOException;

    PokemonDtoComp findById(Long id) throws JsonProcessingException;
}
