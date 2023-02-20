package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Question;

public interface IQuestionService {
	List<Question> findAll();

	Question findOne(Long id);

	Question save(Question question);

	void delete(Long id);

}
