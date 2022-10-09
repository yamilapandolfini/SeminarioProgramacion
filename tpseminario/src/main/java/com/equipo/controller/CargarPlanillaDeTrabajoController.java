package com.equipo.controller;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.equipo.dao.InsumoDao;
import com.equipo.dao.ServicioDao;
import com.equipo.dao.ServiciosDao;
import com.equipo.model.Insumo;
import com.equipo.model.Servicio;
import com.equipo.model.Servicios;

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
	private Label lblPatente;
	@FXML
	private TextField txtTurno;
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
	private TableView<Servicios> tblServicios;
	@FXML
	private TableColumn<Servicios, String> tblServicio;
	@FXML
	private TableColumn<Servicios, String> tblDescripcion;
	@FXML
	private TableView<Servicios> tblServiciosDB;
	@FXML
	private TableColumn<Servicios, String> tblServicioDB;
	@FXML
	private TableColumn<Servicios, String> tblDescripcionDB;
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
		ServiciosDao servicios = new ServiciosDao();
		ObservableList<Servicios> list = servicios.obtenerTodos();
		tblServicioDB.setCellValueFactory(new PropertyValueFactory<Servicios, String>("servicio"));
		tblDescripcionDB.setCellValueFactory(new PropertyValueFactory<Servicios, String>("descripcion"));
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

			Servicios servicio = tblServiciosDB.getSelectionModel().getSelectedItem();
			
			tblServicio.setCellValueFactory(new PropertyValueFactory<Servicios, String>("servicio"));
			tblDescripcion.setCellValueFactory(new PropertyValueFactory<Servicios, String>("descripcion"));
			
			ObservableList<Servicios> list = tblServicios.getItems();
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

			Servicios servicio = tblServicios.getSelectionModel().getSelectedItem();

			ObservableList<Servicios> list = tblServicios.getItems();
			list.remove(servicio);
			tblServicios.setItems(list);
		
		}

	}
	
	@FXML
	public void clkGuardar(ActionEvent event) throws IOException {
		
		ServicioDao servicioDAO = new ServicioDao();
		Servicio servicio = new Servicio();
		
		ObservableList<Insumo> listInsumos = tblInsumos.getItems();
		ObservableList<Servicios> listServicios = tblServicios.getItems();
		
		servicio.setInsumos(listInsumos);
		servicio.setServicios(listServicios);
		servicio.setTurno(Integer.valueOf(txtTurno.getText()));
		
		servicioDAO.insertar(servicio);
		
		closeWindow();
		
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
			
			Stage myStage = (Stage) this.lblPatente.getScene().getWindow();
			myStage.close();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
