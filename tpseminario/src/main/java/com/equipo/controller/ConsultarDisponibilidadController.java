package com.equipo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.equipo.dao.MecanicoDao;
import com.equipo.dao.TurnoDao;
import com.equipo.model.Mecanico;
import com.equipo.model.Mecanico.Especialidad;

import javafx.collections.FXCollections;
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
	private ComboBox<Especialidad> cboEspecialidad;
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
	private Button btnVerificar;
	@FXML
	private Label lblHorariosDisponibles;
	@FXML
	private Label lblError;

	@FXML
	public void initialize() {
		
		cboEspecialidad.getItems().setAll(Mecanico.Especialidad.values());

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
	
	// Event Listener on Button[#btnVerificar].onAction
	@FXML
	public void verifyAvailability() {
		try {			
			LocalDate today = LocalDate.now();
			LocalDate fechaTurno = picFecha.getValue();
			if(fechaTurno==null||fechaTurno.isBefore(today)) {				
				lblError.setText("Fecha no válida");
				return;			
			}
			
			if(cboEspecialidad.getSelectionModel().getSelectedIndex() == -1) {
				lblError.setText("Debe seleccionar una especialidad");
				return;			
			}
			
			lblError.setText("");
			getHorarios(fechaTurno);
			
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);	
		}
	}	
	
    public void especialidadSelected(ActionEvent e)
    {        
        getMecanicos(cboEspecialidad.getSelectionModel().getSelectedIndex());
    }
    
    public void getMecanicos(Integer especialidad) {
		
    	MecanicoDao mec = new MecanicoDao();
		ObservableList<Mecanico> list = mec.obtenerTodosPorEspecialidad(especialidad);		
		
		cboMecanico.getItems().clear();
		cboMecanico.setItems(list);
		cboMecanico.getSelectionModel().select(0);
    }
    
    public void getHorarios(LocalDate fecha) {		

    	TurnoDao turno = new TurnoDao();
		ObservableList<Time> horariosOcupados = turno.obtenerHorariosPorFecha(fecha);		
		List<Time> listHorarios = new ArrayList<Time>();
		ObservableList<Time> horariosDisponibles = FXCollections.observableList(listHorarios);		
		
		for (int i = 8; i < 17; i++) {
			Time horario = Time.valueOf(LocalTime.of(i, 0));									
			if (!horariosOcupados.contains(horario)) {
				horariosDisponibles.add(horario);	
			}			
		}
		
		lstHorariosDisponibles.getItems().clear();
		lstHorariosDisponibles.setItems(horariosDisponibles);		
    }
	
}
