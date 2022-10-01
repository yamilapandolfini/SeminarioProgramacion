package com.equipo.model.estado;

import com.equipo.model.Turno;

public class EstadoFactory {


	public static Estado getEstado(Turno turno, EstadoTurno estadoTurno){
		switch (estadoTurno) {
			case DISPONIBLE: {
				return new DisponibleEstado(turno);
			}
			case CANCELADO: {
				return new CanceladoEstado(turno);
			}
			case RESERVADO: {
				return new ReservadoEstado(turno);
			}
			case CERRADO_CONFORME: {
				return new CerradoConformeEstado(turno);
			}
			case CERRADO_INCONFORME: {
				return new CerradoInconformeEstado(turno);
			}
			case AUSENTE: {
				return new AusenteEstado(turno);
			}
			default: {
				return new PresenteEstado(turno);
			}
		}
	}
}
 