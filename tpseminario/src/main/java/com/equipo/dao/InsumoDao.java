package com.equipo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.equipo.model.Insumo;
import com.equipo.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InsumoDao implements Dao<Insumo>{

	@Override
	public void insertar(Insumo o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Insumo o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Insumo o) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public ObservableList<Insumo> obtenerTodos() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Insumo");
		ObservableList<Insumo> insumoList = FXCollections.observableArrayList(query.list());
		tx.rollback();
		
		return insumoList;
	}


}
