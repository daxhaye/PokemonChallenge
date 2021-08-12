package com.pokedex.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ApiModel(description = "Descripcion del pokemon")
public class Description {
    @ApiModelProperty
    private String description;
    @ApiModelProperty
    private NamedAPIResource language;
}
