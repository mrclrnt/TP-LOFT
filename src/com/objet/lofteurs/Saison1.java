package com.objet.lofteurs;

import java.util.ArrayList;



public class Saison1 {

	public static int nombreLofteurs = 4;
	public static int tailleLoft = 10;
	public static float proportionErratique = .75f;
	public static float proportionVorace = .25f;
	public static float proportionCannibale = 0f;
	public static int quantiteNourriture = 100;
	public static double Repartition = 0.05; 	// A chaque remplissage de la grille en nourriture je peux ajouter
												// jusqu a Repartition (%) de la nourriture totale 
												// 	sur la cellule consideree
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
		//loft.remplissageAleatoireNeuneus(Saison1.nombreLofteurs);


		ArrayList<Neuneu> Participants = new ArrayList<Neuneu>();
		Neuneu Philippe = new Neuneu(loft,2,2);
	//	Neuneu Pierrette = new Neuneu(loft,5,8);
		Participants.add(Philippe);
	//	Participants.add(Pierrette);
		zone.ajouterObjet(loft);
		
		while(1==1){
			ArrayList<Neuneu> tourNeuneu = loft.getListeNeuneus();
			for (int i=0 ; i<tourNeuneu.size() ; i++){
				tourNeuneu.get(i).action();
				
				
				
			}
			loft.deplacer(Philippe);
			if (Philippe.getCelluleCourante().getNourriture()!=null){
			System.out.println(Philippe.getCelluleCourante().getNourriture().getQuantite());
			}
			zone.repaint();
			try { 
				  Thread.sleep(1000);
				}
				catch (InterruptedException exception) {
				  exception.printStackTrace();
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
	}

}
