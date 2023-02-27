package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Terrain;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long>{

}
