package com.webapp.sihaafrica.Services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.webapp.sihaafrica.Models.Exhibitors;


@Component("exhibitorsRepository")
public interface ExhibitorsRepository extends CrudRepository<Exhibitors,Long> {
	
}
