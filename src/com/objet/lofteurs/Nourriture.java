package com.objet.lofteurs;

import java.io.File;

public class Nourriture {
	protected String nom;
	protected int quantite;
	protected int energie;
	
	public Nourriture(String nom, int quantite, int energie) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.energie = energie;
	}

	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getEnergie() {
		return energie;
	}
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNourriturePath(){
		String path = new String();
		if(this.nom=="Pommes"){
			path = new File("pomme.png").getName();
		}
		return path;
	}

}
