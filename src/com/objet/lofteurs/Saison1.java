package com.objet.lofteurs;

import java.util.ArrayList;



public class Saison1 {

	public static int nombreLofteurs = 5;
	public static int tailleLoft = 10;
	public static float proportionErratique = .75f;
	public static float proportionVorace = .25f;
	public static float proportionCannibale = 0f;
	public static int quantiteNourriture = 20;
	public static double Repartition = 0.1; 	// A chaque remplissage de la grille en nourriture je peux ajouter
												// jusqu a Repartition (%) de la nourriture totale 
												// 	sur la cellule consideree
	public static int initEnergie=50;
	public static int maxEnergie=30;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			new Saison1().primeTime();

	}

	public void primeTime() {
		ZoneGraphique zone = new ZoneGraphique("Mon premier loft");
		Loft loft = new Loft(tailleLoft,zone);
		loft.remplissageAleatoireNourriture(Saison1.quantiteNourriture,Saison1.Repartition);
		loft.remplissageAleatoireNeuneus(Saison1.nombreLofteurs);

		zone.ajouterObjet(loft);
		int count = 1;

		while(1==1){
			System.out.println(count);

			//Suppression des neuneus qui n'ont plus d'energie
			ArrayList<Neuneu> NeuneuAGarder = new ArrayList<Neuneu>();
			int nbNeuneuAvantCheck = loft.getListeNeuneus().size();
			for (int i=0 ; i<loft.getListeNeuneus().size() ; i++){
				if (loft.getListeNeuneus().get(i).getEnergie()>0 ){
					NeuneuAGarder.add(loft.getListeNeuneus().get(i));
				}
				else {
					loft.getListeNeuneus().get(i).getCelluleCourante().setNeuneu(null);
				}
			}
			int nbNeuneuApresCheck = NeuneuAGarder.size();
			if (nbNeuneuAvantCheck!=nbNeuneuApresCheck){
				System.out.println(nbNeuneuAvantCheck-nbNeuneuApresCheck + " neuneu(s) supprimé(s)");
				loft.setListeNeuneus(NeuneuAGarder);
			}




			ArrayList<Neuneu> tourNeuneu = loft.getListeNeuneus();
			for (int i=0 ; i<tourNeuneu.size() ; i++){
				tourNeuneu.get(i).action();
			}
			zone.repaint();


			count++;
			try { 
				  Thread.sleep(1000);
				}
				catch (InterruptedException exception) {
				  exception.printStackTrace();
				}
		}
	}
}

//		for (int i=0 ; i<nombreLofteurs ; i++) {
//			double x = Math.random();
//			if (x<proportionVorace) {
//				loft.add(new Vorace(loft,
//						(int)(Math.random()*29),
//						(int)(Math.random()*29),
//						3));
//			}
//			else {
//				x -= proportionVorace;
//				if (x<proportionErratique) {
//					loft.add(new Neuneu(loft,
//							(int)(Math.random()*29),
//							(int)(Math.random()*29)));
//				}
//				else {
//					x -= proportionErratique;
//					if (x<proportionCannibale) {
//						loft.add(new Cannibale(loft,
//						(int)(Math.random()*29),
//						(int)(Math.random()*29),
//						5));
//					}
//				}
//			}
//		}

//		loft.go();
	