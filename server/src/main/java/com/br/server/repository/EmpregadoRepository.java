package com.br.server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.server.model.EmpregadoEntity;

public interface EmpregadoRepository extends JpaRepository<EmpregadoEntity, Long> {

    @Query("SELECT e FROM EmpregadoEntity e WHERE e.codigo = :codigo")
    Optional<EmpregadoEntity> findByCodigo(@Param("codigo") String codigo);

}

