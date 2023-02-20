package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Garage extends Offre implements Serializable {
	// Attributs
	private String verrouillageGarage;
	// Relation entre calsses

	// Constructeurs
	public Garage() {
		super();
	}

	public Garage(String verrouillageGarage) {
		super();
		this.verrouillageGarage = verrouillageGarage;
	}
	// Getters & Setters

	public String getVerrouillageGarage() {
		return verrouillageGarage;
	}

	public void setVerrouillageGarage(String verrouillageGarage) {
		this.verrouillageGarage = verrouillageGarage;
	}
	// Methode toString

	@Override
	public String toString() {
		return super.toString() + "Garage [verrouillageGarage=" + verrouillageGarage + "]";
	}

}
