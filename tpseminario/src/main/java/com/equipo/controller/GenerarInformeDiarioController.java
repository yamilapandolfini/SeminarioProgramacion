package com.equipo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.equipo.dao.ServicioDao;
import com.equipo.model.Mecanico;
import com.equipo.model.Mecanico.Especialidad;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class GenerarInformeDiarioController {
	@FXML
	private DatePicker dpkFecha;
	@FXML
	private ComboBox<Especialidad> ddEspecialidad;
	@FXML
	private Button btnBuscar;
	@FXML
	private Button btnImprimirInforme;
	@FXML
	private TableView<List<StringProperty>> tblServicios;
	@FXML
	private TableColumn<List<StringProperty>, String> tblNroServicio;
	@FXML
	private TableColumn<List<StringProperty>, String> tblFecha;
	@FXML
	private TableColumn<List<StringProperty>, String> tblConforme;
	
	@FXML
	public void initialize() {
		
		ddEspecialidad.getItems().setAll(Mecanico.Especialidad.values());
		ddEspecialidad.getSelectionModel().select(0);
	    tblServicios.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		crearTableView();
	}
	
	@FXML
	public void slcBuscarFecha(ActionEvent event) {
		
		tblServicios.getItems().clear();
		
		if ( dpkFecha.getValue() != null ){
			
			ServicioDao servicio = new ServicioDao();
			LocalDate fecha = dpkFecha.getValue();
			Integer especialidad = ddEspecialidad.getSelectionModel().getSelectedIndex();
			List<Object[]> list = servicio.obtenerPorFechaEspecialidad(fecha,especialidad);
			ObservableList<List<StringProperty>> data = FXCollections.observableArrayList();
		    
		    int i;
			for ( i=0; i < list.size(); i++) {
			    List<StringProperty> row = new ArrayList<StringProperty>();
			    Object[] obj = list.get(i);
				row.add(0, new SimpleStringProperty(obj[0].toString()));
				row.add(1, new SimpleStringProperty(obj[1].toString()));
				row.add(2, new SimpleStringProperty(obj[2].toString()));
				row.add(3, new SimpleStringProperty(obj[3].toString()));
				row.add(4, new SimpleStringProperty(obj[4].toString()));
				data.add(row);
		    }
			
		    tblServicios.setItems(data);
		}	
	}
	
	@FXML
	private void crearTableView() {
		
		TableColumn<List<StringProperty>, String> tblNroServicio = new TableColumn<>("Nro Servicio");
	    TableColumn<List<StringProperty>, String> tblCliente = new TableColumn<>("Nombre Cliente");
	    TableColumn<List<StringProperty>, String> tblPatente = new TableColumn<>("Patente Vehículo");
	    TableColumn<List<StringProperty>, String> tblMecanico = new TableColumn<>("Nombre Mecánico");
	    TableColumn<List<StringProperty>, String> tblFecha = new TableColumn<>("Fecha");
	    
	    tblNroServicio.setCellValueFactory(cd -> cd.getValue().get(0));
	    tblCliente.setCellValueFactory(cd -> cd.getValue().get(1));
	    tblPatente.setCellValueFactory(cd -> cd.getValue().get(2));
	    tblMecanico.setCellValueFactory(cd -> cd.getValue().get(3));
	    tblFecha.setCellValueFactory(cd -> cd.getValue().get(4));
	    
	    tblServicios.getColumns().add(tblNroServicio);
	    tblServicios.getColumns().add(tblCliente);
	    tblServicios.getColumns().add(tblPatente);
	    tblServicios.getColumns().add(tblMecanico);
	    tblServicios.getColumns().add(tblFecha);
	    
	}
	
	@FXML
	public void clkImprimirInformeDiario(ActionEvent event) throws DocumentException, IOException {
	    Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("InformeDiario.pdf"));

        document.open();
        
        Paragraph space = new Paragraph(" ");
        document.add(space);
        
        //Header Informe
        Chunk hInforme = new Chunk("Informe Diario");
        document.add(hInforme);
        document.add(space);
        Chunk hFecha = new Chunk("Fecha : " + dpkFecha.getValue());
        document.add(hFecha);
        document.add(space);
        
        //Header Trabajos
        PdfPTable trabajos = new PdfPTable(5);
        PdfPCell trabajos_cell;
        trabajos_cell=new PdfPCell(new Phrase("Nro Servicio"));
        trabajos.addCell(trabajos_cell);
        trabajos_cell=new PdfPCell(new Phrase("Nombre Cliente"));
        trabajos.addCell(trabajos_cell);
        trabajos_cell=new PdfPCell(new Phrase("Patente Vehículo"));
        trabajos.addCell(trabajos_cell);
        trabajos_cell=new PdfPCell(new Phrase("Nombre Mecánico"));
        trabajos.addCell(trabajos_cell);
        trabajos_cell=new PdfPCell(new Phrase("Fecha"));
        trabajos.addCell(trabajos_cell);
      
        for (Object row : tblServicios.getItems()) {
            for (TableColumn column : tblServicios.getColumns()) {
                trabajos_cell=new PdfPCell(new Phrase(column.getCellObservableValue(row).getValue().toString()));
                trabajos.addCell(trabajos_cell);   
            }
          }
        
        document.add(trabajos);
        document.add(space);
        document.close();
    
        if (Desktop.isDesktopSupported()) {
                File ficha = new File("InformeDiario.pdf");
                Desktop.getDesktop().open(ficha);
        }
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
			
			Stage myStage = (Stage) this.dpkFecha.getScene().getWindow();
			myStage.close();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
