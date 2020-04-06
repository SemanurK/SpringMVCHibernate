package com.kafein.dao;

import java.util.List;

import com.kafein.model.Talep;

public interface TalepDao {

	public List listAllTaleps();
	 
	 public void saveOrUpdate(Talep talep);
	 
	 public Talep findTalepById(int id);
	 
	 public void deleteTalep(int id);
}
