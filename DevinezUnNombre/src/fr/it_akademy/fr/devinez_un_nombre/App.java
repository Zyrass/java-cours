/**
 * Package contenant une application qui génère un nombre aléatoire et demande à l'utilisateur de le deviner.
 */
package fr.it_akademy.fr.devinez_un_nombre;

import java.util.Random;
import java.util.Scanner;

/**
 * Classe principale de l'application.
 */
public class App {

	/**
	 * Point d'entrée du programme. Génère un nombre aléatoire entre 1 et 100 et demande à l'utilisateur de le deviner.
	 * Affiche des indices après chaque tentative pour aider l'utilisateur à deviner le nombre.
	 *
	 * @param args Les arguments de ligne de commande. Non utilisé dans ce programme.
	 */
	public static void main(String[] args) {

		Random nr = new Random();  // Générateur de nombres aléatoires.
		Scanner sc = new Scanner(System.in);  // Scanner pour lire l'entrée de l'utilisateur.
		
		int tries = 1;  // Compte le nombre de tentatives de l'utilisateur pour deviner le nombre.
		
		int userNumber = 0;  // Le nombre que l'utilisateur a deviné.
		int numberRandom = nr.nextInt(100) + 1;  // Le nombre aléatoire à deviner.

		// Boucle jusqu'à ce que l'utilisateur ait deviné le nombre.
		while ( userNumber != numberRandom ) {
			
			System.out.println(" - Essai n° " + tries);
			System.out.print(" - Devinne le nombre entre 1 et 100 : ");
			
			userNumber = sc.nextInt();  // Lire le nombre de l'utilisateur.
			
			// Vérifie si le nombre de l'utilisateur est correct.
			if ( userNumber == numberRandom ) {
				System.out.println("\n ============================================================================= ");
				System.out.println(" = Bravo le nombre à devinez était bien " + numberRandom + " et tu l'as trouvé en " + tries + " tentatives.");
				System.out.println(" ===============================================================================\n ");
			} else if ( userNumber < numberRandom ) {
				System.out.println("\n " + userNumber + " est trop petit\n");
				tries++;
			} else if ( userNumber > numberRandom ) {
				System.out.println("\n " + userNumber + " est trop grand\n");
				tries++;
			}
		}
		
		System.out.println("USER : " + userNumber);
		System.out.println("RANDOM TO GUESS : " + numberRandom);
		
		sc.close();
		
	}

}

