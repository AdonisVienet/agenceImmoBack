package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Avis;

@Repository
public interface AvisRepository extends JpaRepository<Avis, Long>{

}
