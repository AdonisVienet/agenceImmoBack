package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Utilisateur;

public interface IUtilisateurService {
	List<Utilisateur> findAll();

	Utilisateur findOne(Long id);

	Utilisateur save(Utilisateur utilisateur);

	void delete(Long id);

	Utilisateur findByUsername(String username);

	// Afficher le nombre d'utilisateurs
	int nombreUtilisateur();

	// Afficher le nombre de client
	int nombreClient();

	// Afficher le nombre de gérants
	int nombreGerant();

	// Afficher le prix total des offres à Paris
	int totalPrixOffreParis();

	// Afficher la surface moyenne des offres à Paris
	int surfaceMoyenneOffreParis();
}