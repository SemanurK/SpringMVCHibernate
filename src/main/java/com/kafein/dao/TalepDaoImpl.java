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
//		 String hql2="select k.kul_ad_soyad from Talep t join Kullanici k WHERE t.talep_sahip = k.kul_id";
//		 String hql = "from Talep as t INNER JOIN from Kullanici as k WHERE  t.talep_sahip = k.kul_id";
//		
//		 String FIND_PRODUCT_CLASS_ID = "SELECT t.talep_id FROM Talep t"+ 
//				 " JOIN Kullanici k " +
//				 " WHERE  t.talep_sahip =:k.kul_id";
	
		 List<Talep> taleplist = session.createQuery("from Kullanici k JOIN k.taleps t WHERE t.talep_sahip = k.id").list();
		 //List<Talep> taleplist = session.createQuery(hql2).list();
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
		Talep talep = (Talep) this.sessionFactory.getCurrentSession().load(Talep.class, new Integer(id));
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
