package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Maison;

@Repository
public interface MaisonRepository extends JpaRepository<Maison, Long> {

}
