package com.equipo.dto;

import com.equipo.model.Cliente;


public class ClienteDto {


	public static ClienteDto fromVehiculo(Cliente cliente) {
		
		ClienteDto dto = new ClienteDto();
		
		dto.setId(cliente.getId());
		dto.setApellido(cliente.getApellido());
		dto.setNombre(cliente.getNombre());
		dto.setDocumento(cliente.getTipoDocumento() + " " + cliente.getDocumento());
		
		return dto;
		
	}

	private void setDocumento(String string) {
		// TODO Auto-generated method stub
		
	}

	private void setNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

	private void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	private void setApellido(String apellido) {
		// TODO Auto-generated method stub
		
	}
}