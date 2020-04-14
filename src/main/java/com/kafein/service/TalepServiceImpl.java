package com.kafein.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kafein.dao.TalepDao;
import com.kafein.model.Talep;

//@Service Bir beaninin business katmanýnda çalýþacak bir bean olduðunu belirtiyoruz
@Service
public class TalepServiceImpl implements TalepService{
	
	@Autowired
    TalepDao talepDAO;	
	
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
