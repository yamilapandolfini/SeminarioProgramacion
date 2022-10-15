package com.equipo.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;

import com.equipo.model.Vehiculo;
import com.equipo.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("deprecation")
public class VehiculoDao implements Dao<Vehiculo>{
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ObservableList<Vehiculo> obtenerTodos() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Vehiculo");
		ObservableList<Vehiculo> vehiculoList = FXCollections.observableArrayList(query.list());
		tx.rollback();
		
		return vehiculoList;
	}
	
	public ObservableList<Vehiculo> obtenerVehiculoPorCliente(Integer clienteid) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("FROM Vehiculo WHERE cliente_id = :clienteid ");
		query.setParameter("clienteid", clienteid);	
		ObservableList<Vehiculo> vehiculoList = FXCollections.observableArrayList(query.list());		
		tx.rollback();
		
		return vehiculoList;
	}

	@Override
	public void insertar(Vehiculo o) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(o);
		tx.commit();		
	}

	public int insertarRetID(Vehiculo o) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		int vehiculoid = (Integer)session.save(o);
		tx.commit();
		return vehiculoid;
	}
	
	@Override
	public void modificar(Vehiculo o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Vehiculo o) {
		// TODO Auto-generated method stub
		
	}

}
