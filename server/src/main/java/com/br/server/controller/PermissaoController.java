package com.br.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.server.model.PermissaoEntity;
import com.br.server.service.PermissaoService;

@RestController
@RequestMapping("/permissoes")
@CrossOrigin(origins = "http://localhost:3000")
public class PermissaoController {
    private final PermissaoService permissaoService;

    @Autowired
    public PermissaoController(PermissaoService permissaoService) {
        this.permissaoService = permissaoService;
    }

    @GetMapping
    public List<PermissaoEntity> getAllPermissoes() {
        return permissaoService.getAllPermissoes();
    }

    @GetMapping("/{id}")
    public PermissaoEntity getPermissaoById(@PathVariable Long id) {
        return permissaoService.getPermissaoById(id);
    }

    @PostMapping
    public PermissaoEntity savePermissao(@RequestBody PermissaoEntity permissao) {
        return permissaoService.savePermissao(permissao);
    }

    @DeleteMapping("/{id}")
    public void deletePermissao(@PathVariable Long id) {
        permissaoService.deletePermissao(id);
    }
}

