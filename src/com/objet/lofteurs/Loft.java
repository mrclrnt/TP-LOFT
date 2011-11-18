package com.objet.lofteurs;

import java.util.ArrayList;

public class Loft {

	private ZoneGraphique zone;
	private int h;
	private int w;
	private int maxEnergie;
	private int minEnergie;
	private ArrayList<ArrayList<Cellule>> listeCellules;
	private ArrayList<Neuneu> listeNeuneus;
	

	//Constructeur de Loft (taille et liste de cellules)
	public Loft(int taille, ZoneGraphique zone){
		h=taille;
		w=taille;
		this.zone=zone;
		listeCellules = new ArrayList<ArrayList<Cellule>>();
		for(int i=0;i<w;i++){
			ArrayList<Cellule> e = new ArrayList<Cellule>();
			for(int j=0;j<w;j++){
				Cellule c= new Cellule(i,j);
				e.add(c);
			}
			listeCellules.add(e);
		}
	}
	
	public void remplissageAleatoire(float f){
		
	}

	public int getMaxEnergie() {
		return maxEnergie;
	}

	public void setMaxEnergie(int maxEnergie) {
		this.maxEnergie = maxEnergie;
	}
	
	public void add(Neuneu neuneu){
		if (listeNeuneus)
		
	}
}
