package com.pruebameli.pruebameli.services.implementation;

import com.pruebameli.pruebameli.jpa.entities.AuditoriaMutanteEntity;
import com.pruebameli.pruebameli.jpa.repositories.AuditoriaMutanteRepository;
import com.pruebameli.pruebameli.services.IAuditoriaService;
import com.pruebameli.pruebameli.utilities.Constantes;
import com.pruebameli.pruebameli.utilities.exceptions.BussinessException;
import com.pruebameli.pruebameli.utilities.models.AuditoriaDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class AuditoriaService implements IAuditoriaService {

    @Autowired
    AuditoriaMutanteRepository repository;

    @Override
    @Transactional
    public boolean insertarAuditoria(AuditoriaDto auditoriaDto) throws BussinessException {
        try {
            AuditoriaMutanteEntity auditoriaMutanteEntity = new AuditoriaMutanteEntity();
            auditoriaMutanteEntity.setDate(new Date());
            auditoriaMutanteEntity.setDna(auditoriaDto.getDna());
            auditoriaMutanteEntity.setIsmutant((long) auditoriaDto.getIsMutant());
            repository.save(auditoriaMutanteEntity);

            return true;
        } catch (Exception e) {
            log.info(String.format("************ %s",e.getMessage()));
            throw new BussinessException(Constantes.ERROR_AUDITORIA);
        }

    }
}
