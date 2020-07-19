package com.webapp.sihaafrica.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rooming")
public class Rooming {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "hotel_name")
	private String hotelName;
	
	@Column(name = "hotel_price")
	private double hotelPrice;
	
	@Column(name = "company_name")
	private String companyPhone;
	
	@Column(name = "rooming_type")
	private String roomingType;
	
	@Column(name = "bed_type")
	private String bedType;
	
	@Column(name = "client_name")
	private  String clientsName;
	
	@Column(name = "client_email")
	private String clientEmail;
	
	@Column(name = "arriving_date")
	private String arrivingDate;
	
	@Column(name = "leaving_date")
	private String leavingDate;
	
	public Rooming() {
		
	}
	
	public Rooming(Long id,String hotelName,double hotelPrice,String companyPhone,String roomingType,
			String clientEmail,String clientsName,String arrivingDate,String leavingDate) {
		this.id = id;
		this.hotelName = hotelName;
		this.hotelPrice = hotelPrice;
		this.companyPhone = companyPhone;
		this.roomingType = roomingType;
		this.clientsName = clientsName;
		this.clientEmail = clientEmail;
		this.arrivingDate = arrivingDate;
		this.leavingDate = leavingDate;
	}
	
	public Rooming(String hotelName,double hotelPrice,String companyPhone,String roomingType,
			String clientEmail,String clientsName,String arrivingDate,String leavingDate) {
		this.hotelName = hotelName;
		this.hotelPrice = hotelPrice;
		this.companyPhone = companyPhone;
		this.roomingType = roomingType;
		this.clientsName = clientsName;
		this.clientEmail = clientEmail;
		this.arrivingDate = arrivingDate;
		this.leavingDate = leavingDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public double getHotelPrice() {
		return hotelPrice;
	}

	public void setHotelPrice(double hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	public String getRoomingType() {
		return roomingType;
	}

	public void setRoomingType(String roomingType) {
		this.roomingType = roomingType;
	}
	
	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getClientsName() {
		return clientsName;
	}

	public void setClientsName(String clientsName) {
		this.clientsName = clientsName;
	}
	
	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getArrivingDate() {
		return arrivingDate;
	}

	public void setArrivingDate(String arrivingDate) {
		this.arrivingDate = arrivingDate;
	}

	public String getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(String leavingDate) {
		this.leavingDate = leavingDate;
	}

	@Override
	public String toString() {
		return "Rooming [companyPhone=" + companyPhone + ", roomingType=" + roomingType + ", clientsName=" + clientsName
				+ "]";
	}
}
