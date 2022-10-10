package com.equipo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
	public void modificar(Servicio o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Servicio o) {
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

}
