package com.pokedex.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class Pokemon {
    private Long id;
    private String name;
    private int weight;
    private Sprite sprites;
    private List<Ability> abilities;
    private List<Types> types;
    private Descriptions descriptions;

}
