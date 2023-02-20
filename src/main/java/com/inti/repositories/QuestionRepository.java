package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

}
