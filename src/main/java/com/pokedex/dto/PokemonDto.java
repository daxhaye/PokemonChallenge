package com.pokedex.dto;

import com.pokedex.model.Ability;
import com.pokedex.model.Sprite;
import com.pokedex.model.Types;
import lombok.Data;

import java.util.List;

@Data
public class PokemonDto {
    Long id;
    String name;
    Sprite sprites;
    int weight;
    List<Ability> abilities;
    List<Types> types;
}
