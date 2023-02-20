package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.TypeOffre;

public interface ITypeOffreService {
	List<TypeOffre> findAll();

	TypeOffre findOne(Long id);

	TypeOffre save(TypeOffre typeOffre);

	void delete(Long id);
}
