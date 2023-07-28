package main;

public class Nain extends Guerrier {
	
	private int protec;
	
	public Nain(String nom, int pv, int nbDesAttaque, int protecArmure) {
		super(nom, pv, nbDesAttaque);
		this.protec = protecArmure;
	}
	
	public void subirDegats(int degats) {
		int pvActuel = getPv();
		if(degats<=protec) {degats=0;}		//si les degats sont plus petit que l'armure alors il n'y a pas de dégats
		else {degats-=protec;}		//sinon il sont réduit du chiffre de la protection
		pvActuel -= degats;		
		System.out.println("La reduction des degats est de : " + protec);		//affiche la reduction de degats
		setPv(pvActuel);	//update les pv
	}
}