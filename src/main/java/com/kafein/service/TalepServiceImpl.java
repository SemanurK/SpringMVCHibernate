package com.kafein.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafein.dao.TalepDao;
import com.kafein.model.Talep;

//@Service Bir beaninin business katmanýnda çalýþacak bir bean olduðunu belirtiyoruz
@Service
@Transactional
public class TalepServiceImpl implements TalepService{
	
private	TalepDao talepdao;

	@Autowired
	public void setTalepdao(TalepDao talepdao) {
		this.talepdao = talepdao;
	}

	public List listAllTaleps() {		
		return talepdao.listAllTaleps();
	}
	
	public void saveOrUpdate(Talep talep) {
		talepdao.saveOrUpdate(talep);
	}

	public Talep findTalepById(int id) {
		
		return talepdao.findTalepById(id);
	}

	public void deleteTalep(int id) {
		talepdao.deleteTalep(id);
	}

}
