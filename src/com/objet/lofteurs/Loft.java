package com.objet.lofteurs;

import java.awt.Graphics;
import java.util.ArrayList;

public class Loft implements ObjetDessinable {

	private ZoneGraphique zone;
	private int h;
	private int w;
	private int maxEnergie=500;
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
		listeNeuneus = new ArrayList<Neuneu>();
	}

	public Cellule getCellule(int x, int y) {
		return listeCellules.get(x).get(y);
	}

	/* *********************************************************************** */
	/* Methode permettant de repartir la nourriture sur l ensemble du plateau */
	/* *********************************************************************** */
	public void remplissageAleatoireNourriture(int quantiteNourriture,double Repartition) {
		int nourritureDeposee=0;
		int nourritureRestante=quantiteNourriture;
		while ((nourritureDeposee < quantiteNourriture) && (nourritureRestante>0)) {
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if ((nourritureDeposee < quantiteNourriture) && (nourritureRestante>0)) {
					double x = Math.random();
					if (x>0.5){					// Une chance sur deux d'envisager ou non de mettre de la nourriture
						int quantiteCellule = (int)(Repartition*quantiteNourriture*(Math.random()));
						if (quantiteCellule+nourritureDeposee<=quantiteNourriture) {
							if (this.getCellule(i,j).getNourriture()==null) {
								Nourriture PommeDansCellule = new Nourriture("Pommes",quantiteCellule,10);
								this.getCellule(i,j).setNourriture(PommeDansCellule);
							}
							else {
								this.getCellule(i,j).getNourriture().setQuantite(this.getCellule(i,j).getNourriture().getQuantite() + quantiteCellule);
							}
							nourritureRestante=nourritureRestante-quantiteCellule;
							nourritureDeposee=quantiteCellule+nourritureDeposee;
							}
						}
					}
				}
			}
		}
	}
	
	/* *********************************************************************** */
	/* Methode permettant de repartir les Neuneus sur l ensemble du plateau */
	/* *********************************************************************** */
	public void remplissageAleatoireNeuneus(int nombreLofteurs) {
		for (int i=0; i<nombreLofteurs;i++){
			//Choisir une cellule vide pour y placer le neuneu
			int xPosition = (int)(w*(Math.random()));
			int yPosition = (int)(h*(Math.random()));
			while(this.getCellule(xPosition, yPosition).getNeuneu() != null){
				xPosition = (int)(w*(Math.random()));
				yPosition = (int)(h*(Math.random()));
			}
			//placer le neuneu
			this.getCellule(xPosition, yPosition).setNeuneu(new Neuneu(this,xPosition,yPosition));
		}
	}
		
	public int getMaxEnergie() {
		return maxEnergie;
	}

	public void setMaxEnergie(int maxEnergie) {
		this.maxEnergie = maxEnergie;
	}

	public ArrayList<Neuneu> getListeNeuneus() {
		return listeNeuneus;
	}

	public void setListeNeuneus(ArrayList<Neuneu> listeNeuneus) {
		this.listeNeuneus = listeNeuneus;
	}

	public void add(Neuneu neuneu) {
		this.getListeNeuneus().add(neuneu);
	}

	@Override
	public void dessinerObjet(Graphics g) {
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < w; j++) {
				this.getCellule(i, j).dessinerObjet(g);
			}
		}
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

}
