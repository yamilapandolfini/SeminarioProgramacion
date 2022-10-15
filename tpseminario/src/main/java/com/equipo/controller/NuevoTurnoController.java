package com.equipo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.equipo.dao.AseguradoraDao;
import com.equipo.dao.ClienteDao;
import com.equipo.dao.MecanicoDao;
import com.equipo.dao.TurnoDao;
import com.equipo.dao.VehiculoDao;
import com.equipo.model.Aseguradora;
import com.equipo.model.Cliente;
import com.equipo.model.Cliente.TipoDocumento;
import com.equipo.model.Mecanico;
import com.equipo.model.Mecanico.Especialidad;
import com.equipo.model.Turno;
import com.equipo.model.Vehiculo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class NuevoTurnoController {
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
	private Button btnGenerarFicha;
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
	@FXML
	private Button btnConsultarDisponibilidad;	
	@FXML
	private Label lblError;
	
	
	// Controles Consultar Disponibilidad
	@FXML
	private Pane panConsultarDisponibilidad;
	@FXML
	private Label lblBCFecha;
	@FXML
	private Label lblBCEspecialidad;
	@FXML
	private Label lblBCMecanico;
	@FXML
	private ComboBox<Especialidad> cboBCEspecialidad;
	@FXML
	private ComboBox<Mecanico> cboBCMecanico;
	@FXML
	private DatePicker picBCFecha;
	@FXML
	private ListView lstBCHorariosDisponibles;
	@FXML
	private Button btnBCSeleccionar;
	@FXML
	private Button btnBCCerrar;
	@FXML
	private Button btnBCVerificar;
	@FXML
	private Label lblBCHorariosDisponibles;
	@FXML
	private Label lblBCError;
	
	// Controles Consultar Disponibilidad
	@FXML
	private Pane panBuscarCliente;
	@FXML
	private Label lblCLTipoDocumento;
	@FXML
	private Label lblCLNroDocumento;
	@FXML
	private Label lblCLNombre;
	@FXML
	private Label lblCLApellido;
	@FXML
	private Label lblCLTelefono;
	@FXML
	private Label lblCLError;	
	@FXML
	private ComboBox<TipoDocumento> cboCLTipoDocumento;
	@FXML
	private TextField txtCLNroDocumento;
	@FXML
	private TextField txtCLNombre;
	@FXML
	private TextField txtCLApellido;
	@FXML
	private TextField txtCLTelefono;
	@FXML
	private Button btnCLBuscar;
	@FXML
	private Button btnCLCerrar;
	@FXML
	private Button btnCLConfirmar;
	@FXML
	private Button btnCLNuevo;
	
	// Controles Buscar Vehiculo
	
	@FXML
	private Pane panBuscarVehiculo;
	@FXML
	private Label lblBVPatente;
	@FXML
	private Label lblBVMarca;
	@FXML
	private Label lblBVModelo;
	@FXML	
	private Label lblBVAnoFabricacion;
	@FXML
	private Label lblBVNroPoliza;
	@FXML
	private Label lblBVAseguradora;
	@FXML
	private Label lblBVError;
	@FXML
	private ComboBox<Vehiculo> cboBVPatente;
	@FXML
	private TextField txtBVMarca;
	@FXML
	private TextField txtBVModelo;
	@FXML
	private TextField txtBVAnoFabricacion;
	@FXML
	private TextField txtBVNroPoliza;
	@FXML
	private ComboBox<Aseguradora> cboBVAseguradora;	
	@FXML
	private Button btnBVNuevo;
	@FXML
	private Button btnBVConfirmar;
	@FXML
	private Button btnBVCerrar;
	
	private Boolean boolNuevoCliente;
	
	private Boolean boolNuevoVehiculo;
	
	private Cliente clienteTurno = new Cliente();
	
	private Vehiculo vehiculoTurno = new Vehiculo();
	
	private Turno nuevoTurno = new Turno();
	
	@FXML
	public void initialize() {
		
		TurnoDao turno = new TurnoDao();
		ObservableList<Turno> list = turno.obtenerTodos();
		Turno ultimoTurno = list.get(list.size() - 1);
		int ultimoTurnoID = ultimoTurno.getId();
		txtNroTurno.setText(Integer.toString(ultimoTurnoID));
		txtNroTurno.setEditable(false);
		lblError.setText("");
		
		// Oculto todos los paneles
		
		panConsultarDisponibilidad.setVisible(false);
		panBuscarCliente.setVisible(false);
		panBuscarVehiculo.setVisible(false);
		
		// Inicializo Consultar Disponibilidad
		
		cboBCEspecialidad.getItems().setAll(Mecanico.Especialidad.values());
		lblBCError.setText("");

		// Inicializo Buscar Cliente
		
		cboCLTipoDocumento.getItems().setAll(Cliente.TipoDocumento.values());
		cboCLTipoDocumento.getSelectionModel().select(0);		
		boolNuevoCliente = false;
		lblCLError.setText("");
		
		// Inicializo Buscar Vehiculo
		cboBVPatente.getItems().clear();
		txtBVMarca.setText(null);
		txtBVModelo.setText(null);
		txtBVAnoFabricacion.setText(null);
		txtBVNroPoliza.setText(null);
		getAseguradoras();
		lblBVError.setText("");		
	}
	
	// Método de Consultar Disponibilidad
	// Event Listener on Button[#btnBCVerificar].onAction
	@FXML
	public void verifyAvailability() {
		try {			
			LocalDate today = LocalDate.now();
			LocalDate fechaTurno = picBCFecha.getValue();
			if(fechaTurno==null||fechaTurno.isBefore(today)) {				
				lblBCError.setText("Fecha no válida");
				return;			
			}
			
			if(cboBCEspecialidad.getSelectionModel().getSelectedIndex() == -1) {
				lblBCError.setText("Debe seleccionar una especialidad");
				return;			
			}
			
			lblBCError.setText("");
			getHorarios(fechaTurno);
			
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);	
		}
	}

	// Método de Consultar Disponibilidad
	// Event Listener on Button[#btnBCSeleccionar].onAction
	@FXML
	public void seleccionarDisponibilidad(ActionEvent e) {
		try {			
			Time horarioSeleccionado = Time.valueOf(lstBCHorariosDisponibles.getSelectionModel().getSelectedItem().toString());
			LocalDate fechaSeleccionada = picBCFecha.getValue(); 
			Mecanico mecanicoSeleccionado = cboBCMecanico.getSelectionModel().getSelectedItem();
			Especialidad especialidadSeleccionada = cboBCEspecialidad.getSelectionModel().getSelectedItem();
				
			setDisponibilidad(fechaSeleccionada, horarioSeleccionado, mecanicoSeleccionado, especialidadSeleccionada);
			panConsultarDisponibilidad.setVisible(false);			
			
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);	
		}
	}	

	// Método de Consultar Disponibilidad
    public void especialidadSelected(ActionEvent e)
    {        
        getMecanicos(cboBCEspecialidad.getSelectionModel().getSelectedIndex());
    }

	// Método de Consultar Disponibilidad
    public void getMecanicos(Integer especialidad) {
		
    	MecanicoDao mec = new MecanicoDao();
		ObservableList<Mecanico> list = mec.obtenerTodosPorEspecialidad(especialidad);		
		
		cboBCMecanico.getItems().clear();
		cboBCMecanico.setItems(list);
		cboBCMecanico.getSelectionModel().select(0);
    }

	// Método de Consultar Disponibilidad
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
		
		lstBCHorariosDisponibles.getItems().clear();
		lstBCHorariosDisponibles.setItems(horariosDisponibles);		
    }

	// Método de Consultar Disponibilidad
	// Event Listener on Button[#btnBCCerrar].onAction
	@FXML
	public void closeBCPane() {
		try {
			panConsultarDisponibilidad.setVisible(false);
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}	
	
	// Método de Buscar Cliente
	// Event Listener on Button[#btnCLBuscar].onAction
	@FXML
	public void clkCLBuscar(ActionEvent e) {
		try {			
			Integer nroDocumento = Integer.parseInt(txtCLNroDocumento.getText());
			Integer tipoDocumento = cboCLTipoDocumento.getSelectionModel().getSelectedIndex();					
					
			getCliente(tipoDocumento, nroDocumento);
			
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);	
		}
	}
	
	// Método de Buscar Cliente
	// Event Listener on Button[#btnCLNuevo].onAction	
	@FXML
	public void clkCLNuevo(ActionEvent e) {
		try {			
			
			boolNuevoCliente = true;
			txtCLNombre.setText(null);
			txtCLApellido.setText(null);
			txtCLTelefono.setText(null);
			txtCLNombre.setDisable(false);
			txtCLApellido.setDisable(false);
			txtCLTelefono.setDisable(false);
			
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);	
		}
	}
	
	// Método de Buscar Cliente
	@FXML
	public void clkCLConfirmar(ActionEvent e) {
		try {			
			
			if(txtCLNombre.getText().isBlank() || txtCLApellido.getText().isBlank() || txtCLTelefono.getText().isBlank()) {
				lblCLError.setText("Por favor complete todos los campos");
				return;
			}
			
			if (boolNuevoCliente == true) {
				ClienteDao clienteDao = new ClienteDao();				
				clienteTurno.setApellido(txtCLApellido.getText());
				clienteTurno.setNombre(txtCLNombre.getText());
				clienteTurno.setTelefono(Integer.parseInt(txtCLTelefono.getText()));
				clienteTurno.setDocumento(Integer.parseInt(txtCLNroDocumento.getText()));
				clienteTurno.setTipoDocumento(cboCLTipoDocumento.getValue().ordinal());				
				int clienteID = clienteDao.insertarRetID(clienteTurno);				
				clienteTurno.setId(clienteID);
			}			
			
			if (clienteTurno == null) {
				lblCLError.setText("No se ha seleccionado ningún cliente");
			} else {					
				setCliente(clienteTurno);			
				panBuscarCliente.setVisible(false);
			}
			
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);	
		}
	}
	
	// Método de Buscar Cliente
    public void getCliente(Integer tipoDocumento, Integer nroDocumento) {		

    	ClienteDao clienteDao = new ClienteDao();    	
		clienteTurno = clienteDao.obtenerClientePorDocumento(tipoDocumento, nroDocumento);		
		lblCLError.setText("");
		
		if(clienteTurno==null) {
			lblCLError.setText("Cliente no encontrado");
			return;
		}
				
		txtCLNombre.setText(clienteTurno.getNombre());
		txtCLApellido.setText(clienteTurno.getApellido());
		txtCLTelefono.setText(clienteTurno.getTelefono().toString());		
    }
	
	// Método de Buscar Cliente
	// Event Listener on Button[#btnCLCerrar].onAction
	@FXML
	public void closeCLPane() {
		try {
			panBuscarCliente.setVisible(false);
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}    
	
	// Método de Buscar Vehiculo
	// Event Listener on Button[#btnBVCerrar].onAction
	@FXML
	public void closeBVPane() {
		try {
			panBuscarVehiculo.setVisible(false);
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	// Método de BuscarVehiculo
    public void getAseguradoras() {
		
    	AseguradoraDao dao = new AseguradoraDao();
		ObservableList<Aseguradora> list = dao.obtenerTodos();		
		
		cboBVAseguradora.getItems().clear();
		cboBVAseguradora.setItems(list);		
    }
	
	// Método de Buscar Vehiculo
    public void getVehiculo(Cliente cliente) {		

    	VehiculoDao vehiculoDao = new VehiculoDao();    	
		ObservableList<Vehiculo> listaVehiculos = vehiculoDao.obtenerVehiculoPorCliente(cliente.getId());
    			
		lblBVError.setText("");
		
		if(listaVehiculos==null) {
			lblBVError.setText("No hay vehiculos registrados");
			return;
		}
		
		cboBVPatente.getItems().clear();
		cboBVPatente.setItems(listaVehiculos);
		cboBVPatente.getSelectionModel().select(0);
    }

	// Método de Buscar Vehiculo
	// Event Listener on Button[#btnBVNuevo].onAction	
	@FXML
	public void clkBVNuevo(ActionEvent e) {
		try {			
			
			boolNuevoVehiculo = true;
			
			cboBVPatente.setValue(null);
			txtBVMarca.setText(null);
			txtBVModelo.setText(null);
			txtBVAnoFabricacion.setText(null);
			txtBVNroPoliza.setText(null);
			cboBVAseguradora.setValue(null);
			
			txtBVMarca.setDisable(false);
			txtBVModelo.setDisable(false);
			txtBVAnoFabricacion.setDisable(false);
			txtBVNroPoliza.setDisable(false);
			cboBVAseguradora.setDisable(false);
			
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);	
		}
	}
	
	// Método de Buscar Vehiculo	
    public void selectVehiculo(ActionEvent e) {
		
		if(boolNuevoVehiculo==false) {
			vehiculoTurno = cboBVPatente.getSelectionModel().getSelectedItem();
			txtBVMarca.setText(vehiculoTurno.getMarca());
			txtBVModelo.setText(vehiculoTurno.getModelo());
			txtBVAnoFabricacion.setText(String.valueOf(vehiculoTurno.getAnoFabricacion()));
			txtBVNroPoliza.setText(vehiculoTurno.getNumeroPoliza());
			cboBVAseguradora.getSelectionModel().select(vehiculoTurno.getAseguradora());	
		}    	
    }
    
	// Método de Buscar Vehiculo
	@FXML
	public void clkBVConfirmar(ActionEvent e) {
		try {			
			
			String aseguradora = "";
			
			if(txtBVMarca.getText() == null|| txtBVModelo.getText()== null|| txtBVAnoFabricacion.getText()== null || txtBVNroPoliza.getText()== null || cboBVAseguradora.getValue() == null || cboBVPatente.getValue() == null) {
				lblBVError.setText("Por favor complete todos los campos");
				return;
			}
			
			if (boolNuevoVehiculo == true) {
				VehiculoDao vehiculoDao = new VehiculoDao();				
				vehiculoTurno.setPatente(cboBVPatente.getEditor().getText());
				vehiculoTurno.setMarca(txtBVMarca.getText());
				vehiculoTurno.setModelo(txtBVModelo.getText());
				vehiculoTurno.setAnoFabricacion(Integer.parseInt(txtBVAnoFabricacion.getText()));
				vehiculoTurno.setNumeroPoliza(txtBVNroPoliza.getText());
				vehiculoTurno.setAseguradora(cboBVAseguradora.getSelectionModel().getSelectedIndex());				
				int vehiculoID = vehiculoDao.insertarRetID(vehiculoTurno);				
				vehiculoTurno.setId(vehiculoID);
			}			
			
			if (vehiculoTurno == null) {
				lblBVError.setText("No se ha seleccionado ningún vehiculo");
			} else {					
				setVehiculo(vehiculoTurno, cboBVAseguradora.getSelectionModel().getSelectedItem().getNombre());			
				panBuscarVehiculo.setVisible(false);
			}
			
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);	
		}
	}
    
	// Event Listener on Button[#btnGenerarFicha].onAction
	@FXML
	public void clkGenerarFicha(ActionEvent event) throws IOException {
		try {
			guardarTurno(nuevoTurno);
			
			Cliente nuevoCliente = new Cliente();
						
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ImprimirFicha.fxml"));
			
			Parent root = loader.load();
			
			ImprimirFichaController controlador = loader.getController();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			
			stage.setScene(scene);
			stage.setTitle("Imprimir ficha");
			stage.show();
			
			stage.setOnCloseRequest(e -> controlador.closeWindow());
			
			Stage myStage = (Stage) this.lblNroTurno.getScene().getWindow();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
		
	@FXML
	public void clkConsultarDisponibilidad(ActionEvent event) {
		try {		
			
			panBuscarVehiculo.setVisible(false);
			panBuscarCliente.setVisible(false);
			panConsultarDisponibilidad.setVisible(true);
			picBCFecha.setValue(null);
			lstBCHorariosDisponibles.getItems().clear();			
		
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		} 
	}	
	
	@FXML
	public void clkBuscarCliente(ActionEvent event) {
		try {
			panBuscarVehiculo.setVisible(false);
			panBuscarCliente.setVisible(true);
			panConsultarDisponibilidad.setVisible(false);
			boolNuevoCliente = false;
			txtCLNroDocumento.setText(null);
			txtCLNombre.setText(null);
			txtCLApellido.setText(null);
			txtCLTelefono.setText(null);			
			txtCLNombre.setDisable(true);
			txtCLApellido.setDisable(true);
			txtCLTelefono.setDisable(true);
			
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	@FXML
	public void clkBuscarVehiculo(ActionEvent event) {
		try {
			panBuscarVehiculo.setVisible(true);
			panBuscarCliente.setVisible(false);
			panConsultarDisponibilidad.setVisible(false);
			boolNuevoVehiculo = false;
			txtBVMarca.setDisable(true);
			txtBVModelo.setDisable(true);
			txtBVAnoFabricacion.setDisable(true);
			txtBVNroPoliza.setDisable(true);
			cboBVAseguradora.setDisable(true);
			btnBVNuevo.setDisable(false);
			
			if (nuevoTurno.getCliente()==null) {
				lblBVError.setText("No hay ningún cliente seleccionado");
				btnBVNuevo.setDisable(true);
				return;
			}
			
			getVehiculo(nuevoTurno.getCliente());

		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
			
			Stage myStage = (Stage) this.lblNroTurno.getScene().getWindow();
			myStage.close();
			
			myStage.close();
		} catch (IOException ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void setDisponibilidad(LocalDate fecha, Time horario, Mecanico mecanico, Especialidad especialidad) {
		nuevoTurno.setFecha(Date.valueOf(fecha));
		txtFecha.setText(fecha.toString());
		nuevoTurno.setHorario(horario);
		txtHorario.setText(horario.toString());
		nuevoTurno.setMecanico(mecanico);		
		txtMecanico.setText(mecanico.getApellido() + " " + mecanico.getNombre());
		txtEspecialidad.setText(especialidad.toString());		
	}
	
	public void setCliente(Cliente cliente) {
		nuevoTurno.setCliente(cliente);
		TipoDocumento[] listaTipoDocumento = Cliente.TipoDocumento.values();		
		txtTipoDocumento.setText(listaTipoDocumento[cliente.getTipoDocumento()].toString());				
		txtNumeroDocumento.setText(Integer.toString(cliente.getDocumento()));
		txtApellido.setText(cliente.getApellido()); 
		txtNombre.setText(cliente.getNombre());				
	}
	
	public void setVehiculo(Vehiculo vehiculo, String aseguradora) {
		nuevoTurno.setVehiculo(vehiculo);				
		txtPatente.setText(vehiculo.getPatente());
		txtMarca.setText(vehiculo.getMarca());
		txtModelo.setText(vehiculo.getModelo());
		txtNumeroPoliza.setText(vehiculo.getNumeroPoliza());
		txtEmpresaAseguradora.setText(aseguradora);		
	}
	
	public void guardarTurno(Turno turno) {
		try {
			
			if(txtFecha.getText() == null|| txtNumeroDocumento.getText()== null|| txtPatente.getText()== null) {
				lblError.setText("Por favor complete todos los campos");
				return;
			}
						
			TurnoDao turnoDao = new TurnoDao();				
			turnoDao.insertar(nuevoTurno);			
			
		} catch (Exception ex) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);	
		}
	}
	
}
