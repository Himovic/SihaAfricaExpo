package com.webapp.sihaafrica.Services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.webapp.sihaafrica.Models.Businesses;



@Component("businessesRepository")
public interface BusinessesRepository extends CrudRepository<Businesses,Long> {

}
