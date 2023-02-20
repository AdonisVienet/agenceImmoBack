package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Garage;

public interface IGarageService {
	
	List<Garage> findAll();

	Garage findOne(Long id);

	Garage save(Garage garage);

	void delete(Long id);

}
