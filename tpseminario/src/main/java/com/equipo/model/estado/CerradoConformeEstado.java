package com.equipo.model.estado;

import com.equipo.model.Cliente;
import com.equipo.model.Turno;

public class CerradoConformeEstado extends Estado {

	CerradoConformeEstado(Turno turno) {
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
		return EstadoTurno.CERRADO_CONFORME;
	}

}
