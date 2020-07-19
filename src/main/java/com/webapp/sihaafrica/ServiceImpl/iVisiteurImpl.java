package com.webapp.sihaafrica.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.sihaafrica.Models.Exhibitors;
import com.webapp.sihaafrica.Services.ExhibitorsRepository;
import com.webapp.sihaafrica.Services.iVisiteur;


@Component("iVisiteurImpl")
public class iVisiteurImpl implements iVisiteur {
	
	@Autowired
	private ExhibitorsRepository exhibitorsRepository; 
	
	@Override
	public List<String> showAllReservedStands() {
		List<String> reservedStands = new ArrayList<String>();
		Iterable<Exhibitors> itExhibitors = exhibitorsRepository.findAll();
		for(Exhibitors oneExhibiters : itExhibitors) {
			reservedStands.add(oneExhibiters.getStands());
		}
		return reservedStands;
	}

}
