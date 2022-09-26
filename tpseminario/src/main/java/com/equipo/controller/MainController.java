package com.equipo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController {
	@FXML
	private Button btnAltaTurno;
	@FXML
	private Button btnConsultaTurno;
	@FXML
	private Button btnConsultaServicios;
	@FXML
	private Button btnCargarPlanilla;
	@FXML
	private Button btnInformeDiario;
	@FXML
	private Button btnInformeMensual;

	// Event Listener on Button[#btnAltaTurno].onAction
	@FXML
	public void clkAltaTurno(ActionEvent event) throws IOException {
	
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
			
			Stage myStage = (Stage) this.btnInformeMensual.getScene().getWindow();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	// Event Listener on Button[#btnConsultaTurno].onAction
	@FXML
	public void clkConsultaTurno(ActionEvent event) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/MostrarTurnos.fxml"));
			
			Parent root = loader.load();
			
			MostrarTurnosController controlador = loader.getController();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
			stage.setTitle("Turnos");
			stage.show();
			
			stage.setOnCloseRequest(e -> {
				try {
					controlador.closeWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			Stage myStage = (Stage) this.btnInformeMensual.getScene().getWindow();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	// Event Listener on Button[#btnConsultaServicios].onAction
	@FXML
	public void clkConsultaServicios(ActionEvent event) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/MostrarServicio.fxml"));
			
			Parent root = loader.load();
			
			MostrarServicioController controlador = loader.getController();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
			stage.setTitle("Servicios");
			stage.show();
			
			stage.setOnCloseRequest(e -> controlador.closeWindow());
			
			Stage myStage = (Stage) this.btnInformeMensual.getScene().getWindow();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	// Event Listener on Button[#btnGestionPlanilla].onAction
	@FXML
	public void clkCargarPlanilla(ActionEvent event) throws IOException {
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
			
			Stage myStage = (Stage) this.btnInformeMensual.getScene().getWindow();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	// Event Listener on Button[#btnInformeDiario].onAction
	@FXML
	public void clkInformeDiario(ActionEvent event) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GenerarInformeDiario.fxml"));
			
			Parent root = loader.load();
			
			GenerarInformeDiarioController controlador = loader.getController();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
			stage.setTitle("Informe diario");
			stage.show();
			
			stage.setOnCloseRequest(e -> controlador.closeWindow());
			
			Stage myStage = (Stage) this.btnInformeMensual.getScene().getWindow();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	// Event Listener on Button[#btnInformeMensual].onAction
	@FXML
	public void clkInformeMensual(ActionEvent event) throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GenerarInformeMensual.fxml"));
			
			Parent root = loader.load();
			
			GenerarInformeMensualController controlador = loader.getController();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
			stage.setTitle("Informe mensual");
			stage.show();
			
			stage.setOnCloseRequest(e -> controlador.closeWindow());
			
			Stage myStage = (Stage) this.btnInformeMensual.getScene().getWindow();
			myStage.close();

			GenerarInformeMensualController generarInformeMensualController = new GenerarInformeMensualController();
			generarInformeMensualController.initialize();
			
			
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
