package com.kafein.service;

import com.kafein.dao.TalepDao;
import com.kafein.model.Talep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//@Service Bir beaninin business katman�nda �al��acak bir bean oldu�unu belirtiyoruz
@Service
public class TalepServiceImpl implements TalepService{
<<<<<<< HEAD
	
	@Autowired
    TalepDao talepDAO;	
	
=======

	@Autowired
    TalepDao talepDAO;

>>>>>>> b3d692042837a8f744073b820f8a9a4f948f08d7
	@Transactional
	public List<Talep> listAllTaleps() {		
		return this.talepDAO.listAllTaleps();
	}
	
	@Transactional
	public Talep findTalepById(int id) {		
		return this.talepDAO.findTalepById(id);
	}
	@Transactional
	public void deleteTalep(int id) {
		this.talepDAO.deleteTalep(id);
	}
	@Transactional
	public void addTalep(Talep talep) {
		this.talepDAO.addTalep(talep);
		
	}
	@Transactional
	public void updateTalep(Talep talep) {
		this.talepDAO.updateTalep(talep);
		
	}

}
