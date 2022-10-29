package tpseminario;

import java.io.IOException;
//Probar los cambios de servicio como la planilla, la edición y la conformidad

import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.matcher.control.TextMatchers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NuevoTurnoTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Administración de Turnos");
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void debe_contener_boton_con_texto() {
        FxAssert.verifyThat(".button", LabeledMatchers.hasText("Alta de Turno"));
    }

    @Test
    public void abrir_nuevo_turno_con_todos_los_campos() {    	
        clickOn(".button");

        FxAssert.verifyThat("#txtNroTurno", NodeMatchers.isVisible());
        FxAssert.verifyThat("#txtFecha", NodeMatchers.isVisible());
        FxAssert.verifyThat("#txtHorario", NodeMatchers.isVisible());
        FxAssert.verifyThat("#txtEspecialidad", NodeMatchers.isVisible());
        FxAssert.verifyThat("#txtMecanico", NodeMatchers.isVisible());
        FxAssert.verifyThat("#txtTipoDocumento", NodeMatchers.isVisible());
        FxAssert.verifyThat("#txtNumeroDocumento", NodeMatchers.isVisible());
        FxAssert.verifyThat("#txtApellido", NodeMatchers.isVisible());
        FxAssert.verifyThat("#txtNombre", NodeMatchers.isVisible());
        FxAssert.verifyThat("#txtPatente", NodeMatchers.isVisible());
        FxAssert.verifyThat("#txtMarca", NodeMatchers.isVisible());
        FxAssert.verifyThat("#txtModelo", NodeMatchers.isVisible());
        FxAssert.verifyThat("#txtNumeroPoliza", NodeMatchers.isVisible());
        FxAssert.verifyThat("#txtEmpresaAseguradora", NodeMatchers.isVisible());
    }

}
