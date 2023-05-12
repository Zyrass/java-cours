package fr.it_akademy.poker;

// import java.util
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Imports des classes requises au bon 
// fonctionnement de l'application
import fr.it_akademy.poker.business.Carte;
import fr.it_akademy.poker.business.Combinaison;
import fr.it_akademy.poker.business.Couleur;
import fr.it_akademy.poker.business.Joueur;
import fr.it_akademy.poker.business.Ville;

public class App {

	// On déclare une collection de villes
	// List : interface
	// ArayList : implémentation de l'interface List
	// <> : Diamant
	// Les listes doivent être déclarées static
	// car elles sont utilisées par la méthode main qui est static

	// =======================================
	// ============= LISTS
	// =======================================

	private static List<Ville> villes = new ArrayList<>();
	private static List<Joueur> joueurs = new ArrayList<>();
	private static List<Carte> cartes = new ArrayList<>();
	private static List<Couleur> couleurs = new ArrayList<>();

	// =======================================
	// ============= PROGRAMME EXECUTABLE
	// =======================================

	public static void main(String[] args) {

		constituerJeu();
		ajouterVilles();
		ajouterJoueurs();
		melangerJeu();
		distribuerCartes();
		importerVilles();

		for (Joueur joueur : joueurs) {
			afficherJoueur(joueur);
			System.out.println(analyserMain(joueur));
		}

	} // end main

	// =======================================
	// ============= METHODS
	// =======================================

	/**
	 * Cette méthode constitue le jeu de 52 cartes
	 */
	public static void constituerJeu() {

		// On crée les 4 objets de type Couleur
		couleurs.add(new Couleur("Coeur"));
		couleurs.add(new Couleur("Pique"));
		couleurs.add(new Couleur("Carreau"));
		couleurs.add(new Couleur("Trèfle"));

		// On parcourt la collection de couleurs
		for (Couleur couleur : couleurs) {
			System.out.println("\n ---- " + couleur + " ----");
			// On ajoute 13 cartes de cette couleur
			for (int i = 2; i <= 14; i++) {
				cartes.add(new Carte(i, couleur));
			}
			System.out.println(" ---- " + couleur + " Ajouté avec succès ----\n");
		}

	}

	/**
	 * Cette méthode permet d'ajouter des villes
	 */
	private static void ajouterVilles() {

		// On déclare une ville correspondant à Marseille
		Ville ville1 = new Ville("Marseille");
		ville1.setCodePostal("13001");
		System.out.println(ville1);

		// On affiche la ville 2
		Ville ville2 = new Ville("Meyzieu", "69330");
		System.out.println(ville2);

		Ville ville3 = new Ville("Lyon", "69003", 0, 0, 0);
		Ville ville4 = new Ville();

		// On ajoute à notre list "villes" les 4 villes
		villes.add(ville1); // indice 0
		villes.add(ville2); // indice 1
		villes.add(ville3); // indice 2
		villes.add(ville4); // indice 3
		villes.add(new Ville("Cassis")); // indice 4

		// On supprime une ville qui n'a aucune information
		villes.remove(4);

		// villes.forEach(System.out::println);

		// forEach : on parcourt la collection de villes
		for (Ville ville : villes) {
			System.out.println(ville);
		}

		// On mélange les villes
		System.out.println("\nOn mélange les villes\n");
		Collections.shuffle(villes);

		// forEach : on parcourt la collection de villes
		for (Ville ville : villes) {
			System.out.println(ville);
		}

	}

	/**
	 * Cette méthode Ajoute des joueurs à retravailler pour y inclure un scanner
	 * d'entré
	 */
	public static void ajouterJoueurs() {
		joueurs.add(new Joueur("A"));
		joueurs.add(new Joueur("B"));
		joueurs.add(new Joueur("C"));
		joueurs.add(new Joueur("D"));
		joueurs.add(new Joueur("E"));
	}

	/**
	 * Cette méthode mélange le jeu de 52 cartes
	 */
	public static void melangerJeu() {
		Collections.shuffle(cartes);
	}

	/**
	 * Cette méthode distribue 5 cartes à chaque joueur
	 */
	private static void distribuerCartes() {
		for (int i = 0; i < 5; i++) {
			for (Joueur joueur : joueurs) {
				joueur.getMain().add(cartes.remove(0));
			}
		}
	}

	/**
	 * Cette méthode permet d'afficher un Joueur
	 */
	private static void afficherJoueur(Joueur joueur) {
		System.out.println(joueur);
	}

