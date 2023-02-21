package com.inti.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("terrain")
public class Terrain extends Offre implements Serializable {
	// Attributs
	private boolean constructibilite;
	private TypeTerrain typeTerrain;

	// Relation entre calsses

	// Constructeurs
	public Terrain() {
		super();
	}

	public Terrain(boolean constructibilite, TypeTerrain typeTerrain) {
		super();
		this.constructibilite = constructibilite;
		this.typeTerrain = typeTerrain;
	}
	// Getters & Setters

	public boolean isConstructibilite() {
		return constructibilite;
	}

	public void setConstructibilite(boolean constructibilite) {
		this.constructibilite = constructibilite;
	}

	public TypeTerrain getTypeTerrain() {
		return typeTerrain;
	}

	public void setTypeTerrain(TypeTerrain typeTerrain) {
		this.typeTerrain = typeTerrain;
	}

	// Methode toString
	@Override
	public String toString() {
		return super.toString() + "Terrain [constructibilite=" + constructibilite + ", typeTerrain=" + typeTerrain
				+ "]";
	}

}
