package com.webapp.sihaafrica.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "businesses")
public class Businesses {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "company_name")
	@NotBlank(message = "Vous devez saisir le nom de l/'entreprise")
	private String companyName;
	
	@Column(name = "company_responsable")
	@NotBlank(message = "Vous devez saisir le nom complet du résponsable")
	private String companyResponsable;
	
	@Column(name = "company_activity")
	@NotBlank(message = "Vous devez saisir l/'activité de l/'entreprise")
	private String companyActivity;
	
	@Column(name = "company_address")
	@NotBlank(message = "Vous devez saisir l/'adrésse de l/'entreprise")
	private String companyAddress;
	
	@Column(name = "company_country")
	@NotBlank(message = "Vous devez saisir le pays origine de votre entreprise")
	private String companyCountry;
	
	@Column(name = "company_number")
	@NotBlank(message = "Vous devez saisir le numéro de téléphone de votre entrepise")
	private String companyNumber;
	
	@Column(name = "company_fax")
	private String companyFax;
	
	@Column(name = "company_email")
	@NotBlank(message = "Vous devez saisir l/'email de l/'entreprise")
	private String companyEmail;
	
	@Column(name = "logo")
	@Lob
	private byte[] logo;
	
	@Column(name = "registration_date")
	private String registartionDate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "company_website")
	private String companyWebsite;
	
	@Column(name = "company_facebook")
	private String companyFacebook;
	
	@Column(name = "company_instagram")
	private String companyInstagram;
	
	@Column(name = "company_linkedin")
	private String companyLinkedin;
	
	@Column(name = "company_twitter")
	private String companyTwitter;
	
	@OneToOne(mappedBy = "business",cascade = CascadeType.REMOVE)
	private Paiement paiement;
	
	public Businesses() {
		
	}


	public Businesses(Long id, String companyName,String companyResponsable,String companyActivity,
			String companyAddress,String companyCountry,String companyNumber,String companyFax, 
			String companyEmail,byte[]logo,String companyWebsite, String companyFacebook, 
			String companyInstagram, String companyLinkedin,String companyTwitter,String status,String registartionDate) {
		this.id = id;
		this.companyName = companyName;
		this.companyResponsable = companyResponsable;
		this.companyActivity = companyActivity;
		this.companyAddress = companyAddress;
		this.companyCountry = companyCountry;
		this.companyNumber = companyNumber;
		this.companyFax = companyFax;
		this.companyEmail = companyEmail;
		this.logo = logo;
		this.companyWebsite = companyWebsite;
		this.companyFacebook = companyFacebook;
		this.companyInstagram = companyInstagram;
		this.companyLinkedin = companyLinkedin;
		this.companyTwitter = companyTwitter;
		this.status = status;
		this.registartionDate = registartionDate;
	}
	
	public Businesses(String companyName,String companyResponsable,String companyActivity,
			String companyAddress,String companyCountry,String companyNumber,String companyFax, 
			String companyEmail,byte[] logo,String companyWebsite, String companyFacebook, 
			String companyInstagram, String companyLinkedin,String companyTwitter,String status,String registartionDate) {
		this.companyName = companyName;
		this.companyResponsable = companyResponsable;
		this.companyActivity = companyActivity;
		this.companyAddress = companyAddress;
		this.companyCountry = companyCountry;
		this.companyNumber = companyNumber;
		this.companyFax = companyFax;
		this.companyEmail = companyEmail;
		this.logo = logo;
		this.companyWebsite = companyWebsite;
		this.companyFacebook = companyFacebook;
		this.companyInstagram = companyInstagram;
		this.companyLinkedin = companyLinkedin;
		this.companyTwitter = companyTwitter;
		this.status = status;
		this.registartionDate = registartionDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCompanyResponsable() {
		return companyResponsable;
	}


	public void setCompanyResponsable(String companyResponsable) {
		this.companyResponsable = companyResponsable;
	}

	
	public String getCompanyActivity() {
		return companyActivity;
	}


	public void setCompanyActivity(String companyActivity) {
		this.companyActivity = companyActivity;
	}


	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyCountry() {
		return companyCountry;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}


	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}
	
	public String getRegistartionDate() {
		return registartionDate;
	}

	public void setRegistartionDate(String registartionDate) {
		this.registartionDate = registartionDate;
	}

	public String getCompanyNumber() {
		return companyNumber;
	}


	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}


	public String getCompanyFax() {
		return companyFax;
	}


	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
	}


	public String getCompanyEmail() {
		return companyEmail;
	}


	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	
	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	
	public String getCompanyWebsite() {
		return companyWebsite;
	}


	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}


	public String getCompanyFacebook() {
		return companyFacebook;
	}


	public void setCompanyFacebook(String companyFacebook) {
		this.companyFacebook = companyFacebook;
	}


	public String getCompanyInstagram() {
		return companyInstagram;
	}


	public void setCompanyInstagram(String companyInstagram) {
		this.companyInstagram = companyInstagram;
	}


	public String getCompanyLinkedin() {
		return companyLinkedin;
	}


	public void setCompanyLinkedin(String companyLinkedin) {
		this.companyLinkedin = companyLinkedin;
	}


	public String getCompanyTwitter() {
		return companyTwitter;
	}


	public void setCompanyTwitter(String companyTwitter) {
		this.companyTwitter = companyTwitter;
	}


	@Override
	public String toString() {
		return "Businesses [companyName=" + companyName + ", companyResponsable=" + companyResponsable
				+ ", companyAcitivity=" + companyActivity + ", companyAddress=" + companyAddress + ", companyCountry="
				+ companyCountry + ", companyNumber=" + companyNumber + ", companyFax=" + companyFax + ", companyEmail="
				+ companyEmail + ", companyWebsite=" + companyWebsite + ", companyFacebook=" + companyFacebook
				+ ", companyInstagram=" + companyInstagram + ", companyLinkedin=" + companyLinkedin
				+ ", companyTwitter=" + companyTwitter + "]";
	}
}
