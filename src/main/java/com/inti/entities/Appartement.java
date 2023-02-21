package com.inti.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("appartement")
public class Appartement extends Offre implements Serializable {
	// Attributs
	private int etageAppartement;
	private int nbrPieceAppartement;
	private boolean exterieurAppartement;
	// Relation entre calsses

	// Constructeurs
	public Appartement() {
		super();
	}

	public Appartement(int etageAppartement, int nbrPieceAppartement, boolean exterieurAppartement) {
		super();
		this.etageAppartement = etageAppartement;
		this.nbrPieceAppartement = nbrPieceAppartement;
		this.exterieurAppartement = exterieurAppartement;
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

	public boolean isExterieurAppartement() {
		return exterieurAppartement;
	}

	public void setExterieurAppartement(boolean exterieurAppartement) {
		this.exterieurAppartement = exterieurAppartement;
	}

	// Methode toString
	
	@Override
	public String toString() {
		return super.toString() +  "Appartement [etageAppartement=" + etageAppartement + ", nbrPieceAppartement=" + nbrPieceAppartement
				+ ", exterieurAppartement=" + exterieurAppartement + "]";
	}

}
