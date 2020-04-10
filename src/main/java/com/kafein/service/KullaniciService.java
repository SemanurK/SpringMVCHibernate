package com.kafein.service;

import java.util.List;

import com.kafein.model.Kullanici;

public interface KullaniciService {
	public List<Kullanici> listAllKullanicis();
	public Kullanici findKulById(int id);
}
