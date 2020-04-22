package com.kafein.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kafein.model.Talep;


public interface TalepService {
	public List<Talep> listAllTaleps();

	public void addTalep(Talep talep);

	public void updateTalep(Talep talep);

	public Talep findTalepById(int id);

	public void deleteTalep(int id);

	public int ControlTalepId(int talep_id);
	
	public int searchTalepAdd(List<Talep> list);
	
	public int controlSprint(int sprint);
	
	public List<Talep> filterTalep(String value, String filter, String state);
}
