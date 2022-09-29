package com.equipo.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

import com.equipo.model.estado.EstadoTurno;

@Entity
@Table(name = "TURNO")

public class Turno {

    public enum Estado {
       DISPONIBLE, CANCELADO, RESERVADO, CERRADO_CONFORME, CERRADO_INCONFORME, AUSENTE, PRESENTE    	
    }
	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;
    @ManyToOne()
    @JoinColumn(name = "VEHICULO_ID")
    private Vehiculo vehiculo;
    @ManyToOne()
    @JoinColumn(name = "MECANICO_ID")
    private Mecanico mecanico;
    private Date fecha;
    private Time horario;
    private Estado estado;
    @ManyToOne()
    @JoinColumn(name = "SERVICIO_ID")
    private Servicio servicio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

	public void pasarEstado(EstadoTurno reservado) {
		// TODO Auto-generated method stub
		
	}
}