package com.objet.lofteurs;

public class Alcool extends Nourriture {

	protected int Degre;
	
	public Alcool(String nom, int quantite, int energie, int degre) {
		super(nom, quantite, energie);
		Degre = degre;
	}

	public int getDegre() {
		return Degre;
	}

	public void setDegre(int degre) {
		Degre = degre;
	}
	

}
