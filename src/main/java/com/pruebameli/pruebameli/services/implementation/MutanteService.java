package com.pruebameli.pruebameli.services.implementation;

import com.pruebameli.pruebameli.services.IMutantesService;
import com.pruebameli.pruebameli.services.IValidacionDatosService;
import com.pruebameli.pruebameli.utilities.exceptions.BussinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MutanteService implements IMutantesService {

    @Autowired
    IValidacionDatosService validacionDatosService;

    /**
     * Metodo que define si el adn ingresado es de un mutante
     *
     * @param dna dna de la persona a validar
     * @return true si es mutante false si no es asi
     */
    @Override
    public boolean isMutant(String[] dna) throws BussinessException {
        char[][] adn = validacionDatosService.validarBasesNitrogenadas(dna);
        return validacionDatosService.validarCoincidencias(adn);
    }
}
