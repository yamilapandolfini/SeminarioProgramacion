package com.equipo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.equipo.dao.ServicioDao;
import com.equipo.dao.TurnoDao;
import com.equipo.model.Cliente;
import com.equipo.model.Servicio;
import com.equipo.model.Turno;
import com.equipo.model.Vehiculo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TableView;

public class MostrarTurnosController {
	@FXML
	private Label lblFecha;
	@FXML
	private Button btnBuscar;
	@FXML
	private Label lblNroTurno;
    @FXML
    private Label lblTurnoBuscar;
	@FXML
	private TextField txtNroTurno;
	@FXML
	private DatePicker dpFecha;
	@FXML
	private TableView<Turno> tblTurnos;
	@FXML
	private TableColumn<Turno, Integer> tblNroTurno;
    @FXML
    private TableColumn<Turno, String> tblFecha;
    @FXML
    private TableColumn<Turno, String> tblHorario;    
    @FXML
    private TableColumn<Turno, String> tblEstado;
    @FXML
	private Button btnNuevoTurno;
    @FXML
    private Button btnLimpiar;
	@FXML
	private Button btnEditarTurno;
	@FXML
	private Button btnEliminarTurno;
	@FXML
	private Button btnRegistrarAsistencia;
	@FXML
	private Button btnCancelar;
	@FXML
    private ObservableList<Turno> turnoData = FXCollections.observableArrayList();
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDocumento;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtAno;
    @FXML
    private TextField txtPatente;
    @FXML
    private TextField txtPoliza;
    
    @FXML
    public void initialize() {
            
        dpFecha.setOnAction(event); 
        cargarTurnos();
    }
    
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
    public void handle(ActionEvent e) 
        { 
           if (dpFecha.getValue() != null) {
               TurnoDao turno = new TurnoDao();            
               ObservableList<Turno> turnos = turno.obtenerPorFecha(dpFecha.getValue());
               tblTurnos.setItems(turnos);   
           }
        } 
    };

    @FXML
    private void limpiarBusqueda() {
        dpFecha.setValue(null);
        txtNroTurno.setText("");
        cargarTurnos();
    }
    private void cargarTurnos() {
        
        TurnoDao turno = new TurnoDao();
        ObservableList<Turno> list = turno.obtenerTodos();
        tblNroTurno.setCellValueFactory(new PropertyValueFactory<Turno, Integer>("id"));
        tblFecha.setCellValueFactory(new PropertyValueFactory<Turno, String>("fecha"));
        tblHorario.setCellValueFactory(new PropertyValueFactory<Turno, String>("horario"));
        tblEstado.setCellValueFactory(new PropertyValueFactory<Turno, String>("estado"));
        tblTurnos.setItems(list);
        
    }
    
    @FXML
    public void clkBuscar(ActionEvent event) {
        
        Turno turnoBuscar = new Turno();
        TurnoDao turno = new TurnoDao();
        
        if ( !(txtNroTurno.getText().isEmpty()) ) {
            
            turnoBuscar = turno.obtenerUno(Integer.valueOf(txtNroTurno.getText()));
            if ( turnoBuscar != null) {
                tblTurnos.getItems().clear();
                turnoData.clear();
                tblNroTurno.setCellValueFactory(new PropertyValueFactory<Turno, Integer>("id"));
                turnoData.add(turnoBuscar);
                tblTurnos.setItems(turnoData);
            }
            else
            {
                lblTurnoBuscar.setText("El número de turno no existe");
            }
        }
        else 
        {
            cargarTurnos();
        }
    }
    
	@FXML
	public void clkNuevoTurno(ActionEvent event) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/NuevoTurno.fxml"));
			
			Parent root = loader.load();
			
			NuevoTurnoController controlador = loader.getController();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
			stage.setTitle("Nuevo turno");
			stage.show();
			
			stage.setOnCloseRequest(e -> controlador.closeWindow());
			
			Stage myStage = (Stage) this.lblFecha.getScene().getWindow();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	// Event Listener on Button[#btnEditarTurno].onAction
	@FXML
	public void clkEditarTurno(ActionEvent event) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/EditarTurno.fxml"));
			
			Parent root = loader.load();
			
			EditarTurnoController controlador = loader.getController();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
			stage.setTitle("Editar turno");
			stage.show();
			
			stage.setOnCloseRequest(e -> {
				try {
					controlador.closeWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			Stage myStage = (Stage) this.lblFecha.getScene().getWindow();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
    @FXML
    public void clkBuscarTurno(MouseEvent  event) {
        
        if(tblTurnos.getSelectionModel().getSelectedItem() != null) {
            
            Turno turnoSelected = tblTurnos.getSelectionModel().getSelectedItem();
            TurnoDao turnoDao = new TurnoDao();
            Integer turnoId = turnoSelected.getId();
            Cliente cliente = turnoDao.obtenerCliente(turnoId);
            
            if (cliente != null) {
                mostrarCliente(cliente);
            }
        
            Vehiculo vehiculo = turnoDao.obtenerVehiculo(turnoId);
            
            if (vehiculo != null) {
                mostrarVehiculo(vehiculo);
            }
            
        }
    }

    @FXML
    public void mostrarCliente(Cliente cliente) {
        txtNombre.setText(cliente.getNombre());
        txtApellido.setText(cliente.getApellido());
        txtDocumento.setText(cliente.getDocumento().toString());
        txtTelefono.setText(cliente.getTelefono().toString());
    }
    
    @FXML
    public void mostrarVehiculo(Vehiculo vehiculo) {
        txtMarca.setText(vehiculo.getMarca());
        txtModelo.setText(vehiculo.getModelo());
        txtAno.setText(vehiculo.getAnoFabricacion().toString());
        txtPatente.setText(vehiculo.getPatente());
        txtPoliza.setText(vehiculo.getNumeroPoliza());
    }
    
	// Event Listener on Button[#btnEliminarTurno].onAction
	@FXML
	public void clkEliminarTurno(ActionEvent event) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/EliminarTurno.fxml"));
			
			Parent root = loader.load();
			
			EliminarTurnoController controlador = loader.getController();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
			stage.setTitle("Servicios");
			stage.show();
			
			stage.setOnCloseRequest(e -> {
				try {
					controlador.closeWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			Stage myStage = (Stage) this.lblNroTurno.getScene().getWindow();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	// Event Listener on Button[#btnRegistrarAsistencia].onAction
    @FXML
    public void clkRegistrarAsistencia(ActionEvent event) {
        Turno turnoSelected = tblTurnos.getSelectionModel().getSelectedItem();
        TurnoDao turnoDao = new TurnoDao();        
        turnoDao.cambiarEstado(turnoSelected, 6);
        
        Servicio servicioNuevo = new Servicio();
        servicioNuevo.setTurno(turnoSelected.getId());
        ServicioDao servicioDao = new ServicioDao();
        servicioDao.insertar(servicioNuevo);
        
        cargarTurnos();
    }
	
	public void closeWindow() throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
			
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
	        stage.setTitle("Administración de Turnos");
			stage.show();
			
			Stage myStage = (Stage) this.lblNroTurno.getScene().getWindow();
			myStage.close();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
