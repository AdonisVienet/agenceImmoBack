package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Maison extends Offre implements Serializable {
	// Attributs
	private int nbrPieceMaison;
	private float garageMaison;
	private float jardinMaison;
	private boolean chemineeMaison;

	// Relation entre calsses

	// Constructeurs
	public Maison() {
		super();
	}

	public Maison(int nbrPieceMaison, float garageMaison, float jardinMaison, boolean chemineeMaison) {
		super();
		this.nbrPieceMaison = nbrPieceMaison;
		this.garageMaison = garageMaison;
		this.jardinMaison = jardinMaison;
		this.chemineeMaison = chemineeMaison;
	}

	// Getters & Setters

	public int getNbrPieceMaison() {
		return nbrPieceMaison;
	}

	public void setNbrPieceMaison(int nbrPieceMaison) {
		this.nbrPieceMaison = nbrPieceMaison;
	}

	// Methode toString

	public float getGarageMaison() {
		return garageMaison;
	}

	public void setGarageMaison(float garageMaison) {
		this.garageMaison = garageMaison;
	}

	public float getJardinMaison() {
		return jardinMaison;
	}

	public void setJardinMaison(float jardinMaison) {
		this.jardinMaison = jardinMaison;
	}

	public boolean isChemineeMaison() {
		return chemineeMaison;
	}

	public void setChemineeMaison(boolean chemineeMaison) {
		this.chemineeMaison = chemineeMaison;
	}

	@Override
	public String toString() {
		return super.toString() + "Maison [nbrPieceMaison=" + nbrPieceMaison + ", garageMaison=" + garageMaison
				+ ", jardinMaison=" + jardinMaison + ", chemineeMaison=" + chemineeMaison + "]";
	}

}
