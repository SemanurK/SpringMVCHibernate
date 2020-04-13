package com.kafein.model;

import java.sql.Date;
import java.util.HashSet;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "talep2")
public class Talep {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "adi")
	private String adi;

	@Column(name = "spring_no")
	private String spring_no;

	@Column(name = "tarih")
	private Date tarih;

	@Column(name = "durum")
	private boolean durum;

	@Column(name = "talep_id")
	private int talep_id;

	@Column(name = "change_id")
	private String change_id;

	@Column(name = "baslangic_tarihi")
	private Date baslangic_tarihi;

	@Column(name = "bitis_tarihi")
	private Date bitis_tarihi;

	@Column(name = "efor")
	private String efor;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "talep_sahip_kul_id", nullable = false)
	private Kullanici talep_sahip;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSpring_no() {
		return spring_no;
	}

	public void setSpring_no(String spring_no) {
		this.spring_no = spring_no;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public int getTalep_id() {
		return talep_id;
	}

	public void setTalep_id(int talep_id) {
		this.talep_id = talep_id;
	}

	public String getChange_id() {
		return change_id;
	}

	public void setChange_id(String change_id) {
		this.change_id = change_id;
	}

	public boolean isDurum() {
		return durum;
	}

	public void setDurum(boolean durum) {
		this.durum = durum;
	}

	public Date getBaslangic_tarihi() {
		return baslangic_tarihi;
	}

	public void setBaslangic_tarihi(Date baslangic_tarihi) {
		this.baslangic_tarihi = baslangic_tarihi;
	}

	public Date getBitis_tarihi() {
		return bitis_tarihi;
	}

	public void setBitis_tarihi(Date bitis_tarihi) {
		this.bitis_tarihi = bitis_tarihi;
	}

	public String getEfor() {
		return efor;
	}

	public void setEfor(String efor) {
		this.efor = efor;
	}

}
