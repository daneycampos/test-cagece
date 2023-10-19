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

import com.br.server.model.EmpregadoEntity;
import com.br.server.service.EmpregadoService;

@RestController
@RequestMapping("/empregados")
@CrossOrigin(origins = "http://localhost:3000")
public class EmpregadoController {
    private final EmpregadoService empregadoService;

    @Autowired
    public EmpregadoController(EmpregadoService empregadoService) {
        this.empregadoService = empregadoService;
    }

    @GetMapping
    public List<EmpregadoEntity> getAllEmpregados() {
        return empregadoService.getAllEmpregados();
    }

    @GetMapping("/{id}")
    public EmpregadoEntity getEmpregadoById(@PathVariable Long id) {
        return empregadoService.getEmpregadoById(id);
    }

    @PostMapping
    public EmpregadoEntity saveEmpregado(@RequestBody EmpregadoEntity empregado) {
        return empregadoService.saveEmpregado(empregado);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpregado(@PathVariable Long id) {
        empregadoService.deleteEmpregado(id);
    }
}

