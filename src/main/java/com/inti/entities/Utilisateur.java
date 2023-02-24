package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.OneToMany;
import javax.persistence.Transient;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UTILISATEURS", schema = "gestion_agence_immo")
public class Utilisateur implements Serializable{
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	@Column(unique = true)
	private String emailUtilisateur;
	@Temporal(TemporalType.DATE)
	private Date dateNaissanceUtilisateur;
	private int numTelUtilisateur;
	@Column(unique = true)
	private String username;
	private String password;

	// Relation entre calsses
	// ManyToMany Utilisateur <-> Role
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PROFILS", joinColumns = @JoinColumn(name = "id_utilisateur", referencedColumnName = "idUtilisateur"), inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole"))
	private Set<Role> roles = new HashSet<>();

	// OneToMany Utilisateur -> Question
	@OneToMany(mappedBy = "utilisateurFK")
	@Transient
	private List<Question> questions = new ArrayList<>();

	// OneToMany Utilisateur -> Avis
	@OneToMany(mappedBy = "utilisateurFK")
	@Transient
	private List<Avis> aviss = new ArrayList<>();

	// ManyToMany Utilisateur <-> Offre
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "UTILISATEURS_OFFRES", joinColumns = @JoinColumn(name = "id_utilisateur", referencedColumnName = "idUtilisateur"), inverseJoinColumns = @JoinColumn(name = "id_offre", referencedColumnName = "idOffre"))
	private Set<Offre> offres = new HashSet<>();

	// Constructeurs
	public Utilisateur() {
	}

	public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur,
			Date dateNaissanceUtilisateur, int numTelUtilisateur, String username, String password, Set<Role> roles,
			List<Question> questions, List<Avis> aviss, Set<Offre> offres) {
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.emailUtilisateur = emailUtilisateur;
		this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
		this.numTelUtilisateur = numTelUtilisateur;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.questions = questions;
		this.aviss = aviss;
		this.offres = offres;
	}
	// Getters & Setters

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}

	public Date getDateNaissanceUtilisateur() {
		return dateNaissanceUtilisateur;
	}

	public void setDateNaissanceUtilisateur(Date dateNaissanceUtilisateur) {
		this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
	}

	public int getNumTelUtilisateur() {
		return numTelUtilisateur;
	}

	public void setNumTelUtilisateur(int numTelUtilisateur) {
		this.numTelUtilisateur = numTelUtilisateur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Avis> getAviss() {
		return aviss;
	}

	public void setAviss(List<Avis> aviss) {
		this.aviss = aviss;
	}

	public Set<Offre> getOffres() {
		return offres;
	}

	public void setOffres(Set<Offre> offres) {
		this.offres = offres;
	}
	
	// Methode toString
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", emailUtilisateur=" + emailUtilisateur
				+ ", dateNaissanceUtilisateur=" + dateNaissanceUtilisateur + ", numTelUtilisateur=" + numTelUtilisateur
				+ ", username=" + username + ", password=" + password + ", roles=" + roles + ", questions=" + questions
				+ ", aviss=" + aviss + ", offres=" + offres + "]";
	}

}
