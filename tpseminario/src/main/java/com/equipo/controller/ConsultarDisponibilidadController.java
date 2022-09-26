package com.equipo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.equipo.dao.MecanicoDao;
import com.equipo.model.Mecanico;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;

public class ConsultarDisponibilidadController {
	@FXML
	private Label lblFecha;
	@FXML
	private Label lblEspecialidad;
	@FXML
	private Label lblMecanico;
	@FXML
	private ComboBox cboEspecialidad;
	@FXML
	private ComboBox<Mecanico> cboMecanico;
	@FXML
	private DatePicker picFecha;
	@FXML
	private ListView lstHorariosDisponibles;
	@FXML
	private Button btnSeleccionar;
	@FXML
	private Button btnCancelar;
	@FXML
	private Label lblHorariosDisponibles;

	@FXML
	public void initialize() {
		
		MecanicoDao mec = new MecanicoDao();
		ObservableList<Mecanico> list = mec.obtenerTodos();
		
		cboMecanico.getItems().clear();
		cboMecanico.setItems(list);
		cboMecanico.getSelectionModel().select(0);
	}
	
	// Event Listener on Button[#btnCancelar].onAction
	@FXML
	public void closeWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/MostrarTurnos.fxml"));
			
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
	        stage.setTitle("Turnos");
			stage.show();
			
			Stage myStage = (Stage) this.lblFecha.getScene().getWindow();
			myStage.close();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
