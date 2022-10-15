package com.equipo.controller;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.equipo.dao.InsumoDao;
import com.equipo.dao.ServicioDao;
import com.equipo.dao.TrabajoDao;
import com.equipo.model.Insumo;
import com.equipo.model.Servicio;
import com.equipo.model.Trabajo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class CargarPlanillaDeTrabajoController {
	@FXML
	private Label lblInicio;
	@FXML
	private Button btnBuscar;
	@FXML
	private TableView<Insumo> tblInsumos;
	@FXML
	private TableColumn<Insumo, String> tblNombre;
	@FXML
	private TableColumn<Insumo, String> tblMarca;
	@FXML
	private TableColumn<Insumo, String> tblModelo;
	@FXML
	private TableColumn<Insumo, Integer> tblNumeroParte;
	@FXML
	private TableView<Insumo> tblInsumosDB;
	@FXML
	private TableColumn<Insumo, String> tblNombreDB;
	@FXML
	private TableColumn<Insumo, String> tblMarcaDB;
	@FXML
	private TableColumn<Insumo, String> tblModeloDB;
	@FXML
	private TableColumn<Insumo, Integer> tblNumeroParteDB;
	@FXML
	private Button btnConstancia;
	@FXML
	private TableView<Trabajo> tblServicios;
	@FXML
	private TableColumn<Trabajo, String> tblServicio;
	@FXML
	private TableColumn<Trabajo, String> tblDescripcion;
	@FXML
	private TableView<Trabajo> tblServiciosDB;
	@FXML
	private TableColumn<Trabajo, String> tblServicioDB;
	@FXML
	private TableColumn<Trabajo, String> tblDescripcionDB;
	@FXML
	private Button btnAgregarInsumo;
	@FXML
	private Button btnRemoverInsumo;
	@FXML
	private Button btnAgregarServicio;
	@FXML
	private Button btnRemoverServicio;
	@FXML
	private Button btnGuardar;
	@FXML
	private Button btnCerrar;
	@FXML
	private Button btnCancelar;
	@FXML
	private Servicio servicio;
	
	@FXML
	public void initialize() {
		
		cargarInsumos();
		cargarServicios();
		
	}
	
	private void cargarInsumos() {
		InsumoDao insumo = new InsumoDao();
		ObservableList<Insumo> list = insumo.obtenerTodos();
		tblNombreDB.setCellValueFactory(new PropertyValueFactory<Insumo, String>("nombre"));
		tblMarcaDB.setCellValueFactory(new PropertyValueFactory<Insumo, String>("marca"));
		tblModeloDB.setCellValueFactory(new PropertyValueFactory<Insumo, String>("modelo"));
		tblNumeroParteDB.setCellValueFactory(new PropertyValueFactory<Insumo, Integer>("numeroParte"));
		tblInsumosDB.setItems(list);
	}
	
	private void cargarServicios() {
		TrabajoDao servicios = new TrabajoDao();
		ObservableList<Trabajo> list = servicios.obtenerTodos();
		tblServicioDB.setCellValueFactory(new PropertyValueFactory<Trabajo, String>("trabajo"));
		tblDescripcionDB.setCellValueFactory(new PropertyValueFactory<Trabajo, String>("descripcion"));
		tblServiciosDB.setItems(list);
	}
	
	@FXML
	public void clkAgregarInsumo(ActionEvent event) throws IOException {
		
		if(tblInsumosDB.getSelectionModel().getSelectedItem() != null) {

			Insumo insumo = tblInsumosDB.getSelectionModel().getSelectedItem();
			
			tblNombre.setCellValueFactory(new PropertyValueFactory<Insumo, String>("nombre"));
			tblMarca.setCellValueFactory(new PropertyValueFactory<Insumo, String>("marca"));
			tblModelo.setCellValueFactory(new PropertyValueFactory<Insumo, String>("modelo"));
			tblNumeroParte.setCellValueFactory(new PropertyValueFactory<Insumo, Integer>("numeroParte"));
			
			ObservableList<Insumo> list = tblInsumos.getItems();
			list.add(insumo);
			tblInsumos.setItems(list);
		
		}
	}

	@FXML
	public void clkAgregarServicio(ActionEvent event) throws IOException {
		
		if(tblServiciosDB.getSelectionModel().getSelectedItem() != null) {

			Trabajo servicio = tblServiciosDB.getSelectionModel().getSelectedItem();
			
			tblServicio.setCellValueFactory(new PropertyValueFactory<Trabajo, String>("trabajo"));
			tblDescripcion.setCellValueFactory(new PropertyValueFactory<Trabajo, String>("descripcion"));
			
			ObservableList<Trabajo> list = tblServicios.getItems();
			list.add(servicio);
			tblServicios.setItems(list);
		
		}
	}
	
	@FXML
	public void clkRemoverInsumo(ActionEvent event) throws IOException {
		
		if(tblInsumos.getSelectionModel().getSelectedItem() != null) {

			Insumo insumo = tblInsumos.getSelectionModel().getSelectedItem();

			ObservableList<Insumo> list = tblInsumos.getItems();
			list.remove(insumo);
			tblInsumos.setItems(list);

		}
	}
	
	@FXML
	public void clkRemoverServicio(ActionEvent event) throws IOException {
		
		if(tblServicios.getSelectionModel().getSelectedItem() != null) {

			Trabajo servicio = tblServicios.getSelectionModel().getSelectedItem();

			ObservableList<Trabajo> list = tblServicios.getItems();
			list.remove(servicio);
			tblServicios.setItems(list);
		
		}

	}
	
	@FXML
	public void clkGuardar(ActionEvent event) throws IOException {
	    
	    Boolean cambio = false;
		Integer cantTrabajos = tblServicios.getItems().size();
		Integer cantInsumos = tblInsumos.getItems().size();
		
		if ((cantTrabajos != 0) || (cantInsumos != 0)) {
			
			ServicioDao servicioDAO = new ServicioDao();
			Servicio servicio = new Servicio();
			
			if (cantTrabajos != 0) {
				ObservableList<Trabajo> listServicios = tblServicios.getItems();
				servicio.setTrabajos(listServicios);
				cambio = true;
			}
			if (cantInsumos != 0)  {
				ObservableList<Insumo> listInsumos = tblInsumos.getItems();
				servicio.setInsumos(listInsumos);
				cambio = true;
			}
	
	    if (cambio) {
	        servicioDAO.modificar(this.servicio); 
	    }	
		
		this.servicio = null;
			
		closeWindow();	
		}	
	}
	
    @FXML
    public void planillaServicio(Servicio servicio) {
        this.servicio = servicio; 
    }

	public void closeWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/MostrarServicio.fxml"));
			
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
	        stage.setTitle("Administración de Turnos");
			stage.show();
			
			Stage myStage = (Stage) this.tblInsumos.getScene().getWindow();
			myStage.close();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
