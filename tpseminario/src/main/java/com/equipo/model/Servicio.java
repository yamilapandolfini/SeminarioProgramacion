package com.equipo.model;

import java.util.List;

import javax.persistence.*;

@Entity(name = "Servicio")
@Table(name = "SERVICIO")
public class Servicio {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "TURNO_ID")
    private Integer turno_id;
	
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servicios> servicios;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Insumo> insumos;
    
	@Column(name = "CONFORME")
    private boolean conforme;
	
	@Column(name = "COMENTARIOS")
    private String comentarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTurno() {
        return turno_id;
    }

    public void setTurno(Integer turno) {
        this.turno_id = turno;
    }

    public List<Servicios> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicios> servicios) {
        this.servicios = servicios;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
    }

    public boolean getConforme() {
        return conforme;
    }

    public void setConforme(boolean conforme) {
        this.conforme = conforme;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
   
}