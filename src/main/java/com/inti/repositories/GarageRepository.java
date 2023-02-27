package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Garage;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Long>{

}
