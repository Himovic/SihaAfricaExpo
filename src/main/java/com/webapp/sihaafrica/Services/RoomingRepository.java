package com.webapp.sihaafrica.Services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.webapp.sihaafrica.Models.Rooming;


@Component("roomingRepository")
public interface RoomingRepository extends CrudRepository<Rooming,Long> {

}
