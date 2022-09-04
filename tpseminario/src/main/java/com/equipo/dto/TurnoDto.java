package com.equipo.dto;

import com.equipo.model.Cliente;
import com.equipo.model.Mecanico;
import com.equipo.model.Servicio;
import com.equipo.model.Turno;
import com.equipo.model.Turno.Estado;
import com.equipo.model.Vehiculo;

public class TurnoDto {
	
	public static TurnoDto fromTurno(Turno turno) {
		
		TurnoDto dto = new TurnoDto();
		
		dto.setId(turno.getId());
		dto.setCliente(turno.getCliente());
		dto.setVehiculo(turno.getVehiculo());
		dto.setMecanico(turno.getMecanico());
		dto.setFecha(turno.getFecha() + " " + turno.getHorario());
		dto.setEstado(turno.getEstado());
		dto.setServicio(turno.getServicio());
		return dto;
		
	}

	private void setServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		
	}

	private void setEstado(Estado estado) {
		// TODO Auto-generated method stub
		
	}

	private void setFecha(String string) {
		// TODO Auto-generated method stub
		
	}

	private void setMecanico(Mecanico mecanico) {
		// TODO Auto-generated method stub
		
	}

	private void setVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		
	}

	private void setCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	private void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
