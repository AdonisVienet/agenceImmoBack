package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Appartement;

@Repository
public interface AppartementRepository extends JpaRepository<Appartement, Long> {

}
