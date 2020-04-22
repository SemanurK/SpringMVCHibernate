package com.kafein.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "kullanici")

public class Kullanici {
	@Id
	@Column(name = "kul_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "adSoyad")
	private String adSoyad;

	@Column(name = "gorev")
	private String gorev;

	/*
	 * Kullan�c�lar�n talepleri var onetomany ili�kisi mappedBy ile ili�kinin
	 * sahibi belirtilir.
	 */

	@OneToMany(mappedBy = "talep_sahip", fetch = FetchType.EAGER)
	private Set<Talep> taleps;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public String getGorev() {
		return gorev;
	}

	public void setGorev(String gorev) {
		this.gorev = gorev;
	}
public Kullanici()
{
	
}
	public Kullanici(int id, String adSoyad, String gorev) {
		super();
		this.id = id;
		this.adSoyad = adSoyad;
		this.gorev = gorev;
	}
	public Kullanici(int id){
		this.id=id;
	}

}
