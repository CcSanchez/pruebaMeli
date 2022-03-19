package com.pruebameli.pruebameli.services;

import com.pruebameli.pruebameli.utilities.exceptions.BussinessException;
import com.pruebameli.pruebameli.utilities.models.AuditoriaDto;

public interface IAuditoriaService {

    boolean insertarAuditoria(AuditoriaDto auditoriaDto) throws BussinessException;
}
