package com.webapp.sihaafrica.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "visitors")
public class Visitors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "visitor_name")
	@NotBlank(message = "Vous devez saisir votre nom")
	private String visitorName;
	
	@Column(name = "visitor_email")
	@NotBlank(message = "Vous devez saisir votre email")
	private String visitorEmail;
	
	@Column(name = "visitor_phone")
	@NotBlank(message = "Vous devez saisir votre numéro de téléphone")
	private String visitorPhone;
	
	@Column(name = "visitor_profession")
	@NotBlank(message = "Vous devez saisir votre proféssion")
	private String visitorProfession;
	
	@Column(name = "visitor_company")
	@NotBlank(message = "Vous devez saisir votre société")
	private String visitorCompany;
	
	@Column(name = "visitor_city")
	@NotBlank(message = "Vous devez saisir votre ville")
	private String visitorCity;
	
	@Column(name = "visitor_interest")
	private String visitorInterest;
	
	@Column(name = "visitor_facebook")
	private String visitorFacebook;
	
	@Column(name = "visitor_twitter")
	private String visitorTwitter;
	
	@Column(name = "visitor_linkedin")
	private String visitorLinkedin;
	
	@Column(name = "visitor_message")
	private String visitorMessage;
	
	public Visitors() {
		
	}

	public Visitors(Long id, String visitorName, String visitorEmail, String visitorPhone, String visitorProfession,
			String visitorCompany, String visitorCity, String visitorInterest, String visitorFacebook,
			String visitorTwitter, String visitorLinkedin, String visitorMessage) {
		this.id = id;
		this.visitorName = visitorName;
		this.visitorEmail = visitorEmail;
		this.visitorPhone = visitorPhone;
		this.visitorProfession = visitorProfession;
		this.visitorCompany = visitorCompany;
		this.visitorCity = visitorCity;
		this.visitorInterest = visitorInterest;
		this.visitorFacebook = visitorFacebook;
		this.visitorTwitter = visitorTwitter;
		this.visitorLinkedin = visitorLinkedin;
		this.visitorMessage = visitorMessage;
	}
	
	public Visitors(String visitorName, String visitorEmail, String visitorPhone, String visitorProfession,
			String visitorCompany, String visitorCity, String visitorInterest, String visitorFacebook,
			String visitorTwitter, String visitorLinkedin, String visitorMessage) {
		this.visitorName = visitorName;
		this.visitorEmail = visitorEmail;
		this.visitorPhone = visitorPhone;
		this.visitorProfession = visitorProfession;
		this.visitorCompany = visitorCompany;
		this.visitorCity = visitorCity;
		this.visitorInterest = visitorInterest;
		this.visitorFacebook = visitorFacebook;
		this.visitorTwitter = visitorTwitter;
		this.visitorLinkedin = visitorLinkedin;
		this.visitorMessage = visitorMessage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorEmail() {
		return visitorEmail;
	}

	public void setVisitorEmail(String visitorEmail) {
		this.visitorEmail = visitorEmail;
	}

	public String getVisitorPhone() {
		return visitorPhone;
	}

	public void setVisitorPhone(String visitorPhone) {
		this.visitorPhone = visitorPhone;
	}

	public String getVisitorProfession() {
		return visitorProfession;
	}

	public void setVisitorProfession(String visitorProfession) {
		this.visitorProfession = visitorProfession;
	}

	public String getVisitorCompany() {
		return visitorCompany;
	}

	public void setVisitorCompany(String visitorCompany) {
		this.visitorCompany = visitorCompany;
	}

	public String getVisitorCity() {
		return visitorCity;
	}

	public void setVisitorCity(String visitorCity) {
		this.visitorCity = visitorCity;
	}

	public String getVisitorInterest() {
		return visitorInterest;
	}

	public void setVisitorInterest(String visitorInterest) {
		this.visitorInterest = visitorInterest;
	}

	public String getVisitorFacebook() {
		return visitorFacebook;
	}

	public void setVisitorFacebook(String visitorFacebook) {
		this.visitorFacebook = visitorFacebook;
	}

	public String getVisitorTwitter() {
		return visitorTwitter;
	}

	public void setVisitorTwitter(String visitorTwitter) {
		this.visitorTwitter = visitorTwitter;
	}

	public String getVisitorLinkedin() {
		return visitorLinkedin;
	}

	public void setVisitorLinkedin(String visitorLinkedin) {
		this.visitorLinkedin = visitorLinkedin;
	}

	public String getVisitorMessage() {
		return visitorMessage;
	}

	public void setVisitorMessage(String visitorMessage) {
		this.visitorMessage = visitorMessage;
	}

	@Override
	public String toString() {
		return "Visitors [visitorName=" + visitorName + ", visitorEmail=" + visitorEmail + ", visitorPhone="
				+ visitorPhone + ", visitorProfession=" + visitorProfession + ", visitorCompany=" + visitorCompany
				+ ", visitorCity=" + visitorCity + ", visitorInterest=" + visitorInterest + ", visitorFacebook="
				+ visitorFacebook + ", visitorTwitter=" + visitorTwitter + ", visitorLinkedin=" + visitorLinkedin
				+ ", visitorMessage=" + visitorMessage + "]";
	}
}
