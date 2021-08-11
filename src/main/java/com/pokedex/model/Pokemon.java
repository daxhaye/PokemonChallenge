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
    private String description;
    private String sprites;
    private List<Ability> abilities = new ArrayList<>();
    private List<String> types = new ArrayList<>();


    public void addTypes(String name) {
        types.add(name);
    }
    public void addAbility(Ability name){this.abilities.add(name);}
}
