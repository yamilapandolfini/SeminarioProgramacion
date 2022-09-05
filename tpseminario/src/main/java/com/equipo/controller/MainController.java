package com.equipo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;

public class MainController {
	@FXML
	private Button btnAltaTurno;
	@FXML
	private Button btnConsultaTurno;
	@FXML
	private Button btnConsultaServicios;
	@FXML
	private Button btnGestionPlanilla;
	@FXML
	private Button btnInformeDiario;
	@FXML
	private Button btnInformeMensual;

	// Event Listener on Button[#btnAltaTurno].onAction
	@FXML
	public void clkAltaTurno(ActionEvent event) throws IOException {
		// TODO
	}
	// Event Listener on Button[#btnConsultaTurno].onAction
	@FXML
	public void clkConsultaTurno(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnConsultaServicios].onAction
	@FXML
	public void clkConsultaServicios(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnGestionPlanilla].onAction
	@FXML
	public void clkGestionPlanilla(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnInformeDiario].onAction
	@FXML
	public void clkInformeDiario(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/InformeMensual.fxml"));
			
			Parent root = loader.load();
			
			InformeMensualController controlador = loader.getController();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
			stage.setTitle("Informe díario");
			stage.show();
			
			stage.setOnCloseRequest(e -> controlador.closeWindows());
			
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/InformeMensual.fxml"));
			
			Parent root = loader.load();
			
			InformeMensualController controlador = loader.getController();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
			stage.setTitle("Informe mensual");
			stage.show();
			
			stage.setOnCloseRequest(e -> controlador.closeWindows());
			
			Stage myStage = (Stage) this.btnInformeMensual.getScene().getWindow();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
