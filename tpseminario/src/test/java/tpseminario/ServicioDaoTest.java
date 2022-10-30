package tpseminario;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.equipo.dao.ServicioDao;
import com.equipo.model.Cliente;
import com.equipo.model.Mecanico.Especialidad;
import com.equipo.model.Servicio;

class ServicioDaoTest {

	ServicioDao servicioDao = new ServicioDao();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void ObtenerTodosNoNull() {
		assertNotNull(servicioDao.obtenerTodos());
	}
	
	
	@Test
	void ObtenerUnServicioIDExistente() {
		assertNotNull(servicioDao.obtenerUno(1));
	}
	
	@Test
	void ObtenerUnServicioIDNoExistente() {
		assertNull(servicioDao.obtenerUno(0));
	}
	
	@Test
	void ObtenerServicioCorrecto() {
		Servicio servicio = new Servicio();
		servicio.setTurno(2);
		servicio.setConforme(true);
		servicio.setComentarios("");
		
		var servicioDB = servicioDao.obtenerUno(1);
		
		assertAll(
				() -> assertEquals(servicio.getTurno(), servicioDB.getTurno()),		
				() -> assertEquals(servicio.getConforme(), servicioDB.getConforme()),
				() -> assertEquals(servicio.getComentarios(), servicioDB.getComentarios())		
				);
	}	
	
	@Test
	void ObtenerPorFechaEspecialidadDatosCorrectos() {
		LocalDate fecha = LocalDate.of(2022,10,22);		
		
		assertNotNull(servicioDao.obtenerPorFechaEspecialidad(fecha, 0));
	}
	
	@Test
	void ObtenerPorFechaEspecialidadFechaIncorrecta() {
		LocalDate fecha = LocalDate.of(2020,10,22);
		List<Especialidad> lista = new ArrayList<Especialidad>();
		
		assertEquals(servicioDao.obtenerPorFechaEspecialidad(fecha, 0), lista);
	}
	
	@Test
	void ObtenerPorFechaEspecialidadEspecialidadIncorrecta() {
		LocalDate fecha = LocalDate.of(2022,10,22);		
		List<Especialidad> lista = new ArrayList<Especialidad>();
		
		assertEquals(servicioDao.obtenerPorFechaEspecialidad(fecha, 10), lista);
	}	

	@Test
	void ObtenerPorFechaEspecialidadDatosIncorrectos() {
		LocalDate fecha = LocalDate.of(2020,10,22);		
		List<Especialidad> lista = new ArrayList<Especialidad>();
		
		assertEquals(servicioDao.obtenerPorFechaEspecialidad(fecha, 10), lista);
	}	
	
	@Test
	void ObtenerPorMesAseguradoraDatosCorrectos() {
		int mes = 1;
		int aseguradora = 0;
		
		assertNotNull(servicioDao.obtenerPorMesAseguradora(mes, aseguradora));	
	}
	
	@Test
	void ObtenerPorMesAseguradoraMesIncorrecto() {
		int mes = 0;
		int aseguradora = 0;
		List<Object[]> lista = new ArrayList<Object[]>();
		
		assertEquals(servicioDao.obtenerPorMesAseguradora(mes, aseguradora), lista);	
	}
	
	@Test
	void ObtenerPorMesAseguradoraAseguradoraIncorrecta() {
		int mes = 1;
		int aseguradora = 100;
		List<Object[]> lista = new ArrayList<Object[]>();
		
		assertEquals(servicioDao.obtenerPorMesAseguradora(mes, aseguradora), lista);	
	}
	
	@Test
	void ObtenerPorMesAseguradoraDatosIncorrectos() {
		int mes = 0;
		int aseguradora = 100;
		List<Object[]> lista = new ArrayList<Object[]>();
		
		assertEquals(servicioDao.obtenerPorMesAseguradora(mes, aseguradora), lista);
	}

}
