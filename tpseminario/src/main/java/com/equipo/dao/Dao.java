package com.equipo.dao;

import java.util.List;

public interface Dao<Objects> {
	
	void insertar (Objects o);
	void modificar (Objects o);
	void eliminar(Objects o);
	List<Objects> obtenerTodos();

}
