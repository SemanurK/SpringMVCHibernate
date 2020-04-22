package com.kafein.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;
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
		/* Yöntem 1 */
		// Talep talep = (Talep) session.load(Talep.class, new Integer(id));

		/* Yöntem 2 */
		Talep talep = (Talep) session.createQuery("from Talep where id = :id").setParameter("id", id).uniqueResult();

		return talep;
	}

	@Transactional
	public void deleteTalep(int id) {
		Talep t = (Talep) this.sessionFactory.getCurrentSession().load(Talep.class, new Integer(id));
		if (null != t) {
			this.sessionFactory.getCurrentSession().delete(t);
		}
	}

	@Transactional
	public int ControlTalepId(int talep_id) {
		Query sonuc = sessionFactory.getCurrentSession().createQuery("from Talep where talep_id = :talep_id")
				.setParameter("talep_id", talep_id);
		return sonuc.list().size();

	}

	@Transactional
	public int searchTalepAdd(List<Talep> list) {
		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setTalep_sahip(new Kullanici(1, "Bilinmiyor", ""));
				addTalep(list.get(i));
			}
		}
		return list.size();
	}

	@Transactional
	@Override
	public int controlSprint(int sprint) {
		return this.sessionFactory.getCurrentSession().createQuery("from Talep where spring_no = :spring_no")
				.setParameter("spring_no", String.valueOf(sprint)).list().size();
	}

	@Transactional
	@Override
	public List<Talep> filterTalep(String value, String filter, String state) {
		Query q;
		if(state.equals("hepsi")){
			 q = this.sessionFactory.getCurrentSession()
					.createQuery("from Talep where " + filter + " LIKE :value").setString("value", '%'+value+'%');
		}else{			
		int state_k = Boolean.parseBoolean(state) ? 1 : 0;
		 q = this.sessionFactory.getCurrentSession()
				.createQuery("from Talep where " + filter + " LIKE :value and durum=:state_k").setString("value", '%'+value+'%').setInteger("state_k", state_k);	
		}	List<Talep> talepList = q.list();

		return talepList;
	}

}
