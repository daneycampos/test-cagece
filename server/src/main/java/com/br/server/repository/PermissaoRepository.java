package com.br.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.server.model.PermissaoEntity;

public interface PermissaoRepository extends JpaRepository<PermissaoEntity, Long> {
}

