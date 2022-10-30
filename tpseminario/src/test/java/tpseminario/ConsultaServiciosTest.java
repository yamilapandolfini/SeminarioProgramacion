package tpseminario;

import java.io.IOException;
//Probar los cambios de servicio como la planilla, la edición y la conformidad

import javax.swing.text.html.ListView;

import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.matcher.control.TextMatchers;

import com.equipo.model.Servicio;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConsultaServiciosTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("/MostrarServicio.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void deben_existir_servicios() {
        FxAssert.verifyThat("#tblServicios", NodeMatchers.isNotNull());
    }

    @Test
    public void seleccion_de_servicio() {
        TableView servicios = lookup("#tblServicios").queryAs(TableView.class);
        servicios.getSelectionModel().selectFirst(); 
    }

    @Test
    public void informacion_cliente() {
        FxAssert.verifyThat("#txtTelefono", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtDocumento", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtApellido", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtNombre", NodeMatchers.isNotNull());
    }
    
    @Test
    public void informacion_vehiculo() {
        FxAssert.verifyThat("#txtMarca", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtModelo", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtAno", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtPatente", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtPoliza", NodeMatchers.isNotNull());
    }
}
