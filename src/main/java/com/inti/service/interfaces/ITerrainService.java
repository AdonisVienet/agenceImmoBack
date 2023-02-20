package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Terrain;

public interface ITerrainService {
	List<Terrain> findAll();

	Terrain findOne(Long id);

	Terrain save(Terrain terrain);

	void delete(Long id);
}