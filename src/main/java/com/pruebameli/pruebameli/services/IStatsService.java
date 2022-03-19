package com.pruebameli.pruebameli.services;

import com.pruebameli.pruebameli.utilities.models.StatsOutDto;
import com.pruebameli.pruebameli.utilities.models.StatsOutInterface;

public interface IStatsService {

    /**
     * Metodo que retorna las estadisticas
     *
     * @return dto con los datos solicitados
     */
    public StatsOutDto getStats();
}
