package com.pokedex.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@ApiModel(description = "Listado de Pokemon con conteo, pagina siguiente y anterior")
public class ListPokemon {
    @ApiModelProperty
    private int count;
    @ApiModelProperty
    private String next;
    @ApiModelProperty
    private String previous;
    @ApiModelProperty
    private List<NamedAPIResource> results = new ArrayList<NamedAPIResource>();
}
