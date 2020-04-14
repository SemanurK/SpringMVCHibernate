package com.kafein.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.kafein.model.Kullanici;
import com.kafein.model.Talep;

@Repository
public class TalepDaoImpl implements TalepDao {

	@Autowired
	SessionFactory sessionFactory;
	// SessionFactory veritabanýna baðlanma iþlemlerinþ yönetmek için
	// kullanýlýr.

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Talep> listAllTaleps() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Talep> taleplist = session.createQuery("from Talep").list();
		return taleplist;

	}

	@Transactional
	public void addTalep(Talep talep) {
		this.sessionFactory.getCurrentSession().persist(talep);

	}

	@Transactional
	public void updateTalep(Talep talep) {
		this.sessionFactory.getCurrentSession().update(talep);

	}

	@Transactional
	public Talep findTalepById(int id) {
		Session session = this.sessionFactory.getCurrentSession();	
		/*Yöntem 1*/
	//	Talep talep = (Talep) session.load(Talep.class, new Integer(id));
		
		/*Yöntem 2*/
		Talep talep = (Talep) session.createQuery("from Talep where id = :id")	
		        .setParameter("id", id)
		        .uniqueResult();
		
		return talep;
	}

	@Transactional
	public void deleteTalep(int id) {
		Talep t = (Talep) this.sessionFactory.getCurrentSession().load(Talep.class, new Integer(id));
		if (null != t) {
			this.sessionFactory.getCurrentSession().delete(t);
		}

	}

}
