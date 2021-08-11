package com.pokedex.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Getter @Setter
public class ListPokemon {
    private int count;
    private String next;
    private String previous;
    private List<NamedAPIResource> results = new ArrayList<NamedAPIResource>();
}
