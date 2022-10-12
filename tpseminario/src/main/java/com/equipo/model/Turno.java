package com.equipo.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

import com.equipo.model.estado.EstadoTurno;

@Entity(name = "Turno")
@Table(name = "TURNO")

public class Turno {

    public enum Estado {
       DISPONIBLE, CANCELADO, RESERVADO, CERRADO_CONFORME, CERRADO_INCONFORME, AUSENTE, PRESENTE    	
    }
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", updatable=false, insertable=false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "VEHICULO_ID", updatable=false, insertable=false)
    private Vehiculo vehiculo;
    @ManyToOne
    @JoinColumn(name = "MECANICO_ID", updatable=false, insertable=false)
    private Mecanico mecanico;
    @Column(name = "FECHA")
    private Date fecha;
    @Column(name = "HORARIO")
    private Time horario;
    @Column(name = "ESTADO")
    private int estado_ID;
    private Estado estado;

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

	public void pasarEstado(EstadoTurno reservado) {
		// TODO Auto-generated method stub
		
	}
}