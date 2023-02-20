package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Garage;
import com.inti.repositories.GarageRepository;
import com.inti.service.interfaces.IGarageService;

@Service
public class GarageService implements IGarageService{
	@Autowired
	GarageRepository garageRepository;

	@Override
	public List<Garage> findAll() {

		return garageRepository.findAll();
	}

	@Override
	public Garage findOne(Long id) {

		return garageRepository.findById(id).get();
	}

	@Override
	public Garage save(Garage garage) {

		return garageRepository.save(garage);
	}

	@Override
	public void delete(Long id) {
		garageRepository.deleteById(id);
	}

}
