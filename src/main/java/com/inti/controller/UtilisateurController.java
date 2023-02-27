package com.inti.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
	@CrossOrigin
	public class UtilisateurController {
		@Autowired
		IUtilisateurService utilisateurService;
		@Autowired
		PasswordEncoder passwordEncoder;

		@GetMapping("/utilisateurs") // @RequestMapping(value="utilisateurs", method=RequestMethod.GET)
		public List<Utilisateur> findAll() {
			return utilisateurService.findAll();
		}

		@GetMapping("/utilisateurs/{idUtilisateur}") // @RequestMapping(value="/utilisateurs/{idUtilisateur}",
														// method=RequestMethod.GET)
		public Utilisateur findOne(@PathVariable("idUtilisateur") Long id) {
			return utilisateurService.findOne(id);
		}

		/*
		 * @PostMapping("/utilisateurs") // @RequestMapping(value="/utilisateurs",
		 * method=RequestMethod.POST) public Utilisateur saveUtilisateur(@RequestBody
		 * Utilisateur utilisateur) { return utilisateurService.save(utilisateur); }
		 */

		// Modification de la méthode save pour l'adapter à l'image
		
		@PostMapping("/utilisateurs") // @RequestMapping(value="utilisateurs",method=RequestMethod.POST)
		public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
			return utilisateurService.save(utilisateur);
		}
		
		/*@PostMapping("/utilisateurs")
		public String saveUtilisateur(@RequestParam("nomFront") String nom, @RequestParam("prenomFront") String prenom,
				@RequestParam("usernameFront") String username, @RequestParam("passwordFront") String password, @RequestParam("dateNaissanceFront") Date
				dateNaissance, @RequestParam("emailFront") String email, @RequestParam("numTelFront") int numTel)
			{
			try {
				Utilisateur currentUser = new Utilisateur();
				currentUser.setNomUtilisateur(nom);
				currentUser.setPrenomUtilisateur(prenom);
				currentUser.setUsername(username);
				currentUser.setPassword(password);
				currentUser.setDateNaissanceUtilisateur(dateNaissance);
				currentUser.setEmailUtilisateur(email);
				currentUser.setNumTelUtilisateur(numTel);
				utilisateurService.save(currentUser);
				return "File Uploaded successfully";
			} catch (Exception ex) {
				ex.printStackTrace();
				return "Fail, maybe you had uploaded the file before";
			}
		}*/

		@DeleteMapping("/utilisateurs/{idUtilisateur}") // @RequestMapping(value="/utilisateurs/{idUtilisateur}",
														// method=RequestMethod.DELETE)
		public void deleteUtilisateur(@PathVariable("idUtilisateur") Long id) {
			utilisateurService.delete(id);
		}

		@PutMapping("/utilisateurs/{idUtilisateur}") // http://localhost:9090/utilisateurs/2
		public Utilisateur updateUtilisateurWithPut(@PathVariable("idUtilisateur") Long id /* id = 2 */,
				@RequestBody Utilisateur utilisateur) { //
			Utilisateur currentUser = utilisateurService.findOne(id); // nom = ayari, prenom = oussama, username=ouss,
			System.out.println(currentUser.toString());
			currentUser.setNomUtilisateur(utilisateur.getNomUtilisateur()); // currentUser.setNomUtilisateur("Jean")
			currentUser.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur()); // //
			currentUser.setDateNaissanceUtilisateur(utilisateur.getDateNaissanceUtilisateur());
			currentUser.setEmailUtilisateur(utilisateur.getEmailUtilisateur());
			currentUser.setNumTelUtilisateur(utilisateur.getNumTelUtilisateur());
			currentUser.setUsername(utilisateur.getUsername());
			currentUser.setPassword(utilisateur.getPassword());
			return utilisateurService.save(currentUser);
		}

		@PatchMapping("/utilisateurs/{idUtilisateur}")
		public Utilisateur updateUtilisateurWithPatch(@PathVariable("idUtilisateur") Long id,
				@RequestBody Utilisateur utilisateur) {
			Utilisateur currentUser = utilisateurService.findOne(id);
			currentUser.setPassword(utilisateur.getPassword());
			return utilisateurService.save(currentUser);
		}
	}

