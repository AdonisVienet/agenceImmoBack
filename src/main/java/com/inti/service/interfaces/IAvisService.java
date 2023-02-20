package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Avis;

public interface IAvisService {
	List<Avis> findAll();

	Avis findOne(Long id);

	Avis save(Avis avis);

	void delete(Long id);

}
