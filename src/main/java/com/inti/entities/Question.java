package com.inti.entities;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question implements Serializable {
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idQuestion;
	private String objetQuestion;
	private String descriptionQuestion;

	// Relation entre calsses
	// ManyToOne Question -> Utilisateur
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateurFK;

	// Constructeurs
	public Question() {
	}

	public Question(String objetQuestion, String descriptionQuestion, Utilisateur utilisateurFK) {
		this.objetQuestion = objetQuestion;
		this.descriptionQuestion = descriptionQuestion;
		this.utilisateurFK = utilisateurFK;
	}

	// Getters & Setters
	public Long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getObjetQuestion() {
		return objetQuestion;
	}

	public void setObjetQuestion(String objetQuestion) {
		this.objetQuestion = objetQuestion;
	}

	public String getDescriptionQuestion() {
		return descriptionQuestion;
	}

	public void setDescriptionQuestion(String descriptionQuestion) {
		this.descriptionQuestion = descriptionQuestion;
	}

	public Utilisateur getUtilisateurFK() {
		return utilisateurFK;
	}

	public void setUtilisateurFK(Utilisateur utilisateurFK) {
		this.utilisateurFK = utilisateurFK;
	}

	// Methode toString
	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", objetQuestion=" + objetQuestion + ", descriptionQuestion="
				+ descriptionQuestion + ", utilisateurFK=" + utilisateurFK + "]";
	}
}