package com.equipo.model.estado;

import com.equipo.model.Cliente;
import com.equipo.model.Turno;

public class ReservadoEstado extends Estado {

	ReservadoEstado(Turno turno) {
		super(turno);
	}

	@Override
	public Boolean onDisponible() {
		return false;
	}

	@Override
	public Boolean onCancelar() {
		return true;
	}

	@Override
	public Boolean onReservado(Cliente cliente) {
		return false;
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
		return true;
	}

	@Override
	public Boolean onPresente() {
		return true;
	}

	@Override
	public EstadoTurno getEstado() {
		return EstadoTurno.RESERVADO;
	}

}
