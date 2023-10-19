package com.br.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empregado")
public class EmpregadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "codigo")
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private CargoEntity id_cargo;

    @ManyToOne
    @JoinColumn(name = "id_cargo_provisorio")
    private CargoEntity id_cargo_provisorio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public CargoEntity getIdCargo() {
        return id_cargo;
    }

    public void setIdCargo(CargoEntity id_cargo) {
        this.id_cargo = id_cargo;
    }

    public CargoEntity getIdCargoProvisorio() {
        return id_cargo_provisorio;
    }

    public void setIdCargoProvisorio(CargoEntity id_cargo_provisorio) {
        this.id_cargo_provisorio = id_cargo_provisorio;
    }
}
