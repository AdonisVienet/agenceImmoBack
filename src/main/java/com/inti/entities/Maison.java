package com.inti.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class Maison extends Offre implements Serializable {
	// Attributs
	private int nbrPieceMaison;
	// Relation entre calsses

	// Constructeurs
	public Maison() {
		super();
	}

	public Maison(int nbrPieceMaison) {
		super();
		this.nbrPieceMaison = nbrPieceMaison;
	}
	// Getters & Setters

	public int getNbrPieceMaison() {
		return nbrPieceMaison;
	}

	public void setNbrPieceMaison(int nbrPieceMaison) {
		this.nbrPieceMaison = nbrPieceMaison;
	}
	// Methode toString

	@Override
	public String toString() {
		return super.toString() + "Maison [nbrPieceMaison=" + nbrPieceMaison + "]";
	}

}
