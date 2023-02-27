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

import com.inti.entities.Appartement;
import com.inti.entities.Appartement;
import com.inti.service.interfaces.IAppartementService;

@RestController
@CrossOrigin
public class AppartementController {
	@Autowired
	IAppartementService appartementService;
	
	@GetMapping("/appartements")
	public List<Appartement> findAll(){
		return appartementService.findAll();
	}
	
	@GetMapping("/appartements/{idOffre}")
	public Appartement findOne(@PathVariable("idOffre") Long idOffre) {
		return appartementService.findOne(idOffre);
	}
	
	@PostMapping("/appartements")
	public String saveAppartement(@RequestParam("etageFront") int etage, @RequestParam("nbPieceFront") int nbPiece,
			@RequestParam("exterieurFront") boolean exterieur)
		{
		try {
			Appartement currentUser = new Appartement();
			currentUser.setEtageAppartement(etage);
			currentUser.setNbrPieceAppartement(nbPiece);
			currentUser.setExterieurAppartement(exterieur);
			appartementService.save(currentUser);
			return "File Uploaded successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Fail, maybe you had uploaded the file before";
		}
	}
	
	@DeleteMapping("/appartements/{idOffre}")
	public void deleteAppartement(@PathVariable("idOffre") Long idOffre) {
		appartementService.delete(idOffre);
	}
	
	@PutMapping("/appartements/{idOffre}")
	public Appartement updateAppartementWithPut(@PathVariable("idOffre") Long idOffre, @RequestBody Appartement appartement) {
		Appartement currentUser = appartementService.findOne(idOffre);
		System.out.println(currentUser.toString());
		currentUser.setEtageAppartement(appartement.getEtageAppartement());
		currentUser.setNbrPieceAppartement(appartement.getNbrPieceAppartement());
		currentUser.setExterieurAppartement(appartement.isExterieurAppartement());
		return appartementService.save(currentUser);
	}
	
	@PatchMapping("/appartements/{idOffre}")
	public Appartement updateAppartementWithPatch(@PathVariable("idOffre") Long idOffre, @RequestBody Appartement appartement) {
		Appartement currentUser = appartementService.findOne(idOffre);
		currentUser.setExterieurAppartement(appartement.isExterieurAppartement());
		return appartementService.save(currentUser);
	}

}
