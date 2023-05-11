package fr.it_akademy.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.it_akademy.business.Carte;
import fr.it_akademy.business.Couleur;
import fr.it_akademy.business.Ville;

public class App {

	public static void main(String[] args) {

		// On déclare une collection de villes
		// List : interface
		// ArayList : implémentation de l'interface List
		// <> : Diamant
		List<Ville> villes = new ArrayList<>();

		// On déclare une ville correspondant à Marseille
		Ville ville1 = new Ville("Marseille 1");
		Ville ville2 = new Ville("Saint-Galmier", "42330");
		Ville ville3 = new Ville("Lyon 3", "69003", 0, 0, 0);
		Ville ville4 = new Ville();

		ville1.setCodePostal("13001");
		System.out.println(ville1);
		System.out.println(ville2);

		villes.add(ville1);
		villes.add(ville2);
		villes.add(ville3);
		villes.add(ville4);
		villes.add(new Ville("Cassis"));

		// villes.forEach(System.out::println);

		// forEach : on parcourt la collection de villes
		for (Ville ville : villes) {
			System.out.println(ville);
		}

		villes.remove(4);

		System.out.println("On mélange les villes");
		// On mélange les villes
		Collections.shuffle(villes);

		// forEach : on parcourt la collection de villes
		for (Ville ville : villes) {
			System.out.println(ville);
		}

		// -----------------------------------------------------------

		Couleur rouge = new Couleur("Rouge");
		Couleur noir = new Couleur("Noir");

		String[] cartesNoir = { "Trèfle", "Pique" };
		String[] cartesRouge = { "Coeur", "Carreaux" };
		int[] valeurs = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

		List<Carte> jeux = new ArrayList<>();

		for (int i = 0; i < cartesNoir.length; i++) {
			for (int valeur : valeurs) {
				jeux.add(new Carte(valeur, noir));
			}
		}

		for (int i = 0; i < cartesRouge.length; i++) {
			for (int valeur : valeurs) {
				jeux.add(new Carte(valeur, rouge));
			}
		}

		for (int i = 0; i < jeux.size(); i++) {
			Carte carte = jeux.get(i);
			System.out.println("Carte N° " + (i + 1) + " ---> " + carte.getNom() + " - " + carte.getCouleur().getNom());
		}

		Collections.shuffle(jeux);
		
		for (int i = 0; i < jeux.size(); i++) {
			Carte carte = jeux.get(i);
			System.out.print("Carte N° " + (i + 1) + " ---> " + carte.getNom() + " - " + carte.getCouleur().getNom() + " ------ ");
		}

	}

}
