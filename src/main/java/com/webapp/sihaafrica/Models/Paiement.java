package com.webapp.sihaafrica.Models;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paiement")
public class Paiement {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	@Column(name = "fileType")
	private String fileType;
	
	@Column(name = "extension")
	private String extension;
	
	@Column(name = "paiement")
	private byte[] paiement;
	
	@OneToOne
	@JoinColumn(name = "exhibitor_id")
	private Exhibitors exhibitor;
	
	@OneToOne
	@JoinColumn(name = "business_id")
	private Businesses business;
	
	public Paiement() {
		
	}
	
	public Paiement(String fileType,String extension, byte[] paiement) {
		this.fileType = fileType;
		this.extension = extension;
		this.paiement = paiement;
	}
	
	public Paiement(Long id,String fileType,String extension,
			byte[] paiement, Exhibitors exhibitor) {
		this.id = id;
		this.fileType = fileType;
		this.extension = extension;
		this.paiement = paiement;
		this.exhibitor = exhibitor;
	} 
	
	public Paiement(String fileType, byte[] paiement,String extension,
			Exhibitors exhibitor) {
		this.fileType = fileType;
		this.extension = extension;
		this.paiement = paiement;
		this.exhibitor = exhibitor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public byte[] getPaiement() {
		return paiement;
	}

	public void setPaiement(byte[] paiement) {
		this.paiement = paiement;
	}

	public Exhibitors getExhibitor() {
		return exhibitor;
	}

	public void setExhibitor(Exhibitors exhibitor) {
		this.exhibitor = exhibitor;
	}
	
	public Businesses getBusiness() {
		return business;
	}

	public void setBusiness(Businesses business) {
		this.business = business;
	}

	@Override
	public String toString() {
		return "Paiement [id=" + id + "" +", paiement="
				+ Arrays.toString(paiement) + ", exhibitor=" + exhibitor + "]";
	}
}
