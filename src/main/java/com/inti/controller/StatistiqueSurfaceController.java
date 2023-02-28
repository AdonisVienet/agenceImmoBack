package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.service.interfaces.IUtilisateurService;

@RestController
public class StatistiqueSurfaceController {
	@Autowired
	IUtilisateurService utilisateurService; 

	@GetMapping("/surfaces")
	public int SurfaceMoyenneOffreParis(){
		return utilisateurService.surfaceMoyenneOffreParis();
	}
}