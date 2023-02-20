package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avis implements Serializable {
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvis;
	private String titreAvis;
	private String descriptionAvis;

	// Relation entre calsses
	// ManyToOne Avis -> Offre
	@ManyToOne
	@JoinColumn(name = "id_offre")
	private Offre offreFK;

	// Constructeurs
	public Avis() {
	}

	public Avis(String titreAvis, String descriptionAvis, Offre offreFK) {
		this.titreAvis = titreAvis;
		this.descriptionAvis = descriptionAvis;
		this.offreFK = offreFK;
	}
	// Getters & Setters

	public Long getIdAvis() {
		return idAvis;
	}

	public void setIdAvis(Long idAvis) {
		this.idAvis = idAvis;
	}

	public String getTitreAvis() {
		return titreAvis;
	}

	public void setTitreAvis(String titreAvis) {
		this.titreAvis = titreAvis;
	}

	public String getDescriptionAvis() {
		return descriptionAvis;
	}

	public void setDescriptionAvis(String descriptionAvis) {
		this.descriptionAvis = descriptionAvis;
	}

	public Offre getOffreFK() {
		return offreFK;
	}

	public void setOffreFK(Offre offreFK) {
		this.offreFK = offreFK;
	}
	// Methode toString

	@Override
	public String toString() {
		return "Avis [idAvis=" + idAvis + ", titreAvis=" + titreAvis + ", descriptionAvis=" + descriptionAvis
				+ ", offreFK=" + offreFK + "]";
	}

}
