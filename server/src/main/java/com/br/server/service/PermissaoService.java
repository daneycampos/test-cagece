package com.br.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.server.model.PermissaoEntity;
import com.br.server.repository.PermissaoRepository;

@Service
public class PermissaoService {
    private final PermissaoRepository permissaoRepository;

    @Autowired
    public PermissaoService(PermissaoRepository permissaoRepository) {
        this.permissaoRepository = permissaoRepository;
    }

    public List<PermissaoEntity> getAllPermissoes() {
        return permissaoRepository.findAll();
    }

    public PermissaoEntity getPermissaoById(Long id) {
        return permissaoRepository.findById(id).orElse(null);
    }

    public PermissaoEntity savePermissao(PermissaoEntity permissao) {
        return permissaoRepository.save(permissao);
    }

    public void deletePermissao(Long id) {
        permissaoRepository.deleteById(id);
    }
}