	/**
	 * Cette méthode permet d'analyser la main d'un joueur
	 */
	private static Combinaison analyserMain(Joueur joueur) {

		int[] occurrences = new int[15];

		// Si j'ai 4 Coeur, 7 Pique, 4 Carreau, 10 Trèfle et un As de Coeur
		// occurrences[4]=2 signifie une paire de quatre
		// occurrences[7]=1 signifie une carte avec une valeur égale à 7

		// On parcourt les cartes qui sont dans la main du joueur
		for (Carte carte : joueur.getMain()) {
			occurrences[carte.getValeur()]++;
		}

		for (int i = 0; i < occurrences.length; i++) {
			System.out.print(occurrences[i]);
		}

		System.out.println();

		// Switch pour déterminer si le joueur a obtenu un carré
		System.out.println(joueur);

		// @Tarek : comment tester la présence d'un carré ?
		for (int i = 0; i < occurrences.length; i++) {
			if (occurrences[i] == 4) {
				return Combinaison.CARRE;
			}
			// @Marc : comment tester la présence d'un full ?
			else if (occurrences[i] == 3) {

				// Le joueur a obtenu un brelan, a t il également une paire ?
				for (int j = 0; j < occurrences.length; j++) {
					if (occurrences[j] == 2) {
						System.out.println("\n\n -------- FULL \n\n");
						return Combinaison.FULL;
					}
				}
				System.out.println("\n\n -------- BRELAN \n\n");
				return Combinaison.BRELAN;
			} else if (occurrences[i] == 2) {

				for (int j = i; j < occurrences.length; j++) {
					if (occurrences[j] == 2 && j != i) {
						System.out.println("\n\n -------- DOUBLE_PAIRE \n\n");
						return Combinaison.DOUBLE_PAIRE;
					}
				}
				System.out.println("\n\n -------- PAIRE \n\n");
				return Combinaison.PAIRE;

			}

//			else if (occurrences[i] == 1 && occurrences[i + 1] == 1 && occurrences[i + 2] == 1 && occurrences[i + 3] == 1 ) {
//				
//				System.out.println("\n\n -------- SUITE \n\n");
//				return Combinaison.SUITE;
//				
//			} else if (occurrences[15] == 1 && occurrences[2] == 1 && occurrences[3] == 1 && occurrences[4] == 1 ) {
//				
//				System.out.println("\n\n -------- SUITE \n\n");
//				return Combinaison.SUITE;	
//			}
		}

		// On teste la présence d'une suite
		// exemple : 0 0 0 0 0 1 1 1 1 1 0 0 0

		// On teste la présence d'une couleur
		Couleur couleurDeLaPremiereCarte = joueur.getMain().get(0).getCouleur();
		boolean memeCouleur = true;

		for (Carte carte : joueur.getMain()) {
			if (!carte.getCouleur().equals(couleurDeLaPremiereCarte)) {
				memeCouleur = false;
			}
		}
		if (memeCouleur) {
			return Combinaison.COULEUR;
		}
		return Combinaison.CARTE_HAUTE;
	}

	private static void importerVilles() {
		URL url;
		BufferedReader readerBuffered = null;

		try {
			url = new URL("https://www.clelia.fr/villes2020.csv");

			InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");
			readerBuffered = new BufferedReader(reader);

			String ligne;

			// On lit chaque ligne du fichier
			while ((ligne = readerBuffered.readLine()) != null) {

				// On sépare chaque ligne en plusieurs parties basées sur le caractère ";"
				String[] parties = ligne.split(";");
			

				// On vérifie que la ligne a suffisamment de champs
				if (parties.length >= 6) {
					
					// On récupère le nom de la ville, le code postal et les coordonnées GPS de
					// chaque ligne
					String nomVille = parties[1];
					String codePostalVille = parties[2];
					String[] coordonneesGPS = parties[5].split(",");
					double latitude = 0;
					double longitude = 0;
		
					// On vérifie que les coordonnées GPS sont valides
					if (coordonneesGPS.length == 2) {
						// On convertit les coordonnées GPS en doubles
						double latitudeVille = Double.parseDouble(coordonneesGPS[0]);
						double longitudeVille = Double.parseDouble(coordonneesGPS[1]);

						// On crée une nouvelle instance de la classe Ville et on l'ajoute à la liste
						Ville ville = new Ville(nomVille, codePostalVille, latitudeVille, longitudeVille);
						villes.add(ville);
						System.out.println(villes.size());
						
					} else {
						System.out.println("--------- Coordonnées GPS invalides pour la ville : " + nomVille + "\n");
					}
					
				} else if (parties.length >= 5) { 
					Ville ville = new Ville(parties[1], parties[2], 0.0, 0.0);
					villes.add(ville);
				}
			}

		} catch (MalformedURLException e) {
			System.out.println("URL invalide : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Une erreur s'est produite lors de la récupération ou de la lecture du fichier CSV. "
					+ e.getMessage());
		} finally {
			if (readerBuffered != null) {
				try {
					readerBuffered.close();
				} catch (IOException e) {
					System.out.println(
							"Une erreur s'est produite lors de la fermeture du BufferedReader. " + e.getMessage());
				}
			}
		}
	}

}
