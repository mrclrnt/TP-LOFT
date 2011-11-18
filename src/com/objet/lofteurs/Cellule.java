package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;

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
	
	public void dessinerObjet(Graphics g) {
		g.setColor(new Color(255,0,0));
		g.fillRect(60*x, 60*y, 60, 60);
	}

	
	
}
