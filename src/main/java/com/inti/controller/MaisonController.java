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

import com.inti.entities.Maison;
import com.inti.service.interfaces.IMaisonService;

@RestController
@CrossOrigin
public class MaisonController {
	@Autowired
	IMaisonService maisonService;
	
	@GetMapping("/maisons")
	public List<Maison> findAll(){
		return maisonService.findAll();
	}
	
	@GetMapping("/maisons/{idOffre}")
	public Maison findOne(@PathVariable("idOffre") Long idOffre) {
		return maisonService.findOne(idOffre);
	}
	
	@PostMapping("/maisons")
	public String saveMaison(@RequestParam("nbrPieceFront") int nbPiece, @RequestParam("garageMaisonFront") float garageMaison,
			@RequestParam("jardinMaisonFront") float jardinMaison, @RequestParam("chemineeFront") boolean cheminee)
		{
		try {
			Maison currentUser = new Maison();
			currentUser.setNbrPieceMaison(nbPiece);
			currentUser.setGarageMaison(garageMaison);
			currentUser.setJardinMaison(jardinMaison);
			currentUser.setChemineeMaison(cheminee);
			maisonService.save(currentUser);
			return "File Uploaded successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Fail, maybe you had uploaded the file before";
		}
	}
	
	@DeleteMapping("/maisons/{idOffre}")
	public void deleteMaison(@PathVariable("idOffre") Long idOffre) {
		maisonService.delete(idOffre);
	}
	
	@PutMapping("/maisons/{idOffre}")
	public Maison updateMaisonWithPut(@PathVariable("idOffre") Long idOffre, @RequestBody Maison maison) {
		Maison currentUser = maisonService.findOne(idOffre);
		System.out.println(currentUser.toString());
		currentUser.setGarageMaison(maison.getGarageMaison());
		currentUser.setNbrPieceMaison(maison.getNbrPieceMaison());
		currentUser.setJardinMaison(maison.getJardinMaison());
		currentUser.setChemineeMaison(maison.isChemineeMaison());
		return maisonService.save(currentUser);
	}
	
	@PatchMapping("/maisons/{idOffre}")
	public Maison updateMaisonWithPatch(@PathVariable("idOffre") Long idOffre, @RequestBody Maison maison) {
		Maison currentUser = maisonService.findOne(idOffre);
		currentUser.setJardinMaison(maison.getJardinMaison());
		return maisonService.save(currentUser);
	}

}
