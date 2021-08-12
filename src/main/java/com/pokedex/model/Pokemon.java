package com.pokedex.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Pokemon {
    private Long id;
    private String name;
    private int weight;
    private Sprite sprites;
    private List<Ability> abilities;
    private List<Types> types;
    private String descriptions;
    private String evolutions;

}
