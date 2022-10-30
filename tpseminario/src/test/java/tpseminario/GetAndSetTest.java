package tpseminario;

import static org.junit.Assert.*;

import org.junit.Test;
import org.meanbean.test.BeanVerifier;

import com.equipo.model.Aseguradora;
import com.equipo.model.Cliente;
import com.equipo.model.Insumo;
import com.equipo.model.Mecanico;
import com.equipo.model.Servicio;
import com.equipo.model.Trabajo;
import com.equipo.model.Turno;
import com.equipo.model.Vehiculo;

public class GetAndSetTest {

    @Test
    public void testAseguradora() {     
        BeanVerifier.forClass(Aseguradora.class)
        .editSettings()
        .setDefaultIterations(25)
        .edited()
        .verifyGettersAndSetters();
    }
    
    @Test
    public void testCliente() {     
        BeanVerifier.forClass(Cliente.class)
        .editSettings()
        .setDefaultIterations(25)
        .edited()
        .verifyGettersAndSetters();
    }
    
    @Test
    public void testInsumo() {     
        BeanVerifier.forClass(Insumo.class)
        .editSettings()
        .setDefaultIterations(25)
        .edited()
        .verifyGettersAndSetters();
    }

    @Test
    public void testMecanico() {     
        BeanVerifier.forClass(Mecanico.class)
        .editSettings()
        .setDefaultIterations(25)
        .edited()
        .verifyGettersAndSetters();
    }
    
    @Test
    public void testTrabajo() {     
        BeanVerifier.forClass(Trabajo.class)
        .editSettings()
        .setDefaultIterations(25)
        .edited()
        .verifyGettersAndSetters();
    }

    @Test
    public void testServicio() {     
        BeanVerifier.forClass(Servicio.class)
        .editSettings()
        .setDefaultIterations(25)
        .edited()
        .verifyGettersAndSetters();
    }
    
    @Test
    public void testTurno() {
        BeanVerifier.forClass(Turno.class)
        .editSettings()
        .setDefaultIterations(25)
        .addIgnoredProperty(Turno::getHorario)
        .edited()
        .verifyGettersAndSetters();
    }
    
    @Test
    public void testVehiculo() {
        BeanVerifier.forClass(Vehiculo.class)
        .editSettings()
        .setDefaultIterations(25)
        .edited()
        .verifyGettersAndSetters();
    }
    
}
