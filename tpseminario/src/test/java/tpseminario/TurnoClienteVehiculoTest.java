package tpseminario;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.ComboBoxMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.matcher.control.TextMatchers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class TurnoClienteVehiculoTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("/NuevoTurno.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void cliente_con_auto_asociado() {
        FxAssert.verifyThat("#btnBuscarCliente", LabeledMatchers.hasText("Buscar Cliente"));
    }

    @After
    public void buscar_cliente() {    	
        clickOn("#btnBuscarCliente");

        TextField nroDoc = lookup("#txtCLNroDocumento").queryAs(TextField.class);
        clickOn(nroDoc).write("29844123");
        type(KeyCode.ENTER);
        
        FxAssert.verifyThat("#btnCLBuscar", LabeledMatchers.hasText("Buscar"));
        clickOn("#btnCLBuscar");
    }

    @After
    public void existe_cliente() { 
        FxAssert.verifyThat("#txtCLNombre", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtCLApellido", NodeMatchers.isNotNull());
        
        FxAssert.verifyThat("#btnCLConfirmar", LabeledMatchers.hasText("Confirmar"));
        clickOn("#btnCLConfirmar");
    }
    
    @After
    public void cliente_seleccionado() {

        FxAssert.verifyThat("#txtTipoDocumento", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtNumeroDocumento", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtApellido", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtNombre", NodeMatchers.isNotNull());

    }
    
    @After
    public void existe_vehiculo() {      
        FxAssert.verifyThat("#btnBuscarVehiculo", LabeledMatchers.hasText("Buscar Vehículo"));
        clickOn("#btnBuscarVehiculo");
        FxAssert.verifyThat("#cboBVPatente", ComboBoxMatchers.hasItems(1) );
        FxAssert.verifyThat("#txtBVMarca", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtBVModelo", NodeMatchers.isNotNull());
        
        FxAssert.verifyThat("#btnBVConfirmar", LabeledMatchers.hasText("Confirmar"));
        clickOn("#btnBVConfirmar");

    }
    
    @After
    public void vehiculo_seleccionado() {

        FxAssert.verifyThat("#txtPatente", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtMarca", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtModelo", NodeMatchers.isNotNull());
        FxAssert.verifyThat("#txtNombre", NodeMatchers.isNotNull());

    }
}
