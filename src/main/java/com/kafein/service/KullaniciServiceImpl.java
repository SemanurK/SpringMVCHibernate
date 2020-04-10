package com.kafein.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafein.dao.KullaniciDao;
import com.kafein.model.Kullanici;

@Service
public class KullaniciServiceImpl implements KullaniciService{

	@Autowired
	KullaniciDao kullaniciDao;
	
	@Transactional
	public List<Kullanici> listAllKullanicis() {
		
		return this.kullaniciDao.listAllKullanicis();
	}

	public Kullanici findKulById(int id) {		
		return this.kullaniciDao.findKulById(id);
	}

	

}
