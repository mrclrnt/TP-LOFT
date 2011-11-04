package com.objet.lofteurs;

public class Neuneu {
	protected int energie;
	protected String sexe;
	protected Cellule celluleCourante;
	protected Loft loft;
	
	public Neuneu(Loft loft,int x,int y) {
		int pourcentageEnergie = int(Math.random()+0.5);
		this.setLoft(loft);
		this.setCelluleCourante(this.loft.getCellule(x,y));
		this.setEnergie(this.loft.getMaxEnergie()*pourcentageEnergie);
		this.setSexe();
	}


	public Cellule getCelluleCourante() {
		return celluleCourante;
	}

	public void setCelluleCourante(Cellule celluleCourante) {
		this.celluleCourante = celluleCourante;
	}


	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}



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




	public Loft getLoft() {
		return loft;
	}

	public void setLoft(Loft loft) {
		this.loft = loft;
	}
}