package com.webapp.sihaafrica.Services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.webapp.sihaafrica.Models.Paiement;


@Component
public interface PaiementRepository extends CrudRepository<Paiement,Long> {

}
