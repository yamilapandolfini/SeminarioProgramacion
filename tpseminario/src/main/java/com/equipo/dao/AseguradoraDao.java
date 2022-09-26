package com.equipo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.equipo.model.Aseguradora;
import com.equipo.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("deprecation")
public class AseguradoraDao implements Dao<Aseguradora>{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ObservableList<Aseguradora> obtenerTodos() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Aseguradora");
		ObservableList<Aseguradora> aseguradoraList = FXCollections.observableArrayList(query.list());
		tx.rollback();
		
		return aseguradoraList;
	}
	
	@Override
	public void insertar (Aseguradora a) {

			
	}
	
	@Override
	public void modificar (Aseguradora a) {
		
	}
	
	@Override
	public void eliminar (Aseguradora a) {
		
	}

}
