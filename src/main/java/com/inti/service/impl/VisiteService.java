package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Visite;
import com.inti.repositories.VisiteRepository;
import com.inti.service.interfaces.IVisiteService;

@Service
public class VisiteService implements IVisiteService{
	@Autowired
	VisiteRepository visiteRepository;

	@Override
	public List<Visite> findAll() {

		return visiteRepository.findAll();
	}

	@Override
	public Visite findOne(Long id) {

		return visiteRepository.findById(id).get();
	}

	@Override
	public Visite save(Visite visite) {

		return visiteRepository.save(visite);
	}

	@Override
	public void delete(Long id) {
		visiteRepository.deleteById(id);
	}

}
