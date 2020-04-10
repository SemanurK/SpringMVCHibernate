package com.kafein.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "kullanici")

public class Kullanici {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "adSoyad")
	private String adSoyad;

	@Column(name = "gorev")
	private String gorev;

   /*
    * Kullanıcıların talepleri var onetomany ilişkisi
    * mappedBy ile ilişkinin sahibi belirtilir.
    * */

	@OneToMany(mappedBy="kul")
	private List<Talep> taleps=new ArrayList<Talep>();
	
	public List<Talep> getTaleps() {
		return taleps;
	}

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

	
}
