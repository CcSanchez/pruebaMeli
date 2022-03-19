package com.pruebameli.pruebameli.services.implementation;

import com.pruebameli.pruebameli.jpa.repositories.AuditoriaMutanteRepository;
import com.pruebameli.pruebameli.services.IStatsService;
import com.pruebameli.pruebameli.utilities.models.StatsOutDto;
import com.pruebameli.pruebameli.utilities.models.StatsOutInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService implements IStatsService {

    @Autowired
    AuditoriaMutanteRepository repository;


    /**
     * Metodo que retorna las estadisticas
     *
     * @return dto con los datos solicitados
     */
    @Override
    public StatsOutDto getStats() {
        StatsOutInterface statsOutInterface = repository.findStats();
        StatsOutDto statsOutDto = new StatsOutDto();
        statsOutDto.setCountHumanDna(statsOutInterface.getcount_human_dna());
        statsOutDto.setCountMutantDna(statsOutInterface.getcount_mutant_dna());
        statsOutDto.setRatio(statsOutInterface.getratio());
        return statsOutDto;
    }
}
