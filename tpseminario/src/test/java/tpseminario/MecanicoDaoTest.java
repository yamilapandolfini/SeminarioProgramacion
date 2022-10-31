package tpseminario;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.equipo.dao.MecanicoDao;
import com.equipo.dao.ServicioDao;
import com.equipo.model.Mecanico;
import com.equipo.model.Mecanico.Especialidad;

class MecanicoDaoTest {

	MecanicoDao mecanicoDao = new MecanicoDao();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void ObtenerTodosNoNull() {
		assertNotNull(mecanicoDao.obtenerTodos());
	}
	
	@Test
	void ObtenerTodosPorEspecialidadExistente() {
		assertNotNull(mecanicoDao.obtenerTodosPorEspecialidad(1));
	}
	
	@Test
	void ObtenerTodosPorEspecialidadNoExistente() {
		List<Mecanico> lista = new ArrayList<Mecanico>();
		assertEquals(mecanicoDao.obtenerTodosPorEspecialidad(100), lista);
	}

}
