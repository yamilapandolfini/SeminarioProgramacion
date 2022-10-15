package com.equipo.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;

import com.equipo.model.Cliente;
import com.equipo.util.HibernateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("deprecation")
public class ClienteDao implements Dao<Cliente>{
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ObservableList<Cliente> obtenerTodos() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Cliente");
		ObservableList<Cliente> clienteList = FXCollections.observableArrayList(query.list());
		tx.rollback();
		
		return clienteList;
	}
	
	public Cliente obtenerClientePorDocumento(Integer tipoDocumento, Integer nroDocumento) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		Query<Cliente> query = session.createQuery("FROM Cliente WHERE documento = :nroDocumento AND tipo_documento = :tipoDocumento");
		query.setParameter("nroDocumento", nroDocumento);
		query.setParameter("tipoDocumento", tipoDocumento);
		
		Cliente cliente = query.uniqueResult();		
		tx.rollback();
		
		return cliente;
	}

	@Override
	public void insertar(Cliente o) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(o);
		tx.commit();		
	}

	public int insertarRetID(Cliente o) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		int clienteid = (Integer)session.save(o);
		tx.commit();
		return clienteid;
	}
	
	@Override
	public void modificar(Cliente o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Cliente o) {
		// TODO Auto-generated method stub
		
	}

}
