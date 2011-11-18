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

	/* *********************************************************************** */
	/* Methode permettant de repartir la nourriture sur l ensemble du plateau */
	/* *********************************************************************** */
	public void remplissageAleatoire(int quantiteNourriture,double Repartition) {
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
								System.out.println("Initialisation");
							}
							else {
								this.getCellule(i,j).getNourriture().setQuantite(this.getCellule(i,j).getNourriture().getQuantite() + quantiteCellule);
								System.out.println("Update de bouffe");
								System.out.println(quantiteCellule);
							}
							nourritureRestante=nourritureRestante-quantiteCellule;
							nourritureDeposee=quantiteCellule+nourritureDeposee;
							System.out.println("quantiteCellule : " + quantiteCellule + ",NourritureRestante : " + nourritureRestante +", Nourriture Deposee : " + nourritureDeposee);
							}
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
