package com.br.server.dto;

public class SolicitacaoDTO {
    private String codEmpSubstituido;
    private String codEmpSubstituto;
    private Integer prazo;

   public String getCodEmpSubstituido() {
        return this.codEmpSubstituido;
    }

    public void setCodEmpSubstituido(String codEmpSubstituido) {
        this.codEmpSubstituido = codEmpSubstituido;
    }

    public String getCodEmpSubstituto() {
        return this.codEmpSubstituto;
    }

    public void setCodEmpSubstituto(String codEmpSubstituto) {
        this.codEmpSubstituto = codEmpSubstituto;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }
}  

