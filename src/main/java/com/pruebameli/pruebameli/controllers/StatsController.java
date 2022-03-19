package com.pruebameli.pruebameli.controllers;

import com.pruebameli.pruebameli.services.IStatsService;
import com.pruebameli.pruebameli.utilities.Constantes;
import com.pruebameli.pruebameli.utilities.models.StatsOutDto;
import com.pruebameli.pruebameli.utilities.models.StatsOutInterface;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
@RequestMapping(Constantes.STATS)
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Slf4j
public class StatsController {

    @Autowired
    IStatsService service;

    @GetMapping
    @ApiOperation(value = "Servicio que retorna si un codigo de adn es mutante o no.")
    public ResponseEntity<StatsOutDto> getStats() {
        return ResponseEntity.ok(service.getStats());
    }
}
