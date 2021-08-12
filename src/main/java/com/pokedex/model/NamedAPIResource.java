package com.pokedex.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@ApiModel
public class NamedAPIResource {
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private String url;
}
