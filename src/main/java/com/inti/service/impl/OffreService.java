package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Offre;
import com.inti.repositories.OffreRepository;
import com.inti.service.interfaces.IOffreService;

@Service
public class OffreService implements IOffreService{
	@Autowired
	OffreRepository offreRepository;

	@Override
	public List<Offre> findAll() {

		return offreRepository.findAll();
	}

	@Override
	public Offre findOne(Long id) {

		return offreRepository.findById(id).get();
	}

	@Override
	public Offre save(Offre offre) {

		return offreRepository.save(offre);
	}

	@Override
	public void delete(Long id) {
		offreRepository.deleteById(id);
	}

	@Override
	public List<Offre> findByVilleAndTypeOffreAndPrixOffreAndSurfaceOffreAndOrientationOffre(String ville, String type, float prix, float surface,
			String orientation) {
		// TODO Auto-generated method stub
		return offreRepository.findByVilleAndTypeOffreAndPrixOffreAndSurfaceOffreAndOrientationOffre(ville, type, prix, surface, orientation);
	}

}
