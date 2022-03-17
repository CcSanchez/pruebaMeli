package com.pruebameli.pruebameli.services;

import com.pruebameli.pruebameli.utilities.exceptions.BussinessException;

public interface IValidacionDatosService {

    /**
     * Metodo que valida que los datos ingresados correspondan a los permitidos (A,T,C,G)
     *
     * @param dna cadena de adn suministrada
     * @return true si son validos
     */
    char[][] validarBasesNitrogenadas(String[] dna) throws BussinessException;


    boolean validarCoincidencias(char[][] dna);


}
