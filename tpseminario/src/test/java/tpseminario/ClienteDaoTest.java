package tpseminario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.equipo.dao.ClienteDao;
import com.equipo.model.Cliente;

class ClienteDaoTest {

	ClienteDao clienteDao = new ClienteDao(); 
	
	@BeforeEach
	void setUp() throws Exception {		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void ObtenerTodosNoNull() {
		assertNotNull(clienteDao.obtenerTodos());
	}
	
	@Test
	void ObtenerClienteDatosCorrectos() {
		assertNotNull(clienteDao.obtenerClientePorDocumento(0, 29844123));		 
	}

	@Test
	void ObtenerClienteTipoDniIncorrecto() {
		assertNull(clienteDao.obtenerClientePorDocumento(1, 29844123));		 
	}

	@Test
	void ObtenerClienteNroDniIncorrecto() {
		assertNull(clienteDao.obtenerClientePorDocumento(0, 29844124));		 
	}
	
	@Test
	void ObtenerClienteDatosIncorrectos() {
		assertNull(clienteDao.obtenerClientePorDocumento(2, 29844124));		 
	}
	
	@Test
	void ObtenerClienteCorrecto() {
		Cliente cliente = new Cliente();
		cliente.setApellido("RODRIGUEZ");
		cliente.setNombre("CRISTIAN");
		cliente.setTipoDocumento(0);
		cliente.setDocumento(29844123);
		cliente.setTelefono(54413321);
		
		var clienteDB = clienteDao.obtenerClientePorDocumento(0, 29844123);
		
		assertAll(
				() -> assertEquals(cliente.getApellido(), clienteDB.getApellido()),		
				() -> assertEquals(cliente.getNombre(), clienteDB.getNombre()),
				() -> assertEquals(cliente.getTipoDocumento(), clienteDB.getTipoDocumento()),
				() -> assertEquals(cliente.getDocumento(), clienteDB.getDocumento()),
				() -> assertEquals(cliente.getTelefono(), clienteDB.getTelefono())
				);
	}
}
