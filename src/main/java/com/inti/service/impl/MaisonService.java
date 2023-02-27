package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Maison;
import com.inti.repositories.MaisonRepository;
import com.inti.service.interfaces.IMaisonService;

@Service
public class MaisonService implements IMaisonService{
	@Autowired
	MaisonRepository maisonRepository;

	@Override
	public List<Maison> findAll() {

		return maisonRepository.findAll();
	}

	@Override
	public Maison findOne(Long id) {

		return maisonRepository.findById(id).get();
	}

	@Override
	public Maison save(Maison maison) {

		return maisonRepository.save(maison);
	}

	@Override
	public void delete(Long id) {
		maisonRepository.deleteById(id);
	}

}
