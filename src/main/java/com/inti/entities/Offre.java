package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
public class Offre implements Serializable {
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOffre;
	private String adresseOffre;
	private String ville;
	private float prixOffre;
	private float surfaceOffre;
	private String description;
	@Lob
	private byte[] imageOffre;
	private boolean disponibiliteOffre;
	private String orientationOffre;
	@Enumerated(EnumType.STRING)
	private EtatOffre etatOffre;
	private String typeOffre;
	
	// Relation entre calsses
	// ManyToMany Offre <-> Visite
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "OFFRES_VISITES", joinColumns = @JoinColumn(name = "id_offre", referencedColumnName = "idOffre"), inverseJoinColumns = @JoinColumn(name = "id_visite", referencedColumnName = "idVisite"))
	private Set<Visite> visites = new HashSet<>();

	// OneToMany Offre -> Avis
	@OneToMany(mappedBy = "offreFK")
	@Transient
	private List<Avis> avis = new ArrayList<>();

	// Constructeurs
	public Offre() {
	}

	public Offre(String adresseOffre, String ville, float prixOffre, float surfaceOffre, String description, byte[] imageOffre,
			boolean disponibiliteOffre, String orientationOffre, EtatOffre etatOffre, Set<Visite> visites,
			List<Avis> avis, String typeOffre){
		this.adresseOffre = adresseOffre;
		this.ville = ville;
		this.prixOffre = prixOffre;
		this.surfaceOffre = surfaceOffre;
		this.description = description;
		this.imageOffre = imageOffre;
		this.disponibiliteOffre = disponibiliteOffre;
		this.orientationOffre = orientationOffre;
		this.etatOffre = etatOffre;
		this.visites = visites;
		this.avis = avis;
		this.typeOffre = typeOffre;
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


	public String getOrientationOffre() {
		return orientationOffre;
	}

	public void setOrientationOffre(String orientationOffre) {
		this.orientationOffre = orientationOffre;
	}

	public EtatOffre getEtatOffre() {
		return etatOffre;
	}

	public void setEtatOffre(EtatOffre etatOffre) {
		this.etatOffre = etatOffre;
	}
	
	

	public String getTypeOffre() {
		return typeOffre;
	}

	public void setTypeOffre(String typeOffre) {
		this.typeOffre = typeOffre;
	}
	
	

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Offre [idOffre=" + idOffre + ", adresseOffre=" + adresseOffre + ", ville=" + ville + ", prixOffre="
				+ prixOffre + ", surfaceOffre=" + surfaceOffre + ", description=" + description + ", imageOffre="
				+ Arrays.toString(imageOffre) + ", disponibiliteOffre=" + disponibiliteOffre + ", orientationOffre="
				+ orientationOffre + ", etatOffre=" + etatOffre + ", typeOffre=" + typeOffre + ", visites=" + visites
				+ ", avis=" + avis + "]";
	}


	

}
