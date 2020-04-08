package com.kafein.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
	public List<Talep> listAllTaleps() {
		// Session session = this.sessionFactory.getCurrentSession();
		List<Talep> taleplist = this.sessionFactory.getCurrentSession().createQuery("from talep").list();
		return taleplist;
	}

	public void addTalep(Talep talep) {
		this.sessionFactory.getCurrentSession().persist(talep);

	}

	public void updateTalep(Talep talep) {
		this.sessionFactory.getCurrentSession().update(talep);

	}

	public Talep findTalepById(int id) {
		Talep talep=(Talep) this.sessionFactory.getCurrentSession().load(Talep.class, new Integer(id));
		return talep;
	}

	public void deleteTalep(int id) {
		Talep t = (Talep) this.sessionFactory.getCurrentSession().load(Talep.class, new Integer(id));
		if(null != t){
			this.sessionFactory.getCurrentSession().delete(t);
		}

	}

}
