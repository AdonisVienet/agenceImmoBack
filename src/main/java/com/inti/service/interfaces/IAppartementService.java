package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Appartement;

public interface IAppartementService {

	List<Appartement> findAll();

	Appartement findOne(Long id);

	Appartement save(Appartement appartement);

	void delete(Long id);
}
