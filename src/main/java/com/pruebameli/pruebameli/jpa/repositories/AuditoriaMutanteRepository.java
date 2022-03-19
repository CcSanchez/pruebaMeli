package com.pruebameli.pruebameli.jpa.repositories;

import com.pruebameli.pruebameli.jpa.entities.AuditoriaMutanteEntity;
import com.pruebameli.pruebameli.utilities.models.StatsOutInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaMutanteRepository extends JpaRepository<AuditoriaMutanteEntity, Long> {

    @Query(value = "SELECT\n" +
            "\tCOUNT(DISTINCT CASE WHEN ISMUTANT = 0 THEN ID END) AS COUNT_MUTANT_DNA,\n" +
            "\tCOUNT(DISTINCT CASE WHEN ISMUTANT = 1 THEN ID END) AS COUNT_HUMAN_DNA,\n" +
            "\t0.4 AS RATIO\n" +
            "FROM\n" +
            "\tAUDITISMUTANT", nativeQuery = true)
    StatsOutInterface findStats();
}
