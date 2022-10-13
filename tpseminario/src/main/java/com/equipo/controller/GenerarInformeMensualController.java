package com.equipo.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.equipo.dao.AseguradoraDao;
import com.equipo.dao.ServicioDao;
import com.equipo.model.Aseguradora;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class GenerarInformeMensualController {
	@FXML
	private Label lblMes;
	@FXML
	private Label lblEmpresaAseguradora;
	@FXML
	private ComboBox<String> cboMes;
	@FXML
	private ComboBox<Aseguradora> cboEmpresaAseguradora;
	@FXML
	private Button btnGenerarInforme;
	@FXML
	private Button btnImprimirInforme;
    @FXML
    private TableView<List<StringProperty>> tblServicios;
    @FXML
    private TableColumn<List<StringProperty>, String> tblNroServicio;
    @FXML
    private TableColumn<List<StringProperty>, String> tblCliente;
    @FXML
    private TableColumn<List<StringProperty>, String> tblMarca;
    @FXML
    private TableColumn<List<StringProperty>, String> tblModelo;
    @FXML
    private TableColumn<List<StringProperty>, String> tblPatente;
    @FXML
    private TableColumn<List<StringProperty>, String> tblPoliza;
    
    
	@FXML
	public void initialize() {
	    
	    cargarAseguradoras();
	    cargarMeses();
	    tblServicios.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	    crearTableView();
	}
	
	private void cargarAseguradoras() {
	    AseguradoraDao ase = new AseguradoraDao();
	    ObservableList<Aseguradora> list = ase.obtenerTodos();
	    cboEmpresaAseguradora.getItems().clear();
	    cboEmpresaAseguradora.setItems(list);
	    cboEmpresaAseguradora.getSelectionModel().select(0);   
	}
	
	private void cargarMeses() {
	    ObservableList<String> list = FXCollections.observableArrayList();
	    list.add("Enero");
	    list.add("Febrero");
	    list.add("Marzo");
	    list.add("Abril");
	    list.add("Mayo");
	    list.add("Junio");
	    list.add("Julio");
	    list.add("Agosto");
	    list.add("Septiembre");
	    list.add("Octubre");
	    list.add("Noviembre");
	    list.add("Diciembre");
	    cboMes.setItems(list);
	    cboMes.getSelectionModel().select(0);
	}
	
    @FXML
    private void crearTableView() {
        
        TableColumn<List<StringProperty>, String> tblNroServicio = new TableColumn<>("Nro Servicio");
        TableColumn<List<StringProperty>, String> tblCliente = new TableColumn<>("Cliente");
        TableColumn<List<StringProperty>, String> tblMarca = new TableColumn<>("Marca");
        TableColumn<List<StringProperty>, String> tblModelo = new TableColumn<>("Modelo");
        TableColumn<List<StringProperty>, String> tblPatente = new TableColumn<>("Patente");
        TableColumn<List<StringProperty>, String> tblPoliza = new TableColumn<>("Poliza");
        
        tblNroServicio.setCellValueFactory(cd -> cd.getValue().get(0));
        tblCliente.setCellValueFactory(cd -> cd.getValue().get(1));
        tblMarca.setCellValueFactory(cd -> cd.getValue().get(2));
        tblModelo.setCellValueFactory(cd -> cd.getValue().get(3));
        tblPatente.setCellValueFactory(cd -> cd.getValue().get(4));
        tblPoliza.setCellValueFactory(cd -> cd.getValue().get(5));
        
        tblServicios.getColumns().add(tblNroServicio);
        tblServicios.getColumns().add(tblCliente);
        tblServicios.getColumns().add(tblMarca);
        tblServicios.getColumns().add(tblModelo);
        tblServicios.getColumns().add(tblPatente);
        tblServicios.getColumns().add(tblPoliza);
        
    }
    
	@FXML
	public void btnImprimir(ActionEvent event) throws DocumentException, IOException {
	    Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("InformeDiario.pdf"));

        document.open();
        
        Paragraph space = new Paragraph(" ");
        document.add(space);
        
        //Header Informe
        Chunk hInforme = new Chunk("Informe Mensual");
        document.add(hInforme);
        document.add(space);
        Chunk hAseguradora = new Chunk("Aseguradora : " + cboEmpresaAseguradora.getSelectionModel().getSelectedItem());
        document.add(hAseguradora);
        document.add(space);
        Chunk hFecha = new Chunk("Mes : " + cboMes.getSelectionModel().getSelectedItem());
        document.add(hFecha);
        document.add(space);
        
        //Header Trabajos
        PdfPTable trabajos = new PdfPTable(6);
        PdfPCell trabajos_cell;
        trabajos_cell=new PdfPCell(new Phrase("Nro Servicio"));
        trabajos.addCell(trabajos_cell);
        trabajos_cell=new PdfPCell(new Phrase("Cliente"));
        trabajos.addCell(trabajos_cell);
        trabajos_cell=new PdfPCell(new Phrase("Marca"));
        trabajos.addCell(trabajos_cell);
        trabajos_cell=new PdfPCell(new Phrase("Modelo"));
        trabajos.addCell(trabajos_cell);
        trabajos_cell=new PdfPCell(new Phrase("Patente"));
        trabajos.addCell(trabajos_cell);
        trabajos_cell=new PdfPCell(new Phrase("Poliza"));
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

	public void btnGenerarInforme(ActionEvent event) {
        
	    tblServicios.getItems().clear();
            
        ServicioDao servicio = new ServicioDao();
        Integer mes = cboMes.getSelectionModel().getSelectedIndex() + 1;
        Integer aseguradora = cboEmpresaAseguradora.getSelectionModel().getSelectedIndex();
                
        List<Object[]> list = servicio.obtenerPorMesAseguradora(mes,aseguradora);
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
            row.add(5, new SimpleStringProperty(obj[5].toString()));
            data.add(row);
        }
            
        tblServicios.setItems(data);
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
			
			Stage myStage = (Stage) this.lblMes.getScene().getWindow();
			myStage.close();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
