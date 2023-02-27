package com.inti.controller;

import java.util.Date;
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

import com.inti.entities.Visite;
import com.inti.service.interfaces.IVisiteService;

@RestController
@CrossOrigin
public class VisiteController {
	@Autowired
	IVisiteService visiteService;
	
	@GetMapping("/visites")
	public List<Visite> findAll(){
		return visiteService.findAll();
	}
	
	@GetMapping("/visites/{idVisite}")
	public Visite findOne(@PathVariable("idVisite") Long idVisite) {
		return visiteService.findOne(idVisite);
	}
	
	@PostMapping("/visites")
	public String saveVisite(@RequestParam("descriptionVisiteFront") String descriptionVisite, @RequestParam("dateVisiteFront") Date dateVisite)
		{
		try {
			Visite currentUser = new Visite();
			currentUser.setDescriptionVisite(descriptionVisite);
			currentUser.setDateVisite(dateVisite);
			visiteService.save(currentUser);
			return "File Uploaded successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Fail, maybe you had uploaded the file before";
		}
	}
	
	@DeleteMapping("/visites/{idVisite}")
	public void deleteVisite(@PathVariable("idVisite") Long idVisite) {
		visiteService.delete(idVisite);
	}
	
	@PutMapping("/visites/{idVisite}")
	public Visite updateVisiteWithPut(@PathVariable("idVisite") Long idVisite, @RequestBody Visite visite) {
		Visite currentUser = visiteService.findOne(idVisite);
		System.out.println(currentUser.toString());
		currentUser.setDescriptionVisite(visite.getDescriptionVisite());
		currentUser.setDateVisite(visite.getDateVisite());
		return visiteService.save(currentUser);
	}
	
	@PatchMapping("/visites/{idVisite}")
	public Visite updateVisiteWithPatch(@PathVariable("idVisite") Long idVisite, @RequestBody Visite visite) {
		Visite currentUser = visiteService.findOne(idVisite);
		currentUser.setDateVisite(visite.getDateVisite());
		return visiteService.save(currentUser);
	}

}
