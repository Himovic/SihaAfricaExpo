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
@Table(name = "exhibitors")
public class Exhibitors {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "company_name")
	@NotBlank(message = "Vous devez saisir le nom de l\'entreprise")
	private String companyName;
	
	@Column(name = "company_responsable")
	@NotBlank(message = "Vous devez saisir le nom complet du résponsable")
	private String companyResponsable;
	
	@Column(name = "company_activity")
	@NotBlank(message = "Vous devez saisir l/'activité de l\'entreprise")
	private String companyActivity;
	
	@Column(name = "company_address")
	@NotBlank(message = "Vous devez saisir l/'adrésse de l\'entreprise")
	private String companyAddress;
	
	@Column(name = "company_city")
	@NotBlank(message = "Vous devez saisir la Wilaya")
	private String companyCity;
	
	@Column(name = "company_country")
	@NotBlank(message = "Vous devez saisir le pays origine de votre entreprise")
	private String companyCountry;
	
	@Column(name = "company_number")
	@NotBlank(message = "Vous devez saisir le numéro de téléphone de votre entrepise")
	private String companyNumber;
	
	@Column(name = "company_fax")
	private String companyFax;
	
	@Column(name = "company_email")
	@NotBlank(message = "Vous devez saisir l\'email de l\'entreprise")
	private String companyEmail;
	
	@Column(name = "logo")
	@Lob
	private byte[] logo;
	
	@Column(name = "registration_date")
	private String registrationDate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "company_website")
	private String companyWebsite;
	
	@Column(name = "stands")
	@NotBlank(message = "Vous devez choisir un(des) stand(s)")
	private String stands;
	
	@Column(name = "facade")
	private String facade;
	
	@Column(name = "surface")
	private String surface;
	
	@Column(name = "lunchbox")
	private Integer nbrLunchbox;
	
	@Column(name = "pub_minipage")
	private Integer nbrMinPage;
	
	@Column(name = "pub_onepage")
	private Integer nbrPubOnePage;
	
	@Column(name = "pub_doublepage")
	private Integer nbrPubDoublePage;
	
	@Column(name = "chairs")
	private Integer nbrChair;
	
	@Column(name = "tables")
	private Integer nbrTable;
	
	@Column(name = "desks")
	private Integer nbrDesk;
	
	@Column(name = "montant")
	private double montant;
		
	@OneToOne(mappedBy = "exhibitor",cascade = CascadeType.REMOVE)
	private Paiement paiement;
	

	public Exhibitors() {
		
	}
	
	public Exhibitors(Long id, String companyName, String companyResponsable, String companyActivity,
			String companyAddress, String companyCountry, String companyNumber, String companyFax,
			String companyEmail,byte[] logo,String companyWebsite,String registrationDate,String status,
			String stands,String facade,String surface,double montant,
			Integer nbrLunchbox,Integer nbrMinPage,Integer nbrPubOnePage,Integer nbrPubDoublePage,Integer nbrChair,
			Integer nbrTable,Integer nbrDesk,String companyCity) {
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
		this.stands = stands;
		this.facade = facade;
		this.surface = surface;
		this.montant = montant;
		this.nbrLunchbox = nbrLunchbox;
		this.nbrMinPage = nbrMinPage;
		this.nbrPubOnePage = nbrPubOnePage;
		this.nbrPubDoublePage = nbrPubDoublePage;
		this.nbrChair = nbrChair;
		this.nbrTable = nbrTable;
		this.nbrDesk = nbrDesk;
		this.companyCity = companyCity;
	}

	
	public Exhibitors(Long id, String companyName, String companyResponsable, String companyActivity,
			String companyAddress, String companyCountry, String companyNumber, String companyFax,
			String companyEmail,byte[] logo,String companyWebsite,String registrationDate,String status,
			String stands,String facade,double montant,Paiement paiement,String companyCity) {
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
		this.stands = stands;
		this.facade = facade;
		this.montant = montant;
		this.paiement = paiement;
		this.companyCity = companyCity;
	}
	
	public Exhibitors(String companyName, String companyResponsable, String companyActivity,
			String companyAddress, String companyCountry, String companyNumber, String companyFax, 
			String companyEmail,byte[] logo,String registrationDate,String status,
			String companyWebsite,String stands,String facade, double montant,Paiement paiement,
			String companyCity) {
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
		this.stands = stands;
		this.facade = facade;
		this.montant = montant;
		this.paiement = paiement;
		this.companyCity = companyCity;
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
	
	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
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

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getCompanyCountry() {
		return companyCountry;
	}

	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
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
	
	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStands() {
		return stands;
	}

	public void setStands(String stands) {
		this.stands = stands;
	}
	
	public String getFacade() {
		return facade;
	}

	public void setFacade(String facade) {
		this.facade = facade;
	}
	
	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	public Integer getNbrLunchbox() {
		return nbrLunchbox;
	}

	public void setNbrLunchbox(Integer nbrLunchbox) {
		this.nbrLunchbox = nbrLunchbox;
	}
	
	public Integer getNbrMinPage() {
		return nbrMinPage;
	}

	public void setNbrMinPage(Integer nbrMinPage) {
		this.nbrMinPage = nbrMinPage;
	}

	public Integer getNbrPubOnePage() {
		return nbrPubOnePage;
	}

	public void setNbrPubOnePage(Integer nbrPubOnePage) {
		this.nbrPubOnePage = nbrPubOnePage;
	}

	public Integer getNbrPubDoublePage() {
		return nbrPubDoublePage;
	}

	public void setNbrPubDoublePage(Integer nbrPubDoublePage) {
		this.nbrPubDoublePage = nbrPubDoublePage;
	}

	public Integer getNbrChair() {
		return nbrChair;
	}

	public void setNbrChair(Integer nbrChair) {
		this.nbrChair = nbrChair;
	}

	public Integer getNbrTable() {
		return nbrTable;
	}

	public void setNbrTable(Integer nbrTable) {
		this.nbrTable = nbrTable;
	}

	public Integer getNbrDesk() {
		return nbrDesk;
	}

	public void setNbrDesk(Integer nbrDesk) {
		this.nbrDesk = nbrDesk;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
	
	
	@Override
	public String toString() {
		return "Exhibitors [companyName=" + companyName + ", companyResponsable=" + companyResponsable
				+ ", companyAcitivity=" + companyActivity + ", companyAddress=" + companyAddress + ", companyCountry="
				+ companyCountry + ", companyNumber=" + companyNumber + ", companyFax=" + companyFax + ", companyEmail="
				+ companyEmail + ", companyWebsite=" + companyWebsite +"]";
	}
}
