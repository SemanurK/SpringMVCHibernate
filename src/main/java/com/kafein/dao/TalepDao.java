package com.kafein.dao;

import java.util.List;

import com.kafein.model.Talep;

public interface TalepDao {

	public List<Talep> listAllTaleps();

	public void addTalep(Talep talep);

	public void updateTalep(Talep talep);

	public Talep findTalepById(int id);
	
	public int ControlTalepId(int talep_id);

	public void deleteTalep(int id);
	
	public int searchTalepAdd(List<Talep> list);
	
	public int controlSprint(int sprint);
	
	public List<Talep> filterTalep(String value, String filter, String state);

}
