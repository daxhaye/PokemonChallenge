package com.pokedex.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.pokedex.model.Ability;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Getter @Setter
public class PokemonDto {
    Long id;
    String name;
    String sprites;
    List<String> types;
    int weight;
    List<Ability> abilities;
}
