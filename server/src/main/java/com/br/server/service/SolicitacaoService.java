package com.br.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.server.model.SolicitacaoEntity;
import com.br.server.repository.SolicitacaoRepository;

@Service
public class SolicitacaoService {

    private final SolicitacaoRepository solicitacaoRepository;

    @Autowired
    public SolicitacaoService(SolicitacaoRepository solicitacaoRepository) {
        this.solicitacaoRepository = solicitacaoRepository;
    }

    public List<SolicitacaoEntity> getAllSolicitacoes() {
        return solicitacaoRepository.findAll();
    }

    public SolicitacaoEntity createSolicitacao(SolicitacaoEntity solicitacao) {
        return solicitacaoRepository.save(solicitacao);
    }

}

