package com.webapp.sihaafrica.Services;

import com.webapp.sihaafrica.Models.Businesses;

public interface iBusiness {
	
	public boolean updateBtoBStatus(Long id,String status);
	public Businesses findByCompany(String companyName);
}
