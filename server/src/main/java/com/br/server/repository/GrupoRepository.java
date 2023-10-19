package com.br.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.server.model.GrupoEntity;

public interface GrupoRepository extends JpaRepository<GrupoEntity, Long> {
}

