package com.pruebameli.pruebameli.controllers;

import com.pruebameli.pruebameli.services.IMutantesService;
import com.pruebameli.pruebameli.utilities.Constantes;
import com.pruebameli.pruebameli.utilities.models.MutantInDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

@RestController
@RequestMapping(Constantes.MUTANT)
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Slf4j
public class MutanteController {

    @Autowired
    IMutantesService service;

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "Servicio que retorna si un codigo de adn es mutante o no.")
    public ResponseEntity<String> getMutant(@ApiParam(
            name = "dna",
            type = "MutantInDto",
            value = "Dto que contiene un listado de dna",
            example = "[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]", required = true) @RequestBody MutantInDto adn) {

        try {
            if (service.isMutant(adn.getDna()))
                return ResponseEntity.ok(Constantes.DNA_MUTANTE);
            return new ResponseEntity<>(Constantes.DNA_NO_MUTANTE, HttpStatus.FORBIDDEN);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }

    }
}
