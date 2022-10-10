package com.equipo.dto;

import com.equipo.model.Trabajo;

public class TrabajoDto {


	public static TrabajoDto fromServicio(Trabajo trabajo) {
		
		TrabajoDto dto = new TrabajoDto();
		
		dto.setId(trabajo.getId());
		dto.setDescripcion(trabajo.getDescripcion());
		
		return dto;
		
	}

	private void setDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		
	}

	private void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}
}