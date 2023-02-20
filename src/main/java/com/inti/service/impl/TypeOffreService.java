package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.TypeOffre;
import com.inti.repositories.TypeOffreRepository;
import com.inti.service.interfaces.ITypeOffreService;

@Service
public class TypeOffreService implements ITypeOffreService{
	@Autowired
	TypeOffreRepository typeOffreRepository;

	@Override
	public List<TypeOffre> findAll() {

		return typeOffreRepository.findAll();
	}

	@Override
	public TypeOffre findOne(Long id) {

		return typeOffreRepository.findById(id).get();
	}

	@Override
	public TypeOffre save(TypeOffre typeOffre) {

		return typeOffreRepository.save(typeOffre);
	}

	@Override
	public void delete(Long id) {
		typeOffreRepository.deleteById(id);
	}

}
