package com.br.server.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.server.dto.SolicitacaoDTO;
import com.br.server.model.EmpregadoEntity;
import com.br.server.model.SolicitacaoEntity;
import com.br.server.repository.EmpregadoRepository;
import com.br.server.service.SolicitacaoService;

@RestController
@RequestMapping("/solicitacoes")
@CrossOrigin(origins = "http://localhost:3000")
public class SolicitacaoController {

    private final SolicitacaoService solicitacaoService;

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    public SolicitacaoController(SolicitacaoService solicitacaoService) {
        this.solicitacaoService = solicitacaoService;
    }

    @GetMapping
    public List<SolicitacaoEntity> getAllSolicitacoes() {
        return solicitacaoService.getAllSolicitacoes();
    }

    @PostMapping
    public SolicitacaoEntity createSolicitacao(@RequestBody SolicitacaoDTO solicitacaoDTO) {
        Optional<EmpregadoEntity> empregadoSubstitutoOptional = empregadoRepository
                .findByCodigo(solicitacaoDTO.getCodEmpSubstituto());
        EmpregadoEntity empregadoSubstituto = empregadoSubstitutoOptional
                .orElseThrow(() -> new RuntimeException("Empregado Substituto não encontrado"));

        SolicitacaoEntity solicitacao = new SolicitacaoEntity();
        solicitacao.setCodEmpSubstituido(solicitacaoDTO.getCodEmpSubstituido());
        solicitacao.setCodEmpSubstituto(solicitacaoDTO.getCodEmpSubstituto());
        solicitacao.setDataInicial(new Date());
        solicitacao.setPrazo(solicitacaoDTO.getPrazo());
        solicitacao.setIdCargoSubstituto(empregadoSubstituto.getIdCargo());

        SolicitacaoEntity solicitacaoResult = solicitacaoService.createSolicitacao(solicitacao);

        if (solicitacaoResult != null) {
            Optional<EmpregadoEntity> empregadoSubstituidoOptional = empregadoRepository
                    .findByCodigo(solicitacaoDTO.getCodEmpSubstituido());
            EmpregadoEntity empregadoSubstituido = empregadoSubstituidoOptional
                    .orElseThrow(() -> new RuntimeException("Empregado Substituído não encontrado"));

            empregadoSubstituto.setIdCargoProvisorio(empregadoSubstituido.getIdCargo());
            empregadoRepository.save(empregadoSubstituto);
        }

        return solicitacaoResult;

    }

}
