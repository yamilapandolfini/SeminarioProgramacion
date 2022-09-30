package com.equipo.model.estado;

import com.equipo.model.Cliente;
import com.equipo.model.Turno;

public class DisponibleEstado extends Estado {

	DisponibleEstado(Turno turno) {
		super(turno);
	}

	@Override
	public Boolean onDisponible() {
		return false;
	}

	@Override
	public Boolean onCancelar() {
		return false;
	}

	@Override
	public Boolean onReservado(Cliente cliente) {
		turno.setCliente(cliente);
		turno.pasarEstado(EstadoTurno.RESERVADO);		
		return true;
	}

	@Override
	public Boolean onCerradoConforme() {
		return false;
	}

	@Override
	public Boolean onCerradoInconforme() {
		return false;
	}

	@Override
	public Boolean onAusente() {
		return false;
	}

	@Override
	public Boolean onPresente() {
		return false;
	}

	@Override
	public EstadoTurno getEstado() {
		// TODO Auto-generated method stub
		return EstadoTurno.DISPONIBLE;
	}

	
	
}
