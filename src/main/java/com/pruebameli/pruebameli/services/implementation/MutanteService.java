package com.pruebameli.pruebameli.services.implementation;

import com.pruebameli.pruebameli.services.IAuditoriaService;
import com.pruebameli.pruebameli.services.IMutantesService;
import com.pruebameli.pruebameli.services.IValidacionDatosService;
import com.pruebameli.pruebameli.utilities.exceptions.BussinessException;
import com.pruebameli.pruebameli.utilities.models.AuditoriaDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
@Slf4j
public class MutanteService implements IMutantesService {

    @Autowired
    IValidacionDatosService validacionDatosService;

    @Autowired
    IAuditoriaService auditoriaService;

    /**
     * Metodo que define si el adn ingresado es de un mutante
     *
     * @param dna dna de la persona a validar
     * @return true si es mutante false si no es asi
     */
    @Override
    public boolean isMutant(String[] dna) throws BussinessException {
        AuditoriaDto auditoriaDto = new AuditoriaDto();
        char[][] adn = validacionDatosService.validarBasesNitrogenadas(dna);
        boolean ismutant = validacionDatosService.validarCoincidencias(adn);
        auditoriaDto.setIsMutant(ismutant ? 1 : 0);
        auditoriaDto.setDna(Arrays.toString(dna));
        auditoriaService.insertarAuditoria(auditoriaDto);
        return ismutant;
    }
}
