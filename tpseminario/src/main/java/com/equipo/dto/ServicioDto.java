package com.equipo.dto;

import java.util.List;

import com.equipo.model.Insumo;
import com.equipo.model.Servicio;
import com.equipo.model.Trabajo;
import com.equipo.model.Turno;

public class ServicioDto {
	
	public static ServicioDto fromServicio(Servicio servicio) {
		
		ServicioDto dto = new ServicioDto();
		
		dto.setId(servicio.getId());
		dto.setTurno(servicio.getTurno());
		dto.setServicios(servicio.getTrabajos());
		dto.setInsumos(servicio.getInsumos());
		dto.setConforme(servicio.getConforme());
		dto.setComentarios(servicio.getComentarios());
		
		return dto;
		
	}

	private void setComentarios(String comentarios) {
		// TODO Auto-generated method stub
		
	}

	private void setConforme(boolean conforme) {
		// TODO Auto-generated method stub
		
	}

	private void setInsumos(List<Insumo> insumos) {
		// TODO Auto-generated method stub
		
	}

	private void setServicios(List<Trabajo> servicios) {
		// TODO Auto-generated method stub
		
	}

	private void setTurno(Integer integer) {
		// TODO Auto-generated method stub
		
	}

	private void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}
}