package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Offre implements Serializable {
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOffre;
	private String adresseOffre;
	private float prixOffre;
	private float surfaceOffre;
	private String description;
	@Lob
	private byte[] imageOffre;
	private boolean disponibiliteOffre;

	// Relation entre calsses
	// ManyToMany Offre <-> Visite
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "OFFRES_VISITES", joinColumns = @JoinColumn(name = "id_offre", referencedColumnName = "idOffre"), inverseJoinColumns = @JoinColumn(name = "id_visite", referencedColumnName = "idVisite"))
	private Set<Visite> visites = new HashSet<>();

	// OneToMany Offre -> Avis
	@OneToMany(mappedBy = "offreFK")
	@Transient
	private List<Avis> avis = new ArrayList<>();
	// ManyToOne Offre -> Type Offre
	@ManyToOne
	@JoinColumn(name = "id_type_offre")
	private TypeOffre typeOffreFK;

	// Constructeurs
	public Offre() {
	}

	public Offre(String adresseOffre, float prixOffre, float surfaceOffre, String description, byte[] imageOffre,
			boolean disponibiliteOffre, Set<Visite> visites, List<Avis> avis, TypeOffre typeOffreFK) {
		this.adresseOffre = adresseOffre;
		this.prixOffre = prixOffre;
		this.surfaceOffre = surfaceOffre;
		this.description = description;
		this.imageOffre = imageOffre;
		this.disponibiliteOffre = disponibiliteOffre;
		this.visites = visites;
		this.avis = avis;
		this.typeOffreFK = typeOffreFK;
	}

	// Getters & Setters
	public Long getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(Long idOffre) {
		this.idOffre = idOffre;
	}

	public String getAdresseOffre() {
		return adresseOffre;
	}

	public void setAdresseOffre(String adresseOffre) {
		this.adresseOffre = adresseOffre;
	}

	public float getPrixOffre() {
		return prixOffre;
	}

	public void setPrixOffre(float prixOffre) {
		this.prixOffre = prixOffre;
	}

	public float getSurfaceOffre() {
		return surfaceOffre;
	}

	public void setSurfaceOffre(float surfaceOffre) {
		this.surfaceOffre = surfaceOffre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImageOffre() {
		return imageOffre;
	}

	public void setImageOffre(byte[] imageOffre) {
		this.imageOffre = imageOffre;
	}

	public boolean isDisponibiliteOffre() {
		return disponibiliteOffre;
	}

	public void setDisponibiliteOffre(boolean disponibiliteOffre) {
		this.disponibiliteOffre = disponibiliteOffre;
	}

	public Set<Visite> getVisites() {
		return visites;
	}

	public void setVisites(Set<Visite> visites) {
		this.visites = visites;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public TypeOffre getTypeOffreFK() {
		return typeOffreFK;
	}

	public void setTypeOffreFK(TypeOffre typeOffreFK) {
		this.typeOffreFK = typeOffreFK;
	}

	// Methode toString
	@Override
	public String toString() {
		return "Offre [idOffre=" + idOffre + ", adresseOffre=" + adresseOffre + ", prixOffre=" + prixOffre
				+ ", surfaceOffre=" + surfaceOffre + ", description=" + description + ", imageOffre="
				+ Arrays.toString(imageOffre) + ", disponibiliteOffre=" + disponibiliteOffre + ", visites=" + visites
				+ ", avis=" + avis + ", typeOffreFK=" + typeOffreFK + "]";
	}
}
