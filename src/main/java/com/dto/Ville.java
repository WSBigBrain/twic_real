package com.dto;


import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nom", "codePostal", "codeInsee", "libelle", "ligne5", "coordonnees" })
@Generated("jsonschema2pojo")
public class Ville {

	@JsonProperty("nom")
	private String nom;
	@JsonProperty("codePostal")
	private String codePostal;
	@JsonProperty("codeInsee")
	private String codeInsee;
	@JsonProperty("libelle")
	private String libelle;
	@JsonProperty("ligne5")
	private String ligne5;
	@JsonProperty("coordonnees")
	private Coordonnees coordonnees;
	public Ville() {	
		super();
	}
	public Ville(String nom,String codePostal,Coordonnees coords,String codeInsee,String libelle,String ligne5) {
		super();
		this.setNom(nom);
		this.setCodePostal(codePostal);
		this.setCoordonnees(coords);
		this.setCodeInsee(codeInsee);
		this.setLibelle(libelle);
		this.setLigne5(ligne5);
		
	}
	@JsonProperty("nom")
	public String getNom() {
		return nom;
	}

	@JsonProperty("nom")
	public void setNom(String nom) {
		this.nom = nom;
	}

	@JsonProperty("codePostal")
	public String getCodePostal() {
		return codePostal;
	}

	@JsonProperty("codePostal")
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@JsonProperty("codeInsee")
	public String getCodeInsee() {
		return codeInsee;
	}

	@JsonProperty("codeInsee")
	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}

	@JsonProperty("libelle")
	public String getLibelle() {
		return libelle;
	}

	@JsonProperty("libelle")
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@JsonProperty("ligne5")
	public String getLigne5() {
		return ligne5;
	}

	@JsonProperty("ligne5")
	public void setLigne5(String ligne5) {
		this.ligne5 = ligne5;
	}

	@JsonProperty("coordonnees")
	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	@JsonProperty("coordonnees")
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

}
