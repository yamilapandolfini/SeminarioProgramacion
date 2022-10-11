package com.equipo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.equipo.model.Servicio;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class ImprimirFichaController {
	@FXML
	private TextField txtServicio;
	@FXML
	private TextArea tblServicios;
	@FXML
	private TextArea tblInsumos;
	@FXML
	private Button btnImprimirFicha;
	
	private Servicio servicio;
	
	@FXML
	public void setServicio(Servicio s) {
		this.servicio = s;
		txtServicio.setText(s.getId().toString());
	}

	public Servicio getServicio(Servicio s) {
		return servicio;
	}

	@FXML
	public void clkImprimirFicha(ActionEvent event) throws IOException, DocumentException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("FichaMecanica.pdf"));

		document.open();
		
		//Header Servicio
		Chunk chunk = new Chunk("Servicio: " + servicio.getId());
		document.add(chunk);
		Paragraph space = new Paragraph(" ");
		document.add(space);
		
		//Header Trabajos
		PdfPTable trabajos = new PdfPTable(2);
		PdfPCell trabajos_cell;
        trabajos_cell=new PdfPCell(new Phrase("Trabajo"));
		trabajos.addCell(trabajos_cell);
        trabajos_cell=new PdfPCell(new Phrase("Descripción"));
		trabajos.addCell(trabajos_cell);
		//Rows Trabajos
		   for(int aw=0;aw<16 ; aw++){
			   trabajos.addCell(" ");
		    }
		
		document.add(trabajos);
		
		document.add(space);
		//Header Insumo
		PdfPTable insumos = new PdfPTable(4);
		PdfPCell insumos_cell;
		insumos_cell=new PdfPCell(new Phrase("Nombre"));
		insumos.addCell(insumos_cell);
		insumos_cell=new PdfPCell(new Phrase("Marca"));
		insumos.addCell(insumos_cell);
		insumos_cell=new PdfPCell(new Phrase("Modelo"));
		insumos.addCell(insumos_cell);
		insumos_cell=new PdfPCell(new Phrase("Nro. de Parte"));
		insumos.addCell(insumos_cell);
		//Rows Insumos
		   for(int aw=0;aw<32 ; aw++){
			   insumos.addCell(" ");
		    }
		
		document.add(insumos);
		document.close();
	
		if (Desktop.isDesktopSupported()) {
		        File ficha = new File("FichaMecanica.pdf");
		        Desktop.getDesktop().open(ficha);
		}

	}
	
	public void closeWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/MostrarServicio.fxml"));
			
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
	        stage.setTitle("Servicios");
			stage.show();
			
			Stage myStage = (Stage) this.tblServicios.getScene().getWindow();
			myStage.close();

			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
