package com.equipo.model;

import javax.persistence.*;

@Entity
@Table(name = "INSUMO")
public class Insumo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String marca;
    private String modelo;
    private int numeroParte;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNumeroParte() {
        return numeroParte;
    }

    public void setNumeroParte(int numeroParte) {
        this.numeroParte = numeroParte;
    }
}