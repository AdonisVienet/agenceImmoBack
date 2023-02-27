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

import com.inti.entities.Terrain;
import com.inti.entities.TypeTerrain;
import com.inti.service.interfaces.ITerrainService;

@RestController
@CrossOrigin
public class TerrainController {
	@Autowired
	ITerrainService terrainService;
	
	@GetMapping("/terrains")
	public List<Terrain> findAll(){
		return terrainService.findAll();
	}
	
	@GetMapping("/terrains/{idOffre}")
	public Terrain findOne(@PathVariable("idOffre") Long idOffre) {
		return terrainService.findOne(idOffre);
	}
	
	@PostMapping("/terrains")
	public String saveTerrain(@RequestParam("constructibiliteFront") boolean constructibilite, @RequestParam("typeTerrainFront") TypeTerrain typeTerrain)
		{
		try {
			Terrain currentUser = new Terrain();
			currentUser.setConstructibilite(constructibilite);
			currentUser.setTypeTerrain(typeTerrain);
			terrainService.save(currentUser);
			return "File Uploaded successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Fail, maybe you had uploaded the file before";
		}
	}
	
	@DeleteMapping("/terrains/{idOffre}")
	public void deleteTerrain(@PathVariable("idOffre") Long idOffre) {
		terrainService.delete(idOffre);
	}
	
	@PutMapping("/terrains/{idOffre}")
	public Terrain updateTerrainWithPut(@PathVariable("idOffre") Long idOffre, @RequestBody Terrain terrain) {
		Terrain currentUser = terrainService.findOne(idOffre);
		System.out.println(currentUser.toString());
		currentUser.setConstructibilite(terrain.isConstructibilite());
		currentUser.setTypeTerrain(terrain.getTypeTerrain());
		return terrainService.save(currentUser);
	}
	
	@PatchMapping("/terrains/{idOffre}")
	public Terrain updateTerrainWithPatch(@PathVariable("idOffre") Long idOffre, @RequestBody Terrain terrain) {
		Terrain currentUser = terrainService.findOne(idOffre);
		currentUser.setTypeTerrain(terrain.getTypeTerrain());
		return terrainService.save(currentUser);
	}

}
