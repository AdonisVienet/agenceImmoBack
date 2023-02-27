package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Offre;

public interface IOffreService {

	List<Offre> findAll();

	Offre findOne(Long id);

	Offre save(Offre offre);

	void delete(Long id);
	
	List<Offre> findByVille(String ville);


//	List<Offre> findByVille(String ville);
//
//	List<Offre> findByTypeOffre(String typeOffre);
//
//	List<Offre> findByPrix(float prix);
//
//	List<Offre> findBySurface(float surface);
//
//	List<Offre> findByOrientation(String orientation);

}
