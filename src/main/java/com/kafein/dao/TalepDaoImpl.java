package com.kafein.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kafein.model.Talep;

@Repository 
public class TalepDaoImpl implements TalepDao {

	@Autowired
	private SessionFactory sessionFactory;
	//SessionFactory veritabanýna baðlanma iþlemlerinþ yönetmek için kullanýlýr.

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List listAllTaleps() {
		//Criteria sorgulara kriter ekleyerek sorgulama yapar 
		Criteria criteria = getSession().createCriteria(Talep.class);
		return (List) criteria.list();
		
	}

	public void saveOrUpdate(Talep talep) {		
		getSession().saveOrUpdate(talep);
	}

	public Talep findTalepById(int id) {
		 Talep talep = (Talep) getSession().get(Talep.class, id);
		return talep;
	}

	public void deleteTalep(int id) {
		 Talep talep = (Talep) getSession().get(Talep.class, id);
		 getSession().delete(talep);

	}

}
