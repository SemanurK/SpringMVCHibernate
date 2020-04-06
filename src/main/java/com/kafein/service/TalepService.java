package com.kafein.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kafein.model.Talep;


public interface TalepService {
	public List listAllTaleps();
	 
	 public void saveOrUpdate(Talep talep);
	 
	 public Talep findTalepById(int id);
	 
	 public void deleteTalep(int id);

}
