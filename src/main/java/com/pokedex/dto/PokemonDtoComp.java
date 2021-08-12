package com.pokedex.dto;

import com.pokedex.model.Ability;
import com.pokedex.model.Sprite;
import com.pokedex.model.Types;
import lombok.Data;

import java.util.List;

@Data
public class PokemonDtoComp {
    Long id;
    String name;
    int weight;
    Sprite sprites;
    List<Ability> abilities;
    List<Types> types;
    String descriptions;
    String evolutions;
}
