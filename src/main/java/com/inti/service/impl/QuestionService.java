package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Question;
import com.inti.repositories.QuestionRepository;
import com.inti.service.interfaces.IQuestionService;

@Service
public class QuestionService implements IQuestionService{
	@Autowired
	QuestionRepository questionRepository;

	@Override
	public List<Question> findAll() {

		return questionRepository.findAll();
	}

	@Override
	public Question findOne(Long id) {

		return questionRepository.findById(id).get();
	}

	@Override
	public Question save(Question question) {

		return questionRepository.save(question);
	}

	@Override
	public void delete(Long id) {
		questionRepository.deleteById(id);
	}

}
