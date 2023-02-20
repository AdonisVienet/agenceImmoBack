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
import org.springframework.web.multipart.MultipartFile;

import com.inti.entities.EtatOffre;
import com.inti.entities.Offre;
import com.inti.service.interfaces.IOffreService;

@RestController
@CrossOrigin
public class OffreController {
	@Autowired
	IOffreService offreService;
	
	@GetMapping("/offres")
	public List<Offre> findAll(){
		return offreService.findAll();
	}
	
	@GetMapping("/offres/{idOffre}")
	public Offre findOne(@PathVariable("idOffre") Long idOffre) {
		return offreService.findOne(idOffre);
	}
	
	@PostMapping("/offres")
	public String saveOffre(@RequestParam("adresseFront") String adresse, @RequestParam("prixFront") float prix, @RequestParam("surfaceFront") float surface,
			@RequestParam("descriptionFront") String description, @RequestParam("imageFront") MultipartFile image, @RequestParam("disponibiliteFront") boolean disponibilite,
			@RequestParam("orientationFront") String orientation, @RequestParam("etatFront") EtatOffre etatOffre)
		{
		try {
			Offre currentUser = new Offre();
			currentUser.setAdresseOffre(adresse);
			currentUser.setPrixOffre(prix);
			currentUser.setSurfaceOffre(surface);
			currentUser.setDescription(description);
			currentUser.setImageOffre(image.getBytes());
			currentUser.setDisponibiliteOffre(disponibilite);
			currentUser.setOrientationOffre(orientation);
			currentUser.setEtatOffre(etatOffre);
			offreService.save(currentUser);
			return "File Uploaded successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Fail, maybe you had uploaded the file before";
		}
	}
	
	@DeleteMapping("/offres/{idOffre}")
	public void deleteOffre(@PathVariable("idOffre") Long idOffre) {
		offreService.delete(idOffre);
	}
	
	@PutMapping("/offres/{idOffre}")
	public Offre updateOffreWithPut(@PathVariable("idOffre") Long idOffre, @RequestBody Offre offre) {
		Offre currentUser = offreService.findOne(idOffre);
		System.out.println(currentUser.toString());
		currentUser.setAdresseOffre(offre.getAdresseOffre());
		currentUser.setPrixOffre(offre.getPrixOffre());
		currentUser.setSurfaceOffre(offre.getSurfaceOffre());
		currentUser.setDescription(offre.getDescription());
		currentUser.setImageOffre(offre.getImageOffre());
		currentUser.setDisponibiliteOffre(offre.isDisponibiliteOffre());
		currentUser.setOrientationOffre(offre.getOrientationOffre());
		currentUser.setEtatOffre(offre.getEtatOffre());
		return offreService.save(currentUser);
	}
	
	@PatchMapping("/offres/{idOffre}")
	public Offre updateOffreWithPatch(@PathVariable("idOffre") Long idOffre, @RequestBody Offre offre) {
		Offre currentUser = offreService.findOne(idOffre);
		currentUser.setImageOffre(offre.getImageOffre());
		return offreService.save(currentUser);
	}

}