package com.br.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.server.model.CargoEntity;
import com.br.server.repository.CargoRepository;

@Service
public class CargoService {
    private final CargoRepository cargoRepository;

    @Autowired
    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public List<CargoEntity> getAllCargos() {
        return cargoRepository.findAll();
    }

    public CargoEntity getCargoById(Long id) {
        return cargoRepository.findById(id).orElse(null);
    }

    public CargoEntity saveCargo(CargoEntity cargo) {
        return cargoRepository.save(cargo);
    }

    public void deleteCargo(Long id) {
        cargoRepository.deleteById(id);
    }
}
