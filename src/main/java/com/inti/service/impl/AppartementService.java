package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Appartement;
import com.inti.repositories.AppartementRepository;
import com.inti.service.interfaces.IAppartementService;

@Service
public class AppartementService implements IAppartementService{
	@Autowired
	AppartementRepository appartementRepository;

	@Override
	public List<Appartement> findAll() {

		return appartementRepository.findAll();
	}

	@Override
	public Appartement findOne(Long id) {

		return appartementRepository.findById(id).get();
	}

	@Override
	public Appartement save(Appartement appartement) {

		return appartementRepository.save(appartement);
	}

	@Override
	public void delete(Long id) {
		appartementRepository.deleteById(id);
	}
}