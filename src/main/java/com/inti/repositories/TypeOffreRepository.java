package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.TypeOffre;

@Repository
public interface TypeOffreRepository extends JpaRepository<TypeOffre, Long> {

}
