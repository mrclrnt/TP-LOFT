package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.File;

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
		g.setColor(Color.black);
		g.drawRect(60*x, 60*y, 60, 60);
		if (this.nourriture != null){
			ImageObserver observer = null;
			String path = null;
			int imageWidth = 0;
			int imageHeight = 0;
			this.nourriture.getNourritureInformation(path, imageWidth, imageHeight);
	        Image image = Toolkit.getDefaultToolkit().getImage(path) ;
			g.drawImage(image, 60*x+1, 60*y+1, imageWidth, imageHeight, observer);
		}
	}
	
}
