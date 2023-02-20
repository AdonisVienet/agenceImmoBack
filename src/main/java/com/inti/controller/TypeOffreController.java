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

import com.inti.entities.TypeOffre;
import com.inti.service.interfaces.ITypeOffreService;

@RestController
@CrossOrigin
public class TypeOffreController {
	@Autowired
	ITypeOffreService typeOffreService;
	
	@GetMapping("/typeOffres")
	public List<TypeOffre> findAll(){
		return typeOffreService.findAll();
	}
	
	@GetMapping("/typeOffres/{idTypeOffre}")
	public TypeOffre findOne(@PathVariable("idTypeOffre") Long idTypeOffre) {
		return typeOffreService.findOne(idTypeOffre);
	}
	
	@PostMapping("/typeOffres")
	public String saveTypeOffre(@RequestParam("typeBienFront") String typeBien, @RequestParam("typeContratFront") String typeContrat)
		{
		try {
			TypeOffre currentUser = new TypeOffre();
			currentUser.setTypeBien(typeBien);
			currentUser.setTypeContrat(typeContrat);
			typeOffreService.save(currentUser);
			return "File Uploaded successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Fail, maybe you had uploaded the file before";
		}
	}
	
	@DeleteMapping("/typeOffres/{idTypeOffre}")
	public void deleteTypeOffre(@PathVariable("idTypeOffre") Long idTypeOffre) {
		typeOffreService.delete(idTypeOffre);
	}
	
	@PutMapping("/typeOffres/{idTypeOffre}")
	public TypeOffre updateTypeOffreWithPut(@PathVariable("idTypeOffre") Long idTypeOffre, @RequestBody TypeOffre typeOffre) {
		TypeOffre currentUser = typeOffreService.findOne(idTypeOffre);
		System.out.println(currentUser.toString());
		currentUser.setTypeBien(typeOffre.getTypeBien());
		currentUser.setTypeContrat(typeOffre.getTypeContrat());
		return typeOffreService.save(currentUser);
	}
	
	@PatchMapping("/typeOffres/{idTypeOffre}")
	public TypeOffre updateTypeOffreWithPatch(@PathVariable("idTypeOffre") Long idTypeOffre, @RequestBody TypeOffre typeOffre) {
		TypeOffre currentUser = typeOffreService.findOne(idTypeOffre);
		currentUser.setTypeContrat(typeOffre.getTypeContrat());
		return typeOffreService.save(currentUser);
	}

}
