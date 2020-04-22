package com.kafein.model;



import java.util.Date; // init binder util.date ile calýsýyormuþ bu yüzden buna çevirince oldu

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "talep2")
//@Indexed
public class Talep {

	public Talep(String adi, String spring_no, boolean durum, int talep_id, String efor) {
		super();
		this.adi = adi;
		this.spring_no = spring_no;
		this.durum = durum;
		this.talep_id = talep_id;
		this.efor = efor;
	}
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	@Column(name = "adi")
	private String adi;
	
//	@org.hibernate.search.annotations.Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@Column(name = "spring_no")
	private String spring_no;

	@DateTimeFormat(pattern = "yyyy-MM-dd",iso=ISO.DATE) // This is for bind Date with @ModelAttribute
	@Column(name = "tarih")
	private Date tarih;

	@Column(name = "durum")
	private boolean durum;

	@Column(name = "talep_id")
	private int talep_id;

	@Column(name = "change_id")
	private String change_id;


	@DateTimeFormat(pattern = "yyyy-MM-dd",iso=ISO.DATE) // This is for bind Date with @ModelAttribute
	@Column(name = "baslangic_tarihi")
	private Date baslangic_tarihi;

	//@DateTimeFormat(pattern = "yyyy-MM-dd",iso=ISO.DATE) // This is for bind Date with @ModelAttribute
	@Column(name = "bitis_tarihi")
	private Date bitis_tarihi;

	@Column(name = "efor")
	private String efor;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "talep_sahip_kul_id", nullable = false)
	private Kullanici talep_sahip;
	

	public Kullanici getTalep_sahip() {
		return talep_sahip;
	}

	public void setTalep_sahip(Kullanici talep_sahip) {
		this.talep_sahip = talep_sahip;
	}

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
	public Talep()
	{
		
	}

}
