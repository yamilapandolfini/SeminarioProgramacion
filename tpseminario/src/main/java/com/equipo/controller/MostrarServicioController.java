package com.equipo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.equipo.dao.MecanicoDao;
import com.equipo.dao.ServicioDao;
import com.equipo.dao.TrabajoDao;
import com.equipo.dao.TurnoDao;
import com.equipo.model.Cliente;
import com.equipo.model.Insumo;
import com.equipo.model.Mecanico;
import com.equipo.model.Servicio;
import com.equipo.model.Trabajo;
import com.equipo.model.Vehiculo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TableView;

public class MostrarServicioController {
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
	private Button btnBuscar;
    @FXML
    private Button btnEditar;
	@FXML
	private Label lblNroServicio;
	@FXML
	private Label lblError;
	@FXML
	private TextField txtNroServicio;
	@FXML
	private TableView<Servicio> tblServicios;
	@FXML
	private TableColumn<Servicio, Integer> tblNroServicio;
	@FXML
    private TableColumn<Servicio, Integer> tblTurno;
	@FXML
	private TableColumn<Servicio, String> tblTrabajos;
	@FXML
    private TableColumn<Servicio, String> tblInsumos;
	@FXML
	private TableColumn<Servicio, String> tblConforme;
	@FXML
    private TableColumn<Servicio, String> tblComentarios;
	@FXML
	private Button btnCargarPlanilla;
	@FXML
	private Button btnGenerarConstancia;
	@FXML
	private Button btnCancelar;
	@FXML
	private Button btnImprimir;
	@FXML
	private ObservableList<Servicio> servicioData = FXCollections.observableArrayList();
	
	
	@FXML
	public void initialize() {
	   
		cargarServicios();
	}
	
	private void cargarServicios() {
		
		ServicioDao servicio = new ServicioDao();
		ObservableList<Servicio> list = servicio.obtenerTodos();
		tblNroServicio.setCellValueFactory(new PropertyValueFactory<Servicio, Integer>("id"));
		tblTurno.setCellValueFactory(new PropertyValueFactory<Servicio, Integer>("turno"));
		tblInsumos.setCellValueFactory(new PropertyValueFactory<Servicio, String>("insumosUsados"));
		tblTrabajos.setCellValueFactory(new PropertyValueFactory<Servicio, String>("trabajosRealizados"));
		tblConforme.setCellValueFactory(new PropertyValueFactory<Servicio, String>("conforme"));
		tblComentarios.setCellValueFactory(new PropertyValueFactory<Servicio, String>("comentarios"));
		tblServicios.setItems(list);
		
	}
	
	@FXML
    public void clkEditarServicio (ActionEvent event) throws IOException {
	    
	    if(tblServicios.getSelectionModel().getSelectedItem() != null) {
	        
	            Servicio servicio = tblServicios.getSelectionModel().getSelectedItem();
	            
	            if (servicio.getConforme() == false) {
	            	
	            	if ((servicio.getInsumos().size() == 0) & (servicio.getTrabajos().size() == 0)){
	                    
	                    lblError.setText("Debe cargar la planilla antes de poder editar el servicio");
	                }
	                else {
	                	FXMLLoader loader = new FXMLLoader();
		                loader.setLocation(getClass().getResource("/EditarServicio.fxml"));
		                Parent tableViewParent = loader.load();
		                Scene tableViewScene = new Scene(tableViewParent);
		                EditarServicioController controller = loader.getController();
		                controller.editarServicio(servicio);
		                
		                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		                window.setOnCloseRequest(e -> controller.closeWindow());
		                window.setScene(tableViewScene);
		                window.show();	
	                } 
	            }
	            else
	            {	                
	                {
	                    lblError.setText("Servicio cerrado como conforme.");
	                }
	                
	            }	            
	    }    
	}
	
	
	
	@FXML
	public void clkCargarPlanilla(ActionEvent event) throws IOException {
	      
	    if(tblServicios.getSelectionModel().getSelectedItem() != null) {
	        
	        Servicio servicio = tblServicios.getSelectionModel().getSelectedItem();
	        
	        if ((servicio.getInsumos().size() == 0) & (servicio.getTrabajos().size() == 0)) {
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(getClass().getResource("/CargarPlanillaDeTrabajo.fxml"));
	            Parent tableViewParent = loader.load();
	            Scene tableViewScene = new Scene(tableViewParent);          
	            CargarPlanillaDeTrabajoController controller = loader.getController();
	            controller.planillaServicio(servicio);
	            
	            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	            window.setOnCloseRequest(e -> controller.closeWindow());
	            window.setScene(tableViewScene);
	            window.show();
	        }
	        else 
	        {
	            lblError.setText("Ya se cargó la Planilla correspondiente al servicio.");
	        }
	    }
	}

	@FXML
	public void clkGenerarConstancia(ActionEvent event) throws IOException {
		
		if(tblServicios.getSelectionModel().getSelectedItem() != null) {
			
			Servicio servicio = tblServicios.getSelectionModel().getSelectedItem();
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/GenerarConstancia.fxml"));
			Parent tableViewParent = loader.load();
			Scene tableViewScene = new Scene(tableViewParent);
			GenerarConstanciaController controller = loader.getController();
			controller.init(servicio);
			
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        window.setOnCloseRequest(e -> controller.closeWindow());
	        window.setScene(tableViewScene);
	        window.show();
		}
	}
	
	@FXML
	public void clkBuscarServicio(ActionEvent event) {
		
		Servicio servicioBuscar = new Servicio();
		ServicioDao servicio = new ServicioDao();
		
		if ( !(txtNroServicio.getText().isEmpty()) ) {
			
			servicioBuscar = servicio.obtenerUno(Integer.valueOf(txtNroServicio.getText()));
			if ( servicioBuscar != null) {
				tblServicios.getItems().clear();
				servicioData.clear();
				tblNroServicio.setCellValueFactory(new PropertyValueFactory<Servicio, Integer>("id"));
				servicioData.add(servicioBuscar);
				tblServicios.setItems(servicioData);
			}
			else
			{
				lblError.setText("El número de servicio no existe");
			}
		}
		else 
		{
			cargarServicios();
		}
	}
	
	@FXML
	public void clkBuscarTurno(MouseEvent  event) {
	    
	    if(tblServicios.getSelectionModel().getSelectedItem() != null) {
	        
	        Servicio servicioSelected = tblServicios.getSelectionModel().getSelectedItem();
	        TurnoDao turnoDao = new TurnoDao();
	        Integer turnoId = servicioSelected.getTurno();
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
	
	// Event Listener on Button[#btnImprimi].onAction
	@FXML
	public void clkImprimirFicha(ActionEvent event) throws IOException {
		
		if(tblServicios.getSelectionModel().getSelectedItem() != null) {
			Servicio servicio = tblServicios.getSelectionModel().getSelectedItem();
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/ImprimirFicha.fxml"));
			Parent tableViewParent = loader.load();
			Scene tableViewScene = new Scene(tableViewParent);
			ImprimirFichaController controller = loader.getController();
			controller.setServicio(servicio);
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        window.setOnCloseRequest(e -> controller.closeWindow());
	        window.setScene(tableViewScene);
	        window.show();
		}
	}
	
	public void closeWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
			
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
	        stage.setTitle("Administración de Turnos");
			stage.show();
			
			Stage myStage = (Stage) this.tblServicios.getScene().getWindow();
			myStage.close();
			
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
