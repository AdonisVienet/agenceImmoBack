package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Visite;

@Repository
public interface VisiteRepository extends JpaRepository<Visite, Long>{

}
