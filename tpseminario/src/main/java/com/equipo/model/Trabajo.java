package com.equipo.model;

import javax.persistence.*;

@Entity(name = "Trabajo")
@Table(name = "TRABAJO")
public class Trabajo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Integer id;
	
	@Column(name = "TRABAJO")
    private String trabajo;
	
	@Column(name = "DESCRIPCION")
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String toString( ) {
    	return this.trabajo;
    }
}