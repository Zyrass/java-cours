package fr.it_akademy.poker;

// import java.util
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Imports des classes requises au bon 
// fonctionnement de l'application
import fr.it_akademy.poker.business.Carte;
import fr.it_akademy.poker.business.Combinaison;
import fr.it_akademy.poker.business.Couleur;
import fr.it_akademy.poker.business.Joueur;
import fr.it_akademy.poker.business.NomColonneCSV;
import fr.it_akademy.poker.business.Ville;
import fr.it_akademy.util.ComparateurDeCarteSurValeur;

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

	private static Scanner sc = new Scanner(System.in);

	// =======================================
	// ============= PROGRAMME EXECUTABLE
	// =======================================

	public static void main(String[] args) {

		System.out.println();
		presentation();

		// Définition du jeu de 52 cartes
		constituerNouveauJeu();
		melangerNouveauJeu();

		// Importation des villes
		importerVilles();

		// Définir le nombre de joueur
		int nombreJoueurs = demanderNombreJoueur();

		// Création des joueurs
		creerJoueur(nombreJoueurs);

		// Distribution des cartes au(x) joueur(s)
		distribuerCartes(nombreJoueurs);

		// Afficher le joueur
		afficherJoueur(nombreJoueurs);
		
		// Triage des cartes
		trierCartes();

		// Analyser la main des joueurs
		System.out.println("\n");
		separation();
		System.out.println(" ⦿ Etape n°8 - Analyse du contenu des cartes ? ");
		separation();
		
		for (Joueur joueur : joueurs) {
			System.out.println(analyserMain(joueur));
		}

		// ajouterVilles();
		// ajouterJoueurs();

		// Fermeture du scanner pour éviter les fuites de ressources
		sc.close();

	} // end main

	// =======================================
	// ============= METHODS
	// =======================================

	/**
	 * Méthode pour concevoir une simple séparation
	 */
	public static void separation() {
		System.out.println(
				" ================================================================================================================== ");
	}

	/**
	 * Méthode pour présenteer le jeu
	 */
	public static void presentation() {

		separation();
		System.out.println(" Bienvenue sur IT-POKER");
		separation();
		System.out.println(
				" Il s'agit d'un jeu développé à l'IT-AKDEMY afin de découvrir les fondamentaux du langage JAVA");
		separation();

	}

	/**
	 * Cette méthode constitue le jeu de 52 cartes
	 */
	public static void constituerNouveauJeu() {

		System.out.println("\n");
		separation();
		System.out.println(" ⦿ Etape n°1 - Conception du jeu de 52 cartes regrouper par couleur");
		separation();

		// On crée les 4 objets de type Couleur
		couleurs.add(new Couleur("Coeur"));
		couleurs.add(new Couleur("Carreaux"));
		couleurs.add(new Couleur("Pique"));
		couleurs.add(new Couleur("Trèfle"));

		// On parcourt la collection de couleurs
		for (Couleur couleur : couleurs) {
			System.out.println(" ✅ - " + couleur.getSymbol() + " " + couleur.getNom());
			// On ajoute 13 cartes de cette couleur
			for (int i = 2; i <= 14; i++) {
				cartes.add(new Carte(i, couleur));
				// A décommenter pour voir le résultat
				// System.out.println(couleur + " " + i);
			}
		}
	}

	/**
	 * Cette méthode mélange le jeu de 52 cartes
	 */
	public static void melangerNouveauJeu() {

		System.out.println("\n");
		separation();
		System.out.println(" ⦿ Etape n°2 - Mélange des 52 cartes");
		separation();

		Collections.shuffle(cartes);

//		int compteur = 0;
//		for( Carte carte: cartes ) {
//			compteur++;
//			System.out.println(" Carte n°" + compteur + " = " + carte.getNom() );				
//		}

		System.out.println(" ✅ - Mélange terminé");

	}

	/**
	 * Cette méthode permet d'importer une liste de 39201 villes.
	 */
	private static void importerVilles() {

		System.out.println("\n");
		separation();
		System.out.println(" ⦿ Etape n°3 - Importer 39201 villes ");
		separation();

		try {

			// Ouverture d'une connexion à l'URL du fichier CSV
			URL url = new URL("https://www.clelia.fr/villes2020.csv");
			InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");
			BufferedReader readerBuffered = new BufferedReader(reader);

			try (readerBuffered) {

				String ligne;

				// Lecture du fichier CSV ligne par ligne
				while ((ligne = readerBuffered.readLine()) != null) {

					// Séparation de la ligne en plusieurs colonnes basée sur le délimiteur ";"
					String[] colonne = ligne.split(";");

					// Si la ligne a au moins 6 colonnes
					if (colonne.length >= 6) {

						// Extraction des données de la ligne
						String nomCommune = colonne[NomColonneCSV.NOM_COMMUNE.ordinal()];
						String codePostal = colonne[NomColonneCSV.CODE_POSTAL.ordinal()];
						String[] coordonneesGPS = colonne[NomColonneCSV.COORDONNEES_GPS.ordinal()].split(",");

						// Si les coordonnées GPS contiennent 2 valeurs (latitude et longitude)
						if (coordonneesGPS.length == 2) {
							double coordonneeLatitude = Double.parseDouble(coordonneesGPS[0]);
							double coordonneeLongitude = Double.parseDouble(coordonneesGPS[1]);

							// Création d'une nouvelle instance de ville avec toutes les données extraites
							Ville ville = new Ville(nomCommune, codePostal, coordonneeLatitude, coordonneeLongitude);

							// Ajout de la ville à la liste de villes
							villes.add(ville);
						}

					} else {
						// Si la ligne a moins de 6 colonnes, création d'une ville sans coordonnées GPS
						Ville ville = new Ville(colonne[NomColonneCSV.NOM_COMMUNE.ordinal()],
								colonne[NomColonneCSV.CODE_POSTAL.ordinal()], 0.0, 0.0);
						villes.add(ville);
					}
				}
			}
		} catch (Exception e) {
			// Gestion des erreurs
			System.out.println("Une erreur est survenue : " + e.getMessage());
		}

		// Vérification si toutes les 39201 villes ont été importées
		if (villes.size() == 39201) {
			System.out.println(" ✅ - Le nombre de villes importés est de : " + villes.size() + "/39201");
		} else {
			System.out.println(" ❌ - Le nombre de villes importés est de : " + villes.size() + "/39201");
		}
	}

	/**
	 * Cette méthode permet de demander le nombre de joueur qu'il y aura.
	 */
	public static int demanderNombreJoueur() {

		System.out.println("\n");
		separation();
		System.out.println(" ⦿ Etape n°4 - Combien de joueur ? ");
		separation();
		System.out.print(" Spécifier le nombre de joueur participant à cette partie : ");

		// Lecture de l'entrée de l'utilisateur
		int nombreDeJoueur = sc.nextInt();

		System.out.println(" ✅ - Le nombre de participant est de : " + nombreDeJoueur
				+ (nombreDeJoueur == 1 ? " joueur" : " joueurs"));
		return nombreDeJoueur;
	}

	/**
	 * Cette méthode permet de créer un nombre de joueurs relatif au choix définit
	 * précédemment. (Etape n°4)
	 */
	public static void creerJoueur(int nombreDeJoueurs) {

		System.out.println("\n");
		separation();
		System.out.println(" ⦿ Etape n°5 - Création " + (nombreDeJoueurs == 1 ? "du " : "des ")
				+ (nombreDeJoueurs <= 1 ? "" : nombreDeJoueurs) + (nombreDeJoueurs == 1 ? "joueur" : " joueurs"));
		separation();

		int indice = 0;
		int compteur = 1;

		while (indice < nombreDeJoueurs) {

			String pseudo = "";
			String prenom = "";
			String nom = "";
			float solde = 0;

			String messageQuiSeRepete = " Joueur n°" + compteur + " : ";

			System.out.print(messageQuiSeRepete + "Souhaiteriez-vous donnez votre nom et prénom ? [y/n] : ");
			String choixJoueur = "";

			do {
				choixJoueur = sc.nextLine().trim().toLowerCase();

				if (choixJoueur.equals("n")) {
					do {
						System.out.print(messageQuiSeRepete + "Veuillez saisir votre pseudo : ");
						pseudo = sc.nextLine().trim();
					} while (pseudo.isEmpty());
				} else if (choixJoueur.equals("y")) {
					do {
						System.out.print(messageQuiSeRepete + "Veuillez saisir votre prénom : ");
						prenom = sc.nextLine().trim();
					} while (prenom.isEmpty());
					do {
						System.out.print(messageQuiSeRepete + "Veuillez saisir votre nom : ");
						nom = sc.nextLine().trim();
					} while (nom.isEmpty());
				}
			} while (!choixJoueur.equals("n") && !choixJoueur.equals("y"));

			String messageDateDeNaissance = messageQuiSeRepete
					+ "Veuillez rentrer votre date de naissance au format dd/mm/yyyy (ex: 01/08/1969) : ";
			LocalDate dateDeNaissance = getBirthday(sc, messageDateDeNaissance);

			System.out.print(messageQuiSeRepete + "Veuillez saisir votre solde de départ : ");
			String soldeStr = sc.nextLine();
			solde = Float.parseFloat(soldeStr);

			System.out.println("\n + ------------------------- + JOUEUR n°" + compteur
					+ " + ---------------------------------- +");
			if (pseudo.length() > 0) {
				System.out.println(" +  Pseudo = " + pseudo);
			} else {
				System.out.println(" +  Prénom = " + prenom);
				System.out.println(" +  Nom = " + nom.toUpperCase());
			}
			System.out.println(" +  Date de Naissance = " + dateDeNaissance.toString());
			System.out.println(" +  Solde = " + solde + "€");
			System.out.println(" + -------------------------------------------------------------------------- +\n");

			if (pseudo.length() > 0) {
				joueurs.add(new Joueur(pseudo, solde));
			} else {
				joueurs.add(new Joueur(prenom, nom, dateDeNaissance, solde));
			}

			indice++;
			compteur++;
		}

		System.out.println(" ✅ - Nombre de " + (joueurs.size() > 1 ? "joueur enregistré" : "joueurs enregistrés")
				+ " : " + joueurs.size());

//		System.out.println(" -- Vérification des joueurs : ");
//		for (Joueur joueur : joueurs) {
//			System.out.println(" -- ✅ - "
//					+ (joueur.getPseudo() != null && !joueur.getPseudo().isEmpty() ? joueur.getPseudo()
//							: joueur.getNom().toUpperCase() + " " + joueur.getPrenom())
//					+ " dispose d'un sode de départ de " + joueur.getSolde() + "€");
//		}

	}

	/**
	 * Cette méthode permet de créer une date de naissance saisit par un joueur.
	 * Elle sera convertie de façon à ce qu'elle soit accepté par le type LocalDate.
	 * 
	 * @param sc      le scanner (enregistrement au clavier)
	 * @param message Le message saisit par le joueur
	 * @return une date convertie
	 */
	public static LocalDate getBirthday(Scanner sc, String message) {
		String dateStr;
		Matcher matcher;

		do {
			System.out.print(message);
			dateStr = sc.nextLine();

			String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((19|20)\\d\\d)$";
			Pattern pattern = Pattern.compile(regex);
			matcher = pattern.matcher(dateStr);
		} while (!matcher.matches());

		String[] tab = dateStr.split("/");

		int jour = Integer.parseInt(tab[0]);
		int mois = Integer.parseInt(tab[1]);
		int annee = Integer.parseInt(tab[2]);

		return LocalDate.of(annee, mois, jour);
	}

	/**
	 * Cette méthode distribue 5 cartes à chaque joueur
	 */
	private static void distribuerCartes(int nombreDeJoueurs) {

		System.out.println("\n");
		separation();
		System.out.println(" ⦿ Etape n°6 - Distribution de 5 cartes " + (nombreDeJoueurs == 1 ? "au " : "aux ")
				+ (nombreDeJoueurs <= 1 ? "" : nombreDeJoueurs) + (nombreDeJoueurs == 1 ? " joueur" : " joueurs"));
		separation();

		for (int i = 0; i < 5; i++) {
			for (Joueur joueur : joueurs) {
				joueur.getMain().add(cartes.remove(0));
			}
		}
//
//		System.out.println(" ✅ - Vérification de la main "
//				+ (joueurs.size() == 1 ? "du joueur enregistré" : "des joueurs enregistrés"));
//		for (Joueur joueur : joueurs) {
//			System.out.println(" ✅ - " + (joueur.getPseudo() != null && !joueur.getPseudo().isEmpty()
//					? joueur.getPseudo() + " dispose de ce jeu actuellement : " + joueur.getMain()
//					: joueur.getNom().toUpperCase() + " " + joueur.getPrenom() + " dispose de ce jeu actuellement : "
//							+ joueur.getMain()));
//		}
//		
		System.out.println(" ✅ - Distribution terminé.");

	}

	/**
	 * Cette méthode permet d'afficher un Joueur
	 */
	private static void afficherJoueur(int nombreDeJoueurs) {
		System.out.println("\n");
		separation();
		System.out.println(" ⦿ Etape n°7 - Affichage " + (nombreDeJoueurs == 1 ? "du " : "des ")
				+ (nombreDeJoueurs <= 1 ? "" : nombreDeJoueurs) + (nombreDeJoueurs == 1 ? "joueur" : " joueurs"));
		separation();

		for (Joueur joueur : joueurs) {
			System.out.println(" ✅ - " + (joueur.getPseudo() != null && !joueur.getPseudo().isEmpty()
					? joueur.getPseudo() + " dispose de ce jeu actuellement : " + joueur.getMain()
					: joueur.getNom().toUpperCase() + " " + joueur.getPrenom() + " dispose de ce jeu actuellement : "
							+ joueur.getMain()));
		}
	}

	/**
	 * Cette méthode permet de trier les cartes 
	 **/
	private static void trierCartes() {
		Collections.sort(cartes, new ComparateurDeCarteSurValeur());
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

		System.out.print("Occurences de : " + joueur.getPrenom() + " : ");
		for (int i = 0; i < occurrences.length; i++) {
			System.out.print(occurrences[i]);
		}
		
		// Switch pour déterminer si le joueur a obtenu un carré
		System.out.println("Main de : " + joueur.getPrenom() + " : " + joueur);

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
						System.out.println(joueur.getPrenom() + " : FULL" );
						return Combinaison.FULL;
					}
				}
				System.out.println(joueur.getPrenom() + " : BRELAN" );
				return Combinaison.BRELAN;
			} else if (occurrences[i] == 2) {

				for (int j = i; j < occurrences.length; j++) {
					if (occurrences[j] == 2 && j != i) {
						System.out.println(joueur.getPrenom() + " : DOUBLE PAIRE" );
						return Combinaison.DOUBLE_PAIRE;
					}
				}
				System.out.println(joueur.getPrenom() + " : PAIRE" );
				return Combinaison.PAIRE;

			}

			// else if (occurrences[i] == 1 && occurrences[i + 1] == 1 && occurrences[i + 2]
			// == 1 && occurrences[i + 3] == 1 ) {
			//
			// System.out.println("\n\n -------- SUITE \n\n");
			// return Combinaison.SUITE;
			//
			// } else if (occurrences[15] == 1 && occurrences[2] == 1 && occurrences[3] == 1
			// && occurrences[4] == 1 ) {
			//
			// System.out.println("\n\n -------- SUITE \n\n");
			// return Combinaison.SUITE;
			// }
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
			System.out.println(joueur.getPrenom() + " : COULEUR" );
			return Combinaison.COULEUR;
		}
		System.out.println(joueur.getPrenom() + " : CARTE HAUTE" );
		return Combinaison.CARTE_HAUTE;
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

}
