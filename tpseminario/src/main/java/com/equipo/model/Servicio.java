package com.equipo.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Entity(name = "Servicio")
@Table(name = "SERVICIO")
public class Servicio {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "TURNO_ID")
    private Integer turno_id;
	
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Trabajo> trabajos;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
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

    public List<Trabajo> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(List<Trabajo> trabajos) {
        this.trabajos = trabajos;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }
    
    public String getInsumosUsados() {
        
        if (this.insumos != null && this.insumos.size() > 0) {
            return "Si";
        }
        else {
            return "-";
        }
    }
    
    public String getTrabajosRealizados() {
        
        if (this.trabajos != null && this.trabajos.size() > 0) {
            return "Si";
        }
        else {
            return "-";
        }
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