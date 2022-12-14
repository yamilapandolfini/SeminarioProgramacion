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

public class EliminarTurnoController {
	@FXML
	private Label lblNroTurno;
	@FXML
	private TextField txtNroTurno;
	@FXML
	private Label lblFecha;
	@FXML
	private Label lblHorario;
	@FXML
	private Label lblPatente;
	@FXML
	private Label lblMarca;
	@FXML
	private Label lblModelo;
	@FXML
	private Label lblTipoDocumento;
	@FXML
	private Label lblNumeroDocumento;
	@FXML
	private Label lblApellido;
	@FXML
	private Label lblNombre;
	@FXML
	private Label lblNumeroPoliza;
	@FXML
	private Button btnEliminarTurno;
	@FXML
	private Label lblEmpresaAseguradora;
	@FXML
	private TextField txtFecha;
	@FXML
	private TextField txtHorario;
	@FXML
	private TextField txtPatente;
	@FXML
	private TextField txtMarca;
	@FXML
	private TextField txtModelo;
	@FXML
	private TextField txtTipoDocumento;
	@FXML
	private TextField txtNumeroDocumento;
	@FXML
	private TextField txtApellido;
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtNumeroPoliza;
	@FXML
	private TextField txtEmpresaAseguradora;
	@FXML
	private Button btnCancelar;
	@FXML
	private Label lblEspecialidad;
	@FXML
	private Label lblMecanico;
	@FXML
	private TextField txtEspecialidad;
	@FXML
	private TextField txtMecanico;

	public void closeWindow() throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/MostrarTurnos.fxml"));
			
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
	        stage.setTitle("Turnos");
			stage.show();
			
			Stage myStage = (Stage) this.txtPatente.getScene().getWindow();
			myStage.close();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
