package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Terrain;
import com.inti.repositories.TerrainRepository;
import com.inti.service.interfaces.ITerrainService;

@Service
public class TerrainService implements ITerrainService{
	@Autowired
	TerrainRepository terrainRepository;

	@Override
	public List<Terrain> findAll() {

		return terrainRepository.findAll();
	}

	@Override
	public Terrain findOne(Long id) {

		return terrainRepository.findById(id).get();
	}

	@Override
	public Terrain save(Terrain terrain) {

		return terrainRepository.save(terrain);
	}

	@Override
	public void delete(Long id) {
		terrainRepository.deleteById(id);
	}

}
