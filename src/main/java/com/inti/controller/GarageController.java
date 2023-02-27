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

import com.inti.entities.Garage;
import com.inti.service.interfaces.IGarageService;

@RestController
@CrossOrigin
public class GarageController {
	@Autowired
	IGarageService garageService;
	
	@GetMapping("/garages")
	public List<Garage> findAll(){
		return garageService.findAll();
	}
	
	@GetMapping("/garages/{idOffre}")
	public Garage findOne(@PathVariable("idOffre") Long idOffre) {
		return garageService.findOne(idOffre);
	}
	
	@PostMapping("/garages")
	public String saveGarage(@RequestParam("verrouillageGarageFront") String verrouillageGarage)
		{
		try {
			Garage currentUser = new Garage();
			currentUser.setVerrouillageGarage(verrouillageGarage);
			garageService.save(currentUser);
			return "File Uploaded successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Fail, maybe you had uploaded the file before";
		}
	}
	
	@DeleteMapping("/garages/{idOffre}")
	public void deleteGarage(@PathVariable("idOffre") Long idOffre) {
		garageService.delete(idOffre);
	}
	
	@PutMapping("/garages/{idOffre}")
	public Garage updateGarageWithPut(@PathVariable("idOffre") Long idOffre, @RequestBody Garage garage) {
		Garage currentUser = garageService.findOne(idOffre);
		System.out.println(currentUser.toString());
		currentUser.setVerrouillageGarage(garage.getVerrouillageGarage());
		return garageService.save(currentUser);
	}
	
	@PatchMapping("/garages/{idOffre}")
	public Garage updateGarageWithPatch(@PathVariable("idOffre") Long idOffre, @RequestBody Garage garage) {
		Garage currentUser = garageService.findOne(idOffre);
		currentUser.setVerrouillageGarage(garage.getVerrouillageGarage());
		return garageService.save(currentUser);
	}

}