package com.pruebameli.pruebameli.utilities.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MutantInDto {

    @NotNull
    @JsonProperty("dna")
    @JsonDeserialize
    @ApiModelProperty(value = "Secuencia de adn", required = true, example = "[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]")
    private String[] dna;


}
