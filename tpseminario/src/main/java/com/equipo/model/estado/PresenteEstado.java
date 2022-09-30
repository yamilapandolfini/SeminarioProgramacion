package com.equipo.model.estado;

import com.equipo.model.Cliente;
import com.equipo.model.Turno;

public class PresenteEstado extends Estado {

	PresenteEstado(Turno turno) {
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
		return false;
	}

	@Override
	public Boolean onCerradoConforme() {
		return true;
	}

	@Override
	public Boolean onCerradoInconforme() {
		return true;
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
		return EstadoTurno.PRESENTE;
	}

}
