package com.br.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.server.model.CargoEntity;

public interface CargoRepository extends JpaRepository<CargoEntity, Long> {
}

