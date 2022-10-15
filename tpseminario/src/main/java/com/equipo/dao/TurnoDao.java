package com.equipo.dao;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.equipo.model.Cliente;
import com.equipo.model.Insumo;
import com.equipo.model.Turno;
import com.equipo.model.Vehiculo;
import com.equipo.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TurnoDao implements Dao<Turno>{

	@Override
	public void insertar(Turno o) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery(
	            "insert into Turno (cliente_id, vehiculo_id, mecanico_id, fecha, horario, estado) " +
                "values (:clienteid, :vehiculoid, :mecanicoid, :fecha, :horario, :estado)");        
        query.setParameter("clienteid", o.getCliente().getId());
        query.setParameter("vehiculoid", o.getVehiculo().getId());
        query.setParameter("mecanicoid", o.getMecanico().getId());
        query.setParameter("fecha", o.getFecha());
        query.setParameter("horario", o.getHorario());
        query.setParameter("estado", 0);		
		query.executeUpdate();        
		tx.commit();
	}

	@Override
	public void modificar(Turno o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Turno o) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ObservableList<Turno> obtenerTodos() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Turno");
		ObservableList<Turno> turnoList = FXCollections.observableArrayList(query.list());
		tx.rollback();
		
		return turnoList;
	}
	
	@SuppressWarnings("unchecked")	
	public ObservableList<Time> obtenerHorariosPorFecha(LocalDate fecha) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Date fechaConv = Date.valueOf(fecha);
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("SELECT horario FROM Turno WHERE fecha = :fecha");
		query.setParameter("fecha", fechaConv);
		ObservableList<Time> horarioList = FXCollections.observableArrayList(query.list());
		tx.rollback();
		
		return horarioList;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
    public Cliente obtenerCliente(Integer turnoId) {
       
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();

	    Query query = session.createSQLQuery("SELECT cliente_id FROM Turno WHERE id = :turnoId");
	    query.setParameter("turnoId", turnoId.toString());
	    Integer clienteId = (Integer) query.uniqueResult();
	    
        Query<Cliente> queryC = session.createQuery("FROM Cliente WHERE id = :clienteId");
	    queryC.setParameter("clienteId", clienteId);

	    Cliente cliente = queryC.uniqueResult();
	    
	    tx.rollback();
	    
	    return cliente;
	}
	
	   @SuppressWarnings({ "deprecation", "unchecked" })
	    public Vehiculo obtenerVehiculo(Integer turnoId) {
	       
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        Session session = sessionFactory.getCurrentSession();
	        Transaction tx = session.beginTransaction();

	        Query query = session.createSQLQuery("SELECT vehiculo_id FROM Turno WHERE id = :turnoId");
	        query.setParameter("turnoId", turnoId.toString());
	        Integer vehiculoId = (Integer) query.uniqueResult();
	        
	        Query<Vehiculo> queryV = session.createQuery("FROM Vehiculo WHERE id = :vehiculoId");
	        queryV.setParameter("vehiculoId", vehiculoId);
	        
	        Vehiculo ve = queryV.uniqueResult();
	       
	        tx.rollback();
	        
	        return ve;
	    }
	
}
