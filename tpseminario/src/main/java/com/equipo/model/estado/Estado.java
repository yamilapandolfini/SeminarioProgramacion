package com.equipo.model.estado;

import com.equipo.model.Cliente;
import com.equipo.model.Turno;

public abstract class Estado {
	
	protected Turno turno;
	protected EstadoTurno estado;
	
	Estado(Turno turno) {
		this.turno = turno;
	}

	public abstract Boolean onDisponible();
	public abstract Boolean onCancelar();
	public abstract Boolean onReservado(Cliente cliente);
	public abstract Boolean onCerradoConforme();
	public abstract Boolean onCerradoInconforme();
	public abstract Boolean onAusente();
	public abstract Boolean onPresente();
	public abstract EstadoTurno getEstado();
}    