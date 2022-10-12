package com.equipo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.equipo.model.Insumo;
import com.equipo.model.Turno;
import com.equipo.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TurnoDao implements Dao<Turno>{

	@Override
	public void insertar(Turno o) {
		// TODO Auto-generated method stub
		
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
	
}
