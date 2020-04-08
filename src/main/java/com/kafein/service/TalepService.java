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

}
