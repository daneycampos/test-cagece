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

import com.br.server.model.GrupoEntity;
import com.br.server.service.GrupoService;

@RestController
@RequestMapping("/grupos")
@CrossOrigin(origins = "http://localhost:3000")
public class GrupoController {
    private final GrupoService grupoService;

    @Autowired
    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping
    public List<GrupoEntity> getAllGrupos() {
        return grupoService.getAllGrupos();
    }

    @GetMapping("/{id}")
    public GrupoEntity getGrupoById(@PathVariable Long id) {
        return grupoService.getGrupoById(id);
    }

    @PostMapping
    public GrupoEntity saveGrupo(@RequestBody GrupoEntity grupo) {
        return grupoService.saveGrupo(grupo);
    }

    @DeleteMapping("/{id}")
    public void deleteGrupo(@PathVariable Long id) {
        grupoService.deleteGrupo(id);
    }
}

