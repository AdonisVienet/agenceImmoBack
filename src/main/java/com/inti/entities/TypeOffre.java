package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class TypeOffre implements Serializable {
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTypeOffre;
	private String TypeBien;
	private String TypeContrat;
	// Relation entre calsses
	// OneToMany TypeOffre -> Offre
	@OneToMany(mappedBy = "typeOffreFK")
	@Transient
	private List<Offre> offres = new ArrayList<>();

	// Constructeurs
	public TypeOffre() {
	}

	public TypeOffre(String typeBien, String typeContrat, List<Offre> offres) {
		TypeBien = typeBien;
		TypeContrat = typeContrat;
		this.offres = offres;
	}

	// Getters & Setters
	public Long getIdTypeOffre() {
		return idTypeOffre;
	}

	public void setIdTypeOffre(Long idTypeOffre) {
		this.idTypeOffre = idTypeOffre;
	}

	public String getTypeBien() {
		return TypeBien;
	}

	public void setTypeBien(String typeBien) {
		TypeBien = typeBien;
	}

	public String getTypeContrat() {
		return TypeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		TypeContrat = typeContrat;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	// Methode toString
	@Override
	public String toString() {
		return "TypeOffre [idTypeOffre=" + idTypeOffre + ", TypeBien=" + TypeBien + ", TypeContrat=" + TypeContrat
				+ ", offres=" + offres + "]";
	}

}
