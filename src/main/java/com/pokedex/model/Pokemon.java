package com.pokedex.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ApiModel(description = "Modelo del Pokemon")
public class Pokemon {
    @ApiModelProperty
    private Long id;
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private int weight;
    @ApiModelProperty
    private Sprite sprites;
    @ApiModelProperty
    private List<Ability> abilities;
    @ApiModelProperty
    private List<Types> types;
    @ApiModelProperty
    private String descriptions;
    @ApiModelProperty
    private String evolutions;

}
