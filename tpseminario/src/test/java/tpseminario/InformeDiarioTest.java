package tpseminario;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.matcher.control.TableViewMatchers;

import com.equipo.model.Mecanico.Especialidad;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class InformeDiarioTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("/GenerarInformeDiario.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void existe_servicio_dia() throws InterruptedException {

        DatePicker dpFecha = lookup("#dpkFecha").queryAs(DatePicker.class);
        dpFecha.setValue(LocalDate.of(2022, 10 , 17));

        Platform.runLater(()->lookup("#ddEspecialidad").queryAs(ComboBox.class).getSelectionModel().select(2));
        
        clickOn("#btnBuscar");
        FxAssert.verifyThat("#tblServicios", TableViewMatchers.hasItems(1));
    }
    
    
    
}
