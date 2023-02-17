package com.inti.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Appartement extends Offre implements Serializable {
	// Attributs
	private int etageAppartement;
	private int nbrPieceAppartement;
	// Relation entre calsses

	// Constructeurs
	public Appartement() {
		super();
	}

	public Appartement(int etageAppartement, int nbrPieceAppartement) {
		super();
		this.etageAppartement = etageAppartement;
		this.nbrPieceAppartement = nbrPieceAppartement;
	}
	// Getters & Setters

	public int getEtageAppartement() {
		return etageAppartement;
	}

	public void setEtageAppartement(int etageAppartement) {
		this.etageAppartement = etageAppartement;
	}

	public int getNbrPieceAppartement() {
		return nbrPieceAppartement;
	}

	public void setNbrPieceAppartement(int nbrPieceAppartement) {
		this.nbrPieceAppartement = nbrPieceAppartement;
	}
	// Methode toString

	@Override
	public String toString() {
		return super.toString() + "Appartement [etageAppartement=" + etageAppartement + ", nbrPieceAppartement="
				+ nbrPieceAppartement + "]";
	}

}
