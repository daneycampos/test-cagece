package com.br.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "solicitacoes")
public class SolicitacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "cod_emp_substituido")
    private String codEmpSubstituido;
    
    @Column(name = "cod_emp_substituto")
    private String codEmpSubstituto;
    
    @Column(name = "data_inicial")
    private Date dataInicial;
    
    @Column(name = "prazo")
    private Integer prazo;

    @ManyToOne
    @JoinColumn(name = "id_cargo_substituto")
    private CargoEntity idCargoSubstituto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodEmpSubstituido() {
        return codEmpSubstituido;
    }

    public void setCodEmpSubstituido(String codEmpSubstituido) {
        this.codEmpSubstituido = codEmpSubstituido;
    }

    public String getCodEmpSubstituto() {
        return codEmpSubstituto;
    }

    public void setCodEmpSubstituto(String codEmpSubstituto) {
        this.codEmpSubstituto = codEmpSubstituto;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    public CargoEntity getIdCargoSubstituto() {
        return idCargoSubstituto;
    }

    public void setIdCargoSubstituto(CargoEntity idCargoSubstituto) {
        this.idCargoSubstituto = idCargoSubstituto;
    }
}
