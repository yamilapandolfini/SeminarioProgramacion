package com.equipo.model;

import javax.persistence.*;

@Entity
@Table(name = "MECANICO")
public class Mecanico {

    public enum TipoDocumento {
        DNI, CUIT, OTRO
    }

    public enum Especialidad {
        FRENOS, ELECTRICIDAD, TREN_DELANTERO_AMORT, ENCENDIDO_CARBURACION, CHAPA_PINTURA, MECANICA_GRAL    	
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String apellido;
    private String nombre;
    private TipoDocumento tipoDocumento;
    private String documento;
    private Especialidad especialidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}