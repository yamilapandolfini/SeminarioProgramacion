package com.equipo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.equipo.model.Servicios;
import com.equipo.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServiciosDao implements Dao<Servicios> {

	@Override
	public void insertar(Servicios o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Servicios o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Servicios o) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ObservableList<Servicios> obtenerTodos() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Servicios");
		ObservableList<Servicios> servList = FXCollections.observableArrayList(query.list());
		tx.rollback();
		
		return servList;
	}

}
