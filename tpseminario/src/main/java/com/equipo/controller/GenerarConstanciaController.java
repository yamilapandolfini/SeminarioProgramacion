package com.equipo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
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

import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

import javafx.scene.control.RadioButton;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class GenerarConstanciaController {
	@FXML
	private TextField txtServicio;
	@FXML
	private Button btnGenerar;
	@FXML
	private Button btnCancelar;
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
	private TableView<Trabajo> tblServicios;
	@FXML
	private TableColumn<Trabajo, String> tblServicio;
	@FXML
	private TableColumn<Trabajo, String> tblDescripcion;
	@FXML
	private RadioButton rbConforme;
	@FXML
	private ToggleGroup conformidad;
	@FXML
	private RadioButton rbNoConforme;
	@FXML
	private TextArea txaDisconformidad;
	@FXML
	private Label lblDisconformidad;

	private Servicio servicio;

	@FXML
	public void init(Servicio s) {
		
		this.servicio = s;
		txtServicio.setText(s.getId().toString());
		cargarInsumos();
		cargarServicios();
		if (s.getConforme() == true) {
			lblDisconformidad.setVisible(false);
			txaDisconformidad.setVisible(false);
			rbConforme.setSelected(true);
		}
		else {
			lblDisconformidad.setVisible(true);
			txaDisconformidad.setVisible(true);
			rbNoConforme.setSelected(true);
			txaDisconformidad.setText(s.getComentarios());
		}
		
	}
	
	private void cargarInsumos() {
		ObservableList<Insumo> listInsumos = FXCollections.observableArrayList(this.servicio.getInsumos());
        tblNombre.setCellValueFactory(new PropertyValueFactory<Insumo, String>("nombre"));
        tblMarca.setCellValueFactory(new PropertyValueFactory<Insumo, String>("marca"));
        tblModelo.setCellValueFactory(new PropertyValueFactory<Insumo, String>("modelo"));
        tblNumeroParte.setCellValueFactory(new PropertyValueFactory<Insumo, Integer>("numeroParte"));
        tblInsumos.setItems(listInsumos);
	}
	
	private void cargarServicios() {
        ObservableList<Trabajo> listTrabajos = FXCollections.observableArrayList(this.servicio.getTrabajos());
        tblServicio.setCellValueFactory(new PropertyValueFactory<Trabajo, String>("trabajo"));
        tblDescripcion.setCellValueFactory(new PropertyValueFactory<Trabajo, String>("descripcion"));
        tblServicios.setItems(listTrabajos);
	}
	
	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio s) {
		this.servicio = s;
	}

	@FXML
	public void clkGenerarConformidad(ActionEvent event) {
		
		if ( rbConforme.isSelected() ) {
			servicio.setConforme(true);
			servicio.setComentarios("");
		}
		else {
			servicio.setConforme(false);
			servicio.setComentarios(txaDisconformidad.getText());
		}
		
		ServicioDao servicioDAO = new ServicioDao();
		servicioDAO.modificarConformidad(servicio);
		
		closeWindow();
	}

	@FXML
	public void closeWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/MostrarServicio.fxml"));
			
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
	        stage.setTitle("Servicios");
			stage.show();
			
			Stage myStage = (Stage) this.txtServicio.getScene().getWindow();
			myStage.close();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	public void slcConforme(ActionEvent event) {
		lblDisconformidad.setVisible(false);
		txaDisconformidad.setVisible(false);	
	}

	@FXML
	public void slcNoConforme(ActionEvent event) {
		lblDisconformidad.setVisible(true);
		txaDisconformidad.setVisible(true);	
	}

}
