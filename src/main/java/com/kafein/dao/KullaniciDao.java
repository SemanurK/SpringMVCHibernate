package com.kafein.dao;

import java.util.List;

import com.kafein.model.Kullanici;



public interface KullaniciDao {
	
	public List<Kullanici> listAllKullanicis();
	public Kullanici findKulById(int id);

	

}
