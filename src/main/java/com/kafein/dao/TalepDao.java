package com.kafein.dao;

import java.util.List;

import com.kafein.model.Talep;

public interface TalepDao {

	public List<Talep> listAllTaleps();

	public void addTalep(Talep talep);

	public void updateTalep(Talep talep);

	public Talep findTalepById(int id);

	public void deleteTalep(int id);

}
