package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Offre;

@Repository
public interface OffreRepository extends JpaRepository<Offre, Long>{

}
