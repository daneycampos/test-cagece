package com.br.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.server.model.EmpregadoEntity;
import com.br.server.repository.EmpregadoRepository;

@Service
public class EmpregadoService {
    private final EmpregadoRepository empregadoRepository;

    @Autowired
    public EmpregadoService(EmpregadoRepository empregadoRepository) {
        this.empregadoRepository = empregadoRepository;
    }

    public List<EmpregadoEntity> getAllEmpregados() {
        return empregadoRepository.findAll();
    }

    public EmpregadoEntity getEmpregadoById(Long id) {
        return empregadoRepository.findById(id).orElse(null);
    }

    public Optional<EmpregadoEntity> findEmpregadoByCodigo(String codigo) {
        return empregadoRepository.findByCodigo(codigo);
    }


    public EmpregadoEntity saveEmpregado(EmpregadoEntity empregado) {
        return empregadoRepository.save(empregado);
    }

    public void deleteEmpregado(Long id) {
        empregadoRepository.deleteById(id);
    }
}

