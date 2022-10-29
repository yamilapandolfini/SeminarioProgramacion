package tpseminario;

import static org.junit.Assert.*;

import org.junit.Test;

import com.equipo.model.Turno;
import com.equipo.model.estado.EstadoFactory;
import com.equipo.model.estado.EstadoTurno;
import com.equipo.model.estado.ReservadoEstado;

public class EstadoTurnoTest {

    @Test
    public void ciclo_turno() {
        
        Turno turno = new Turno();
        ReservadoEstado estado = (ReservadoEstado) EstadoFactory.getEstado(turno, EstadoTurno.RESERVADO);
        

        if (estado.onDisponible()) {
            fail("Reservado no pasa a Disponible");
        }

    }

}
