package com.equipo.model;

import java.util.List;

import javax.persistence.*;

@Entity(name = "Cliente")
@Table(name = "CLIENTE")
public class Cliente {

    public enum TipoDocumento {
        DNI, CUIT, OTRO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TIPO_DOCUMENTO")
    private TipoDocumento tipoDocumento;
    @Column(name = "DOCUMENTO")
    private String documento;
    @Column(name = "TELEFONO")
    private int telefono;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    //private List<Vehiculo> vehiculos;

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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    
//    public List<Vehiculo> getVehiculos() {
//        return vehiculos;
//    }
//
//    public void setVehiculos(List<Vehiculo> vehiculos) {
//        this.vehiculos = vehiculos;
//    }
}