package com.pruebameli.pruebameli.controllers;

import com.pruebameli.pruebameli.utilities.models.MutantInDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MutanteControllerTest {
    private static final String URL = "http://localhost:";

    private static final String END_POINT = "/mutant";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        assertThat(restTemplate).isNotNull();
    }


    /**
     * Validacion dna vacio
     */
    @Test
    void notParameters() {
        String url = URL + port + END_POINT;
        MutantInDto mutantInDto = new MutantInDto();
        ResponseEntity<String> ismutant = this.restTemplate.postForEntity(url, mutantInDto, String.class);
        assertEquals(HttpStatus.FORBIDDEN, ismutant.getStatusCode());
    }

    /**
     * Validacion dna vacio
     */
    @Test
    void badParameters() {
        String url = URL + port + END_POINT;
        ResponseEntity<String> ismutant = this.restTemplate.postForEntity(url, "", String.class);
        assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE, ismutant.getStatusCode());
    }

    /**
     * Validacion dna mutante
     */
    @Test
    void isMutantSuccess() {
        String url = URL + port + END_POINT;
        MutantInDto mutantInDto = new MutantInDto();
        mutantInDto.setDna(new String[]{"ATGCGA", "AAAAGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
        ResponseEntity<String> ismutant = this.restTemplate.postForEntity(url, mutantInDto, String.class);
        assertEquals(HttpStatus.OK, ismutant.getStatusCode());
    }

    /**
     * Validacion dna mutante
     */
    @Test
    void isMutantSuccessSecuenciasDiagonales() {
        String url = URL + port + END_POINT;
        MutantInDto mutantInDto = new MutantInDto();
        mutantInDto.setDna(new String[]{"ATGCGG", "AAAAGC", "TTAGGT", "AGAATG", "CCCTTA", "TCTCTG"});
        ResponseEntity<String> ismutant = this.restTemplate.postForEntity(url, mutantInDto, String.class);
        assertEquals(HttpStatus.OK, ismutant.getStatusCode());
    }

    /**
     * Validacion dna mutante
     */
    @Test
    void isMutantSuccessSecuenciasDiagonales1() {
        String url = URL + port + END_POINT;
        MutantInDto mutantInDto = new MutantInDto();
        mutantInDto.setDna(new String[]{"ATGCGG", "AAAAGC", "TTAGGT", "ATAATG", "CCTTTA", "TCTCTG"});
        ResponseEntity<String> ismutant = this.restTemplate.postForEntity(url, mutantInDto, String.class);
        assertEquals(HttpStatus.OK, ismutant.getStatusCode());
    }


    /**
     * Validacion dna no mutante
     */
    @Test
    void isnotmutantsuccess() {
        String url = URL + port + END_POINT;
        MutantInDto mutantInDto = new MutantInDto();
        mutantInDto.setDna(new String[]{"ATGCGA", "CCGTGC", "TTATGT", "AGAAGG", "CTCCTA", "TCACTG"});
        ResponseEntity<String> ismutant = this.restTemplate.postForEntity(url, mutantInDto, String.class);
        assertEquals(HttpStatus.FORBIDDEN, ismutant.getStatusCode());
    }


    /**
     * Dimensiones del dna no simetricas
     */
    @Test
    void isBadDnaSuccess() {
        String url = URL + port + END_POINT;
        MutantInDto mutantInDto = new MutantInDto();
        mutantInDto.setDna(new String[]{"ATGCA", "CCGTGC", "TTATGT", "AGAATG", "CTCCTA", "TCACTG"});
        ResponseEntity<String> ismutant = this.restTemplate.postForEntity(url, mutantInDto, String.class);
        assertEquals(HttpStatus.FORBIDDEN, ismutant.getStatusCode());
    }

    /**
     * Caracter invalido en dna
     */
    @Test
    void isBadDnaSuccess1() {
        String url = URL + port + END_POINT;
        MutantInDto mutantInDto = new MutantInDto();
        mutantInDto.setDna(new String[]{"ATGCAF", "CCGTGC", "TTATGT", "AGAAGG", "CTCCTA", "TCACTG"});
        ResponseEntity<String> ismutant = this.restTemplate.postForEntity(url, mutantInDto, String.class);
        assertEquals(HttpStatus.FORBIDDEN, ismutant.getStatusCode());
    }

}