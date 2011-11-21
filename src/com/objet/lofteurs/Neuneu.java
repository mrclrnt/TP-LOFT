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
		int Energie = (int)(this.loft.getMaxEnergie()*Math.random());
		this.setEnergie(Energie);
		this.setSexe();
	}
	
	public Cellule marcher() {
		int oldx = this.getCelluleCourante().getX();
		int oldy = this.getCelluleCourante().getY();
		int k = (int)(4*(Math.random())+1);
		int newx=oldx;
		int newy=oldy;
		switch (k) {
		case (1) :   // On va bouger de -1 en x
			if (oldx>0){
			newx=oldx-1;break;
			}
		case (2) : // On va bouger de 1 en y
			if (oldy<10){
			newy=oldy+1;break;
			}
		case (3) : // On va bouger de 1 en x
			if (oldx<10){
			newx=oldx+1;break;
			}
		case (4) :  // On va bouger de -1 en y
			if (oldy>0){
			newy=oldy-1; break;
			}
		}
		Cellule nouvelleCellule= new Cellule(newx,newy);
		this.setCelluleCourante(nouvelleCellule);
		return nouvelleCellule;
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
			path = new File("neuneu.png").getName();
		}
		return path;
	}

}