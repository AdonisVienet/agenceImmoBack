package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	Utilisateur findByUsername(String username);

	// Afficher le nombre d'utilisateur :
	@Query(value = "select count(*) from utilisateurs", nativeQuery = true)
	int nombreUtilisateur();

	// Afficher le nombre de client :
	@Query(value = "select count(*) from profils where id_role = 3 ", nativeQuery = true)
	int nombreClient();

	// Afficher le nombre de gérant :
	@Query(value = "select count(*) from profils where id_role = 2 ", nativeQuery = true)
	int nombreGerant();

	// Afficher le prix total cumulé des offres de Paris :
	@Query(value = "select sum(prix_offre) from offre where ville = 'Paris'", nativeQuery = true)
	int totalPrixOffreParis();

	// Afficher la surface moyenne des offres de Paris :
	@Query(value = "select avg(surface_offre) from offre where ville = 'Paris'", nativeQuery = true)
	int surfaceMoyenneOffreParis();

}
