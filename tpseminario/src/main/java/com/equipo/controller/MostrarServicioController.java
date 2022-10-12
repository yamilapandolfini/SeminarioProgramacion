package com.equipo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.equipo.dao.MecanicoDao;
import com.equipo.dao.ServicioDao;
import com.equipo.dao.TrabajoDao;
import com.equipo.model.Insumo;
import com.equipo.model.Mecanico;
import com.equipo.model.Servicio;
import com.equipo.model.Trabajo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TableView;

public class MostrarServicioController {
	@FXML
	private Label lblFecha;
	@FXML
	private Button btnBuscar;
	@FXML
	private Label lblNroServicio;
	@FXML
	private Label lblServicioBuscar;
	@FXML
	private TextField txtNroServicio;
	@FXML
	private DatePicker picFecha;
	@FXML
	private TableView<Servicio> tblServicios;
	@FXML
	private TableColumn<Servicio, Integer> tblNroServicio;
	@FXML
	private TableColumn<Servicio, String> tblConforme;
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
		tblConforme.setCellValueFactory(new PropertyValueFactory<Servicio, String>("conforme"));
		tblServicios.setItems(list);
		
	}
	
	@FXML
	public void clkCargarPlanilla(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/CargarPlanillaDeTrabajo.fxml"));
			
			Parent root = loader.load();
			
			CargarPlanillaDeTrabajoController controlador = loader.getController();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
			stage.setTitle("Cargar planilla");
			stage.show();
			
			stage.setOnCloseRequest(e -> controlador.closeWindow());
			
			Stage myStage = (Stage) this.lblFecha.getScene().getWindow();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
				lblServicioBuscar.setText("El número de servicio no existe");
			}
		}
		else 
		{
			cargarServicios();
		}
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
			
			Stage myStage = (Stage) this.lblFecha.getScene().getWindow();
			myStage.close();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
