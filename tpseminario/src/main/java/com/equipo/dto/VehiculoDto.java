package com.equipo.dto;

import com.equipo.model.Vehiculo;


public class VehiculoDto {


	public static VehiculoDto fromVehiculo(Vehiculo vehiculo) {
		
		VehiculoDto dto = new VehiculoDto();
		
		dto.setMarca(vehiculo.getMarca());
		dto.setAnoFabricacion(vehiculo.getAnoFabricacion());
		dto.setModelo(vehiculo.getModelo());
		dto.setPatente(vehiculo.getPatente());
		dto.setPoliza(vehiculo.getAseguradora().toString() + " " + vehiculo.getNumeroPoliza() + " " + vehiculo.getId());
		return dto;
		
	}

	private void setAnoFabricacion(Integer integer) {
		// TODO Auto-generated method stub
		
	}

	private void setPoliza(String numeroPoliza) {
		// TODO Auto-generated method stub
		
	}

	private void setMarca(String marca) {
		// TODO Auto-generated method stub
		
	}

	private void setPatente(String patente) {
		// TODO Auto-generated method stub
		
	}

	private void setModelo(String modelo) {
		// TODO Auto-generated method stub
		
	}

}