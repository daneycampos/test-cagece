package com.br.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.server.model.GrupoEntity;
import com.br.server.repository.GrupoRepository;

@Service
public class GrupoService {
    private final GrupoRepository grupoRepository;

    @Autowired
    public GrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    public List<GrupoEntity> getAllGrupos() {
        return grupoRepository.findAll();
    }

    public GrupoEntity getGrupoById(Long id) {
        return grupoRepository.findById(id).orElse(null);
    }

    public GrupoEntity saveGrupo(GrupoEntity grupo) {
        return grupoRepository.save(grupo);
    }

    public void deleteGrupo(Long id) {
        grupoRepository.deleteById(id);
    }
}
 

