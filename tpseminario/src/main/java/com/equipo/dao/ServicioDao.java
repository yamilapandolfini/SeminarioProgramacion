package com.equipo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.equipo.model.Servicio;
import com.equipo.util.HibernateUtil;

public class ServicioDao implements Dao<Servicio> {

	@Override
	public void insertar(Servicio o) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		session.save(o);
		
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

	@Override
	public List<Servicio> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
