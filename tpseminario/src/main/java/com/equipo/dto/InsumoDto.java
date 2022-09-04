package com.equipo.dto;

import com.equipo.model.Insumo;


public class InsumoDto {


	public static InsumoDto fromInsumo(Insumo insumo) {
		
		InsumoDto dto = new InsumoDto();
		
		dto.setId(insumo.getId());
		dto.setNombre(insumo.getNombre());
		dto.setMarca(insumo.getMarca());
		dto.setModelo(insumo.getModelo());
		dto.setNumeroParte(insumo.getNumeroParte());
		
		return dto;
		
	}

	private void setNumeroParte(int numeroParte) {
		// TODO Auto-generated method stub
		
	}

	private void setModelo(String modelo) {
		// TODO Auto-generated method stub
		
	}

	private void setMarca(String marca) {
		// TODO Auto-generated method stub
		
	}

	private void setNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

	private void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
