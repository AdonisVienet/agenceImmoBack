package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Offre;
import com.inti.entities.Question;
import com.inti.service.interfaces.IQuestionService;

@RestController
@CrossOrigin
public class QuestionController {
	@Autowired
	IQuestionService questionService;
	
	@GetMapping("/questions")
	public List<Question> findAll(){
		return questionService.findAll();
	}
	
	@GetMapping("/questions/{idQuestion}")
	public Question findOne(@PathVariable("idQuestion") Long idQuestion) {
		return questionService.findOne(idQuestion);
	}
	
	@PostMapping("/questions") 
	public Question saveQuestion(@RequestBody Question question) {
		return questionService.save(question);
	}
	
	/*@PostMapping("/questions")
	public String saveQuestion(@RequestParam("objetQuestionFront") String objetQuestion, @RequestParam("descriptionQuestionFront") String descriptionQuestion)
		{
		try {
			Question currentUser = new Question();
			currentUser.setObjetQuestion(objetQuestion);
			currentUser.setDescriptionQuestion(descriptionQuestion);
			questionService.save(currentUser);
			return "File Uploaded successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Fail, maybe you had uploaded the file before";
		}
	}*/
	
	@DeleteMapping("/questions/{idQuestion}")
	public void deleteQuestion(@PathVariable("idQuestion") Long idQuestion) {
		questionService.delete(idQuestion);
	}
	
	@PutMapping("/questions/{idQuestion}")
	public Question updateQuestionWithPut(@PathVariable("idQuestion") Long idQuestion, @RequestBody Question question) {
		Question currentUser = questionService.findOne(idQuestion);
		System.out.println(currentUser.toString());
		currentUser.setObjetQuestion(question.getObjetQuestion());
		currentUser.setDescriptionQuestion(question.getDescriptionQuestion());
		return questionService.save(currentUser);
	}
	
	@PatchMapping("/questions/{idQuestion}")
	public Question updateQuestionWithPatch(@PathVariable("idQuestion") Long idQuestion, @RequestBody Question question) {
		Question currentUser = questionService.findOne(idQuestion);
		currentUser.setDescriptionQuestion(question.getDescriptionQuestion());
		return questionService.save(currentUser);
	}

}
