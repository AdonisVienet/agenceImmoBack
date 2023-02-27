package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Visite;

public interface IVisiteService {
	List<Visite> findAll();

	Visite findOne(Long id);

	Visite save(Visite visite);

	void delete(Long id);
}
