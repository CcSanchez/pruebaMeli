package com.pruebameli.pruebameli.controllers;

import com.pruebameli.pruebameli.utilities.models.StatsOutDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StatsControllerTest {
    private static final String URL = "http://localhost:";

    private static final String END_POINT = "/stats";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        assertThat(restTemplate).isNotNull();
    }

    @Test
    void getStats() {
        String url = URL + port + END_POINT;
        ResponseEntity<StatsOutDto> stats = this.restTemplate.getForEntity(url, StatsOutDto.class);
        assertEquals(HttpStatus.OK, stats.getStatusCode());
    }
}