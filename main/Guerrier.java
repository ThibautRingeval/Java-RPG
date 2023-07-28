package main;

import java.util.Random;

public class Guerrier {
private String nom;
private int pv;
private int nbDesAttaque;


public Guerrier(String nom, int pv, int nbDesAttaque){
	this.nom= nom;
	this.pv= pv;
	this.nbDesAttaque= nbDesAttaque;
}

public String getNom() {
	return this.nom;	//recupere le nom
}

public int getPv() {
	return this.pv;		//recupere les points de vie 
}

protected void setPv(int pv2){
	this.pv = pv2;		//update les points de vie
}

public int getnbDesAttaques() {
	return this.nbDesAttaque;		//recupere le nombre de tour 
}

public void afficherInfo() {
	System.out.println(getNom() + "{PV=" + getPv() + "}");		//affiche le nom et point de vie restant
}

public void attaquer(Guerrier adv) {
	Random random = new Random();		//random pour le nombre de degats 
	int valeur = random.nextInt(6);
	adv.subirDegats(valeur);		//lance la fonction subir des degats pour update les pv de l'adversaire 
}

public void subirDegats(int degats) {
	int pvActuel = getPv();
	pvActuel -= degats;		//update les pv de la cible en déduisant le nombre de dégats
	setPv(pvActuel);
}
}