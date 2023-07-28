package main;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static final String TEXT_RESET = "\u001B[0;40m";
	public static final String TEXT_BLACK = "\u001B[30;40m";
	public static final String TEXT_RED = "\u001B[31;40m";
	public static final String TEXT_GREEN = "\u001B[32;40m";
	public static final String TEXT_YELLOW = "\u001B[33;40m";
	public static final String TEXT_BLUE = "\u001B[34;40m";
	public static final String TEXT_PURPLE = "\u001B[35;40m";
	public static final String TEXT_CYAN = "\u001B[36;40m";
	public static final String TEXT_WHITE = "\u001B[37;40m";

	public static final String TEXT_BRIGHT_BLACK = "\u001B[90;40m";
	public static final String TEXT_BRIGHT_RED = "\u001B[91;40m";
	public static final String TEXT_BRIGHT_GREEN = "\u001B[92;40m";
	public static final String TEXT_BRIGHT_YELLOW = "\u001B[93;40m";
	public static final String TEXT_BRIGHT_BLUE = "\u001B[94;40m";
	public static final String TEXT_BRIGHT_PURPLE = "\u001B[95;40m";
	public static final String TEXT_BRIGHT_CYAN = "\u001B[96;40m";
	public static final String TEXT_BRIGHT_WHITE = "\u001B[97;40m";

	public static final String TEXT_BG_BLACK = "\u001B[40m";
	public static final String TEXT_BG_RED = "\u001B[41m";
	public static final String TEXT_BG_GREEN = "\u001B[42m";
	public static final String TEXT_BG_YELLOW = "\u001B[43m";
	public static final String TEXT_BG_BLUE = "\u001B[44m";
	public static final String TEXT_BG_PURPLE = "\u001B[45m";
	public static final String TEXT_BG_CYAN = "\u001B[46m";
	public static final String TEXT_BG_WHITE = "\u001B[47m";
	public static final String TEXT_BRIGHT_BG_BLACK = "\u001B[100m";
	public static final String TEXT_BRIGHT_BG_RED = "\u001B[101m";
	public static final String TEXT_BRIGHT_BG_GREEN = "\u001B[102m";
	public static final String TEXT_BRIGHT_BG_YELLOW = "\u001B[103m";
	public static final String TEXT_BRIGHT_BG_BLUE = "\u001B[104m";
	public static final String TEXT_BRIGHT_BG_PURPLE = "\u001B[105m";
	public static final String TEXT_BRIGHT_BG_CYAN = "\u001B[106m";
	public static final String TEXT_BRIGHT_BG_WHITE = "\u001B[107m";

	public static void main(String[] args) {
//character creation
		Guerrier guerrier1 = new Elfe("Cassiel", 90, 3, 4);
		Guerrier guerrier2 = new Nain("Basil", 100, 2, 3);
		Guerrier guerrier3 = new Guerrier("Raya", 85, 3);
		Guerrier guerrier4 = new Elfe("Leyndell", 80, 2, 3);
		Guerrier guerrier5 = new Nain("Liurna", 75, 2, 3);
		Guerrier guerrier6 = new Guerrier("Farum", 79, 3);

		int tailleTeam = 3; //number of character in the team
		Guerrier[] joueurs = new Guerrier[] { guerrier1, guerrier2, guerrier3, guerrier4, guerrier5, guerrier6 };
		boolean[] tab = new boolean[] { true, true, true, true, true, true };

		Guerrier[] teamOrdi = new Guerrier[tailleTeam];		//size of number for character
		Guerrier[] teamHumain = new Guerrier[tailleTeam];

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int choixOrdi;

		for (int j = 0; j < tailleTeam; j++) {		//loop

			choixOrdi = random.nextInt(6);
			while (tab[choixOrdi] == false) {
				choixOrdi = random.nextInt(6);		//random
			}
			teamOrdi[j] = joueurs[choixOrdi];
		tab[choixOrdi] = false;				
			
			System.out.println(TEXT_BRIGHT_RED + "l'ordinateur a choisis : " + teamOrdi[j].getNom() + TEXT_RESET);
			System.out.print(TEXT_BRIGHT_PURPLE);
			for (int i = 0; i < joueurs.length; i++) {
				if (tab[i]) {
					System.out.println(i + 1 + " : " + joueurs[i].getNom());	
				}
			}
			int choixHumain = -1;
			while ((choixHumain < 0) || (choixHumain > 6)) {
				System.out.println(TEXT_BRIGHT_BLUE + "Veuillez choisir un personnage" + TEXT_RESET);
				choixHumain = scanner.nextInt();
				choixHumain--;
				if ((choixHumain < 0) || (choixHumain > 7)) {	
					System.out.println(TEXT_BRIGHT_PURPLE + "Erreur dans la saisie" + TEXT_RESET);
				}
			}

			while (tab[choixHumain] == false) {
				System.out.println(TEXT_BRIGHT_PURPLE + "Erreur, ce personnage n'est pas disponible!" + TEXT_RESET);
				choixHumain = scanner.nextInt();
				choixHumain--;
			}
			System.out.println(TEXT_BRIGHT_BLUE + "Vous avez choisis :" + joueurs[choixHumain].getNom() + TEXT_RESET);
			teamHumain[j] = joueurs[choixHumain];
			tab[choixHumain] = false;	
		}
//show two team
		System.out.println(TEXT_BRIGHT_RED + "Team ordi : ");

		for (int j = 0; j < tailleTeam; j++) {
			System.out.print(teamOrdi[j].getNom() + " ");
		}
		System.out.println();
		System.out.println(TEXT_BRIGHT_BLUE + "Team humain : ");

		for (int j = 0; j < tailleTeam; j++) {
			System.out.print(teamHumain[j].getNom() + " ");
		}

		choixOrdi = random.nextInt(2); //computer choose
		System.out.println();
		System.out.println(
				TEXT_BRIGHT_RED + "l'ordinateur a choisis " + teamOrdi[choixOrdi].getNom() + " pour se battre");

		System.out.println(TEXT_BRIGHT_BLUE + "Veuillez choisir votre Guerrier : "); 
		for (int j = 0; j < tailleTeam; j++) {
			System.out.print(j + 1 + teamHumain[j].getNom() + " ");
		}

		int choixHumain = scanner.nextInt(); //on choisis le notre
		choixHumain--;
		while((choixHumain<0)||(choixHumain>2)){
			System.out.println(TEXT_BRIGHT_PURPLE + "Erreur dans la saisie, veuillez recommencer" + TEXT_RESET);
			choixHumain = scanner.nextInt();
			choixHumain--;
		}		
		
		System.out.println(
				TEXT_BRIGHT_BLUE + "Vous avez choisis " + teamHumain[choixHumain].getNom() + " pour se battre");

		int mortOrdi = 0;
		int mortHumain = 0;

		while ((teamOrdi[choixOrdi].getPv() > 0) && (teamHumain[choixHumain].getPv() > 0)) {	//tant qu'une des deux teams a des points de vie
			System.out.println(TEXT_BRIGHT_RED + "L'ordinateur joue : " + TEXT_BRIGHT_PURPLE);
			for (int i = 1; i <= teamOrdi[choixOrdi].getnbDesAttaques(); i++) {			//on fait les tours de l'ordinateur
				System.out.println("tour " + i + " de " + teamOrdi[choixOrdi].getNom());
				teamOrdi[choixOrdi].attaquer(teamHumain[choixHumain]);		//action d'attaque, puis on affiche les pv restant de la cible
				teamHumain[choixHumain].afficherInfo();
				if (teamHumain[choixHumain].getPv() <= 0) {				//si le personnage meurt, on augment le nombre de mort humaine de 1
					System.out.println(
							TEXT_BRIGHT_BLUE + "Le personnage " + teamHumain[choixHumain].getNom() + " est mort");
					mortHumain++;
					System.out.println("Nombre de mort de la team humain : " + mortHumain);
				}

				if (mortHumain == 3) {			//si tout les personnages sont mort, l'ordinateur a gagné
					System.out.println(TEXT_BRIGHT_RED + "L'ordinateur a gagné!");
					return;
				}

				else {				//sinon on choisis notre prochain personnage 
					while (teamHumain[choixHumain].getPv() <= 0) {
						System.out.println(
								TEXT_BRIGHT_BLUE + "Veuillez choisir un nouveau personnage parmis ceux restant :");

						for (int k = 0; k < tailleTeam; k++) {
							if (teamHumain[k].getPv() > 0) {
								System.out.println(TEXT_BRIGHT_PURPLE + k + " : " + teamHumain[k].getNom());
							}
						}

						choixHumain = scanner.nextInt();
						while ((choixHumain > 2) || (choixHumain < 0)) {
							System.out.println("Erreur, veuillez prendre un personnage parmis ceux restant");
							choixHumain = scanner.nextInt();
						}

						if (teamHumain[choixHumain].getPv() < 0) {
							System.out.println("Erreur, veuillez prendre un personnage vivant");
						}
					}
				}
			}

			System.out.println(TEXT_BRIGHT_BLUE + "à toi de jouer !");		
			for (int i = 1; i <= teamHumain[choixHumain].getnbDesAttaques(); i++) {
				System.out.println(TEXT_BRIGHT_PURPLE + "tour " + i + " de " + teamHumain[choixHumain].getNom());
				teamHumain[choixHumain].attaquer(teamOrdi[choixOrdi]);
				teamOrdi[choixOrdi].afficherInfo();
				if (teamOrdi[choixOrdi].getPv() <= 0) {
					System.out.println(TEXT_BRIGHT_RED + "Le personnage " + teamOrdi[choixOrdi].getNom() + " est mort");
					mortOrdi++;
					System.out.println("Nombre de mort de la team Ordi : " + mortOrdi);
				}

				if (mortOrdi == 3) {
					System.out.println(TEXT_BRIGHT_BLUE + "L'Humain a gagné!");
					return;
				}

				else {
					while (teamOrdi[choixOrdi].getPv() <= 0) {
						for (int k = 0; k < tailleTeam; k++) {
							if (teamOrdi[k].getPv() > 0) {
								System.out.println(TEXT_BRIGHT_PURPLE + k + " : " + teamOrdi[k].getNom());
							}
						}
						choixOrdi = random.nextInt(3);
					}
				}
			}
		}
	}
}