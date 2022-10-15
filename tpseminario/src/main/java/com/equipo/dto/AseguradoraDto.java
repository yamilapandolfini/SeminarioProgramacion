package com.equipo.dto;

import com.equipo.model.Aseguradora;


public class AseguradoraDto {


	public static AseguradoraDto fromAseguradora(Aseguradora aseguradora) {
		
		AseguradoraDto dto = new AseguradoraDto();
		
		dto.setId(aseguradora.getId());
		dto.setNombre(aseguradora.getNombre());		
		
		return dto;
		
	}

	private void setNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

	private void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
