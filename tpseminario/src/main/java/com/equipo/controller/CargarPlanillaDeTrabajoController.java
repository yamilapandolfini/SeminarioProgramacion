package com.equipo.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.equipo.dao.InsumoDao;
import com.equipo.model.Insumo;

import javafx.collections.ObservableList;
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
	private TextField txtPatente;
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
	private Button btnConstancia;
	@FXML
	private TableView tblServicios;
	@FXML
	private TableColumn tblServicio;
	@FXML
	private TableColumn tblDescripcion;
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
		
		InsumoDao insumo = new InsumoDao();
		ObservableList<Insumo> list = insumo.obtenerTodos();
		
		tblNombre.setCellValueFactory(new PropertyValueFactory<Insumo, String>("nombre"));
		tblMarca.setCellValueFactory(new PropertyValueFactory<Insumo, String>("marca"));
		tblModelo.setCellValueFactory(new PropertyValueFactory<Insumo, String>("modelo"));
		tblNumeroParte.setCellValueFactory(new PropertyValueFactory<Insumo, Integer>("numeroParte"));
		
		tblInsumos.setItems(list);
		
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
