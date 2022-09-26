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

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	@Column(name = "APELLIDO")
    private String apellido;
	@Column(name = "NOMBRE")
    private String nombre;
	@Column(name = "TIPODOCUMENTO")
    private TipoDocumento tipoDocumento;
	@Column(name = "NUMERODOCUMENTO")
    private Integer numerodocumento;
	@Column(name = "ESPECIALIDAD")
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

    public Integer getDocumento() {
        return numerodocumento;
    }

    public void setDocumento(Integer documento) {
        this.numerodocumento = documento;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    public String toString() {
        return this.nombre + " " + this.apellido;
    }
    
}