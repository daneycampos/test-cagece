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

import com.br.server.model.CargoEntity;
import com.br.server.service.CargoService;

@RestController
@RequestMapping("/cargos")
@CrossOrigin(origins = "http://localhost:3000")
public class CargoController {
    private final CargoService cargoService;

    @Autowired
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping
    public List<CargoEntity> getAllCargos() {
        return cargoService.getAllCargos();
    }

    @GetMapping("/{id}")
    public CargoEntity getCargoById(@PathVariable Long id) {
        return cargoService.getCargoById(id);
    }

    @PostMapping
    public CargoEntity saveCargo(@RequestBody CargoEntity cargo) {
        return cargoService.saveCargo(cargo);
    }

    @DeleteMapping("/{id}")
    public void deleteCargo(@PathVariable Long id) {
        cargoService.deleteCargo(id);
    }
}

