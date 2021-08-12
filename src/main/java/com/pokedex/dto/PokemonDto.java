package com.pokedex.dto;

import com.pokedex.model.Ability;
import com.pokedex.model.Sprite;
import com.pokedex.model.Types;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PokemonDto {
    Long id;
    String name;
    Sprite sprites;
    int weight;
    List<Ability> abilities;
    List<Types> types;
}
