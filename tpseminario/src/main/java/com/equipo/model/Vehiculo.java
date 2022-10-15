package com.equipo.model;

import javax.persistence.*;

@Entity(name = "Vehiculo")
@Table(name = "VEHICULO")

public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "ANOFABRICACION")
    private Integer anoFabricacion;
    @Column(name = "PATENTE")
    private String patente;
    @Column(name = "aseguradora_id")
    private Integer aseguradora;
    @Column(name = "NUMEROPOLIZA")
    private String numeroPoliza;
    @ManyToOne()
    @JoinColumn(name = "CLIENTE_ID", updatable=false, insertable=false)
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(Integer anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Integer getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(Integer aseguradora) {
        this.aseguradora = aseguradora;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
