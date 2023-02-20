package com.inti.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Visite implements Serializable {
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVisite;
	private String descriptionVisite;
	@Temporal(TemporalType.DATE)
	private Date dateVisite;

	// @Temporal(TemporalType.DATE)
	// private Date disponibiliteVisite;

	// Relation entre calsses

	// Constructeurs
	public Visite() {
	}

	public Visite(String descriptionVisite, Date dateVisite) {
		this.descriptionVisite = descriptionVisite;
		this.dateVisite = dateVisite;
	}
	// Getters & Setters

	public Long getIdVisite() {
		return idVisite;
	}

	public void setIdVisite(Long idVisite) {
		this.idVisite = idVisite;
	}

	public String getDescriptionVisite() {
		return descriptionVisite;
	}

	public void setDescriptionVisite(String descriptionVisite) {
		this.descriptionVisite = descriptionVisite;
	}

	public Date getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}
	// Methode toString

	@Override
	public String toString() {
		return "Visite [idVisite=" + idVisite + ", descriptionVisite=" + descriptionVisite + ", dateVisite="
				+ dateVisite + "]";
	}
}
