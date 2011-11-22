package com.objet.lofteurs;

import java.io.File;

public class Neuneu {
	protected Loft loft;
	protected int energie;
	protected String sexe;
	protected Cellule celluleCourante;
	
	public Neuneu(Loft loft,int x,int y) {
		this.setLoft(loft);
		this.setCelluleCourante(this.loft.getCellule(x,y));
		this.loft.getCellule(x,y).setNeuneu(this);
		int Energie = Saison1.initEnergie;
		this.setEnergie(Energie);
		this.setSexe();
	}
	
	public void action() {
		//Si la cellule contient de la nourriture et si le Neuneu est mort de faim
		if(this.getCelluleCourante().getNourriture() != null && this.getEnergie()<Saison1.initEnergie){
			this.manger();
			System.out.println(this + " mange car mort de faim");
		}
		//Si la cellule contient de la nourriture et si le neuneu n'est pas rassasié
		else if(this.getCelluleCourante().getNourriture() != null && this.getEnergie()<Saison1.maxEnergie){
			int k = (int)(2*(Math.random())+1);
			switch (k) {
				case (1) : this.marcher();
				System.out.println(this + " marche alors qu'il a la possibilité de manger");
				break;
				case (2) : this.manger();
				System.out.println(this + " mange");
				break;
			}	
		}
		//dans tous les autres cas
		else{
			this.marcher();
			System.out.println(this + " marche car pas de nourriture dans la case ou pas faim");
		}
		System.out.println("Quantité energie du neuneu après action : " +this.getEnergie());
	}
		
	
	public void manger(){
		if (this.celluleCourante.getNourriture() != null){
			int miam;
			Nourriture cellNourriture = this.getCelluleCourante().getNourriture();
			int quantitevoulue = (int)(3*(Math.random()));
			if (cellNourriture.getQuantite()<quantitevoulue){
				miam = cellNourriture.getQuantite();
			}
			else {
				miam=quantitevoulue;
			}	
				this.setEnergie(this.getEnergie()+(cellNourriture.getEnergie()*miam));
				cellNourriture.setQuantite(cellNourriture.getQuantite()-miam);
				if (cellNourriture.getQuantite()==0){
					this.getCelluleCourante().setNourriture(null);
				}
			System.out.println("Quantité nourriture dans la cellule après repas : " + cellNourriture.getQuantite());
			}
		}

	
	public void marcher() {
		int oldx = this.getCelluleCourante().getX();
		int oldy = this.getCelluleCourante().getY();
		int k = (int)(5*(Math.random())+1);
		int newx=oldx;
		int newy=oldy;
		switch (k) {
		case (1) :   // On va bouger de -1 en x
			if (oldx>0){
			newx=oldx-1;break;
			}
		case (2) : // On va bouger de 1 en y
			if (oldy<this.loft.getH()-1){
			newy=oldy+1;break;
			}
		case (3) : // On va bouger de 1 en x
			if (oldx<this.loft.getW()-1){
			newx=oldx+1;break;
			}
		case (4) :  // On va bouger de -1 en y
			if (oldy>0){
			newy=oldy-1; break;
			}
		case (5) : // Il choisit de ne pas bouger
			break;
		}
		
		// changle le neuneu de cellule
		this.loft.getCellule(oldx, oldy).setNeuneu(null);
		this.loft.getCellule(newx, newy).setNeuneu(this);
		//change la celluleCourante, attribut de Neuneu
		this.setCelluleCourante(this.loft.getCellule(newx, newy));
		//Fait diminuer l'énergie du Neuneu
		this.setEnergie(this.getEnergie()-2); // Ca creuse de marche !
	}

	public void seReproduire() {
		
	}

	// Getter et Setter lies a la cellule sur laquelle se trouve le neuneu
	public Cellule getCelluleCourante() {
		return celluleCourante;
	}

	public void setCelluleCourante(Cellule celluleCourante) {
		this.celluleCourante = celluleCourante;
	}
	//*********************************************
	
	// Getter et Setter lies a l'energie du neuneu
	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}
	//*********************************************

	// Getter et Setter lies au sexe du neuneu
	public String getSexe() {
		return this.sexe;
	}
	
	public void setSexe() {
		double x = Math.random();
		String sexe;
		if (x<0.5) {
			sexe="homme";
		}
		else {
			sexe="femme";
		}
		this.sexe=sexe;
	}
	//*********************************************

	// Getter et Setter lies au loft dans lequel se trouve le neuneu
	public Loft getLoft() {
		return loft;
	}

	public void setLoft(Loft loft) {
		this.loft = loft;
	}
	//*********************************************
	
	public String getNeuneuPath(){
		String path = new String();
		if(this.sexe=="homme"){
			path = new File("neuneu1.png").getName();
		}
		else if(this.sexe=="femme"){
			path = new File("neuneu2.gif").getName();
		}
		return path;
	}

}