package com.objet.lofteurs;

public class Cellule {

		private int x;
		private int y;
		private Nourriture nourriture;
		private Neuneu neuneu;
	
	public Nourriture getNourriture() {
		return nourriture;
	}
	public void setNourriture(Nourriture nourriture) {
		this.nourriture = nourriture;
	}
	public Neuneu getNeuneu() {
		return neuneu;
	}
	public void setNeuneu(Neuneu neuneu) {
		this.neuneu = neuneu;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
	public Cellule(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	
}
