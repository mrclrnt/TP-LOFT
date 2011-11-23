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
	public static int initEnergie=10;
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

		while(loft.getListeNeuneus().size()>0){
			System.out.println("Tour N° " + count);

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
				System.out.println(nbNeuneuAvantCheck-nbNeuneuApresCheck + " neuneu(s) supprime(s)");
				loft.setListeNeuneus(NeuneuAGarder);
			}

			
			//Reproduction
			ArrayList<Neuneu> neuneuEnReproduction = new ArrayList<Neuneu>();
			for (int i=0 ; i<loft.getListeNeuneus().size() ; i++){
				Neuneu partenaire1 = loft.getListeNeuneus().get(i);
				// si partenaire1 n'est pas deja en train de se reproduire
				if (!neuneuEnReproduction.contains(partenaire1)){ 
					Neuneu partenaire2 = partenaire1.neuneuAuxAlentours();
					// si partenaire2 n'est pas deja en train de se reproduire
					if (!neuneuEnReproduction.contains(partenaire2) &&
							partenaire2 != null){ 
						neuneuEnReproduction.add(partenaire1);
						neuneuEnReproduction.add(partenaire2);	
						partenaire1.seReproduire(partenaire2);
					}
				}
			}
			
			//Deplacement ou repas
			for (int i=0 ; i<loft.getListeNeuneus().size() ; i++){
				loft.getListeNeuneus().get(i).action();
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
		System.out.println("Fin de la saison");
	}
}

	