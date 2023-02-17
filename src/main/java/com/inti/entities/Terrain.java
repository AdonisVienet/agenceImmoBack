package com.inti.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class Terrain extends Offre implements Serializable {
	// Attributs
	private boolean constructibilite;
	// Relation entre calsses

	// Constructeurs
	public Terrain() {
		super();
				}

	public Terrain(boolean constructibilite) {
		super();
		this.constructibilite = constructibilite;
	}
	// Getters & Setters

	public boolean isConstructibilite() {
		return constructibilite;
	}

	public void setConstructibilite(boolean constructibilite) {
		this.constructibilite = constructibilite;
	}
	// Methode toString
	@Override
	public String toString() {
		return super.toString() + "Terrain [constructibilite=" + constructibilite + "]";
	}
}
