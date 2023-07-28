package main;

import java.util.Random;

public class Elfe extends Guerrier {
	private int minAtt;
	
	public Elfe(String nom, int pv, int nbDesAttaque, int minAtt) {
		super(nom, pv, nbDesAttaque);
		this.minAtt = minAtt;
	}

	public void attaquer(Guerrier adv) {
		Random random = new Random();
		int valeur = random.nextInt(6 - minAtt + 1) + minAtt;		//prend la valeur du minimum de dégats jusqu'à 6
		System.out.println("L'elfe a fait " + valeur + " degats");		//Affiche les degats de l'elfe
		adv.subirDegats(valeur);		//update les pv de l'adversaire
	}
	
}