package com.equipo.dto;

import com.equipo.model.Servicios;

public class ServiciosDto {


	public static ServiciosDto fromServicio(Servicios servicios) {
		
		ServiciosDto dto = new ServiciosDto();
		
		dto.setId(servicios.getId());
		dto.setDescripcion(servicios.getDescripcion());
		
		return dto;
		
	}

	private void setDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		
	}

	private void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}
}