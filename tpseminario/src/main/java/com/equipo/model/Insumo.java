package com.equipo.model;

import javax.persistence.*;

@Entity
@Table(name = "INSUMO")
public class Insumo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "NUMEROPARTE")
    private int numeroParte;

    public Insumo() {
    	
    }
    
    public Insumo(String nombre, String marca, String modelo, Integer numeroParte) {
    	this.nombre = nombre;
    	this.marca = marca;
    	this.modelo = modelo;
    	this.numeroParte = numeroParte;
    }
    
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
    
    public String toString() {
        return nombre;
    }
}