package com.webapp.sihaafrica.Services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.webapp.sihaafrica.Models.Visitors;


@Component("visitorsRepository")
public interface VisitorsRepository extends CrudRepository<Visitors,Long> {

}
