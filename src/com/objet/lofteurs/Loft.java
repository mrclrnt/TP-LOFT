package com.objet.lofteurs;

import java.awt.Graphics;
import java.util.ArrayList;

public class Loft implements ObjetDessinable {

	private ZoneGraphique zone;
	private int h;
	private int w;
	private int maxEnergie;
	private int minEnergie;
	private ArrayList<ArrayList<Cellule>> listeCellules;
	private ArrayList<Neuneu> listeNeuneus;

	// Constructeur de Loft (taille et liste de cellules)
	public Loft(int taille, ZoneGraphique zone) {
		h = taille;
		w = taille;
		this.zone = zone;
		listeCellules = new ArrayList<ArrayList<Cellule>>();
		for (int i = 0; i < w; i++) {
			ArrayList<Cellule> e = new ArrayList<Cellule>();
			for (int j = 0; j < w; j++) {
				Cellule c = new Cellule(i, j);
				e.add(c);
			}
			listeCellules.add(e);
		}
	}

	public Cellule getCellule(int x, int y) {
		return listeCellules.get(x).get(y);
	}

	public void remplissageAleatoire(int quantiteNourriture) {
		int NourritureRestante=quantiteNourriture;
		while (NourritureRestante > 0) {
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					double x = Math.random();
					if (x>0.5){
						if (this.getCellule(i,j).getNourriture()==null) {
						double f = 0.25*Math.random();
						int quantiteCellule=(int)f*NourritureRestante;
						Nourriture PommeDansCellule = new Nourriture("Pomme",quantiteCellule,10);
						this.getCellule(i,j).setNourriture(PommeDansCellule);
						NourritureRestante=NourritureRestante-quantiteCellule;
						}
					}
				}
			}
		}

	}

	public int getMaxEnergie() {
		return maxEnergie;
	}

	public void setMaxEnergie(int maxEnergie) {
		this.maxEnergie = maxEnergie;
	}

	public void add(Neuneu neuneu) {

	}

	@Override
	public void dessinerObjet(Graphics g) {
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < w; j++) {
				this.getCellule(i, j).dessinerObjet(g);
			}
		}
	}

}
