package com.inti.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class Garage extends Offre implements Serializable {
	// Attributs
	private String fermetureGarage;
	// Relation entre calsses

	// Constructeurs
	public Garage() {
		super();
	}

	public Garage(String fermetureGarage) {
		super();
		this.fermetureGarage = fermetureGarage;
	}
	// Getters & Setters

	public String getFermetureGarage() {
		return fermetureGarage;
	}

	public void setFermetureGarage(String fermetureGarage) {
		this.fermetureGarage = fermetureGarage;
	}
	// Methode toString

	@Override
	public String toString() {
		return super.toString() + "Garage [fermetureGarage=" + fermetureGarage + "]";
	}

}
