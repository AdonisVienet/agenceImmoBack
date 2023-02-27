package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Maison;

public interface IMaisonService {
	List<Maison> findAll();

	Maison findOne(Long id);

	Maison save(Maison maison);

	void delete(Long id);

}
