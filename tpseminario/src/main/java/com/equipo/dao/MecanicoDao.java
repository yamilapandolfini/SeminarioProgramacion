package com.equipo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.equipo.model.Mecanico;
import com.equipo.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("deprecation")
public class MecanicoDao implements Dao<Mecanico>{
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ObservableList<Mecanico> obtenerTodos() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Mecanico");
		ObservableList<Mecanico> mecanicoList = FXCollections.observableArrayList(query.list());
		tx.rollback();
		
		return mecanicoList;
	}
	
	public ObservableList<Mecanico> obtenerTodosPorEspecialidad(Integer especialidad) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("FROM Mecanico WHERE Especialidad = :especialidad");
		query.setParameter("especialidad", especialidad);
		
		ObservableList<Mecanico> mecanicoList = FXCollections.observableArrayList(query.list());
		tx.rollback();
		
		return mecanicoList;
	}

	@Override
	public void insertar(Mecanico o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Mecanico o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Mecanico o) {
		// TODO Auto-generated method stub
		
	}

}
