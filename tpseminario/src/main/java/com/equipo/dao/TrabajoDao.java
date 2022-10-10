package com.equipo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.equipo.model.Trabajo;
import com.equipo.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TrabajoDao implements Dao<Trabajo> {

	@Override
	public void insertar(Trabajo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Trabajo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Trabajo t) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ObservableList<Trabajo> obtenerTodos() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Trabajo");
		ObservableList<Trabajo> servList = FXCollections.observableArrayList(query.list());
		tx.rollback();
		
		return servList;
	}

}
