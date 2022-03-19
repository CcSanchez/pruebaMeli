package com.pruebameli.pruebameli.utilities.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditoriaDto {

    @ApiModelProperty(value = "Indicador de si el adn es mutante o no", required = true, example = "1")
    @JsonProperty("isMutant")
    private int isMutant;

    @ApiModelProperty(value = "Secuencia de adn", required = true, example = "[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]")
    @JsonProperty("dna")
    private String dna;

}
