package com.equipo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.equipo.model.Servicio;
import com.equipo.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServicioDao implements Dao<Servicio> {

	@Override
	public void insertar(Servicio s) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(s);
		tx.commit();	
	}

	@Override
	public void modificar(Servicio s) {

		
	}

	public void modificarConformidad(Servicio s) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();	
		Transaction tx = session.beginTransaction();
		session.update(s);
		tx.commit();
	}
	
	@Override
	public void eliminar(Servicio s) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public ObservableList<Servicio> obtenerTodos() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();	
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Servicio");
		ObservableList<Servicio> servicioList = FXCollections.observableArrayList(query.list());
		tx.rollback();
		
		return servicioList;
	}

	public Servicio obtenerUno(Integer id){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();	
		Transaction tx = session.beginTransaction();
		Servicio servicio = new Servicio();
		servicio = (Servicio) session.get(Servicio.class, id);
		tx.rollback();
		
		return servicio;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Object[]> obtenerPorFechaEspecialidad(LocalDate fecha, Integer especialidad) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();	
		Transaction tx = session.beginTransaction();
		
		Query query = session.createSQLQuery("SELECT s.id as id, c.APELLIDO as cliente, v.PATENTE as patente, m.APELLIDO as mecanico, t.fecha as fecha "
				+ "FROM servicio s, turno t, mecanico m, cliente c, vehiculo v "
				+ "WHERE s.TURNO_ID=t.ID and t.MECANICO_ID=m.ID and t.CLIENTE_ID=c.ID and t.VEHICULO_ID=v.ID "
				+ "and t.fecha = :fecha " 
				+ "and m.especialidad = :especialidad ");
		query.setParameter("fecha", fecha);
		query.setParameter("especialidad", especialidad);
		
		List<Object[]> rows = query.list();
		
		tx.commit();
		
		return rows;
	}

}
