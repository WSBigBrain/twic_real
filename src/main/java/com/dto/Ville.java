package com.dto;

import org.springframework.stereotype.Component;
@Component
public class Ville {

	private String nom;
	
	public Ville(String nom) {
		this.setNom(nom);
	}
	

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
