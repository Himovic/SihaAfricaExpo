package com.webapp.sihaafrica.Services;

import com.webapp.sihaafrica.Models.Exhibitors;

public interface iExhibitor {
	
	public boolean updateExhibitorStatut(Long id,String status);
	public Exhibitors findByCompany(String companyName);
}
