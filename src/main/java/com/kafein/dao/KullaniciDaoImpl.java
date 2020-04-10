package com.kafein.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kafein.model.Kullanici;

@Repository
public class KullaniciDaoImpl implements KullaniciDao {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Kullanici> listAllKullanicis() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Kullanici> kullist = session.createQuery("from Kullanici").list();
		return kullist;

	}
	@Transactional
	public Kullanici findKulById(int id) {
		Kullanici k = (Kullanici) this.sessionFactory.getCurrentSession().load(Kullanici.class, new Integer(id));
		return k;
	}

}
