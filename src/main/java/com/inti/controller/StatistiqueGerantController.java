package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.service.interfaces.IUtilisateurService;

@RestController
public class StatistiqueGerantController {

		@Autowired
		IUtilisateurService utilisateurService; 

		@GetMapping("/gerants")
		public int nombreGerant(){
			return utilisateurService.nombreGerant();
		}
	}
