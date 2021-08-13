package com.pokedex.service.Interface;

import com.pokedex.dto.PokemonDto;
import com.pokedex.dto.PokemonDtoComp;

import java.util.List;

public interface IPokemonService {

    List<PokemonDto> findAll(int offset, int limit);

    PokemonDtoComp findById(Long id);
}
