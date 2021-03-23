package com.dto;

import org.springframework.stereotype.Component;

public class Ville {

	private String nom;
	private String codePostal;
	
	public Ville(String nom,String codePostal) {
		this.setNom(nom);
		this.setCodePostal(codePostal);
	}
	

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

}
