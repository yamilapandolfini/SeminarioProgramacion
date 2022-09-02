package com.equipo.dto;

import com.equipo.model.Mecanico;
import com.equipo.model.Mecanico.Especialidad;

public class MecanicoDto {
	
	public static MecanicoDto fromMecanico(Mecanico mecanico) {
			
		MecanicoDto dto = new MecanicoDto();
			
			dto.setId(mecanico.getId());
			dto.setApellido(mecanico.getApellido());
			dto.setNombre(mecanico.getNombre());
			dto.setDocumento(mecanico.getTipoDocumento() + " " + mecanico.getDocumento());
			dto.setEspecialidad(mecanico.getEspecialidad());
			
			return dto;
			
		}

	private void setEspecialidad(Especialidad especialidad) {
		// TODO Auto-generated method stub
		
	}

	private void setDocumento(String string) {
		// TODO Auto-generated method stub
		
	}

	private void setNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

	private void setApellido(String apellido) {
		// TODO Auto-generated method stub
		
	}

	private void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
