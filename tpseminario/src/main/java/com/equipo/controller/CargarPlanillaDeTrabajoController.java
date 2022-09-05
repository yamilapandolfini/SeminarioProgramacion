package com.equipo.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
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
	private TableView tblInsumos;
	@FXML
	private TableColumn tblInsumo;
	@FXML
	private TableColumn tblMarca;
	@FXML
	private TableColumn tblParte;
	@FXML
	private TableColumn tblPrecio;
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
