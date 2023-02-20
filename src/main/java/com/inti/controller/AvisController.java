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
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Avis;
import com.inti.service.interfaces.IAvisService;

@RestController
@CrossOrigin
public class AvisController {
	
	@Autowired
	IAvisService avisService;
	
	@GetMapping("/avis")
	public List<Avis> findAll() {
		return avisService.findAll();
	}

	@GetMapping("/avis/{idAvis}")
	public Avis findOne(@PathVariable("idAvis") Long id) {
		return avisService.findOne(id);
	}

	@PostMapping("/avis")
	public Avis save(@RequestBody Avis avis) {
		return avisService.save(avis);
	}

	@DeleteMapping("/avis/{idAvis}")
	public void delete(@PathVariable("idAvis") Long id) {
		avisService.delete(id);
	}

	@PutMapping("/avis/{idAvis}")
	public Avis updateAvisWithPut(@PathVariable("idAvis") Long id, @RequestBody Avis avis) {
		Avis currentAvis = avisService.findOne(id);
		currentAvis.setTitreAvis(avis.getTitreAvis());
		currentAvis.setDescriptionAvis(avis.getDescriptionAvis());
		return avisService.save(currentAvis);
	}
	
	@PatchMapping("/avis/{idAvis}")
	public Avis updateAvisWithPatch(@PathVariable("idAvis") Long id, @RequestBody Avis avis) {
		Avis currentAvis = avisService.findOne(id);
		currentAvis.setDescriptionAvis(avis.getDescriptionAvis());
		return avisService.save(currentAvis);
	}

}

