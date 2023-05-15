package fr.it_akademy.verbes_irreguliers.alain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import fr.it_akademy.business.alain.NomColonneVerbesCSV;
import fr.it_akademy.business.alain.Partie;
import fr.it_akademy.business.alain.Question;
import fr.it_akademy.business.alain.Verbe;

public class App {

	// Liste de tous les verbes irréguliers
	private static List<Verbe> verbes = new ArrayList<>();
	// Scanner pour lire l'entrée de l'utilisateur
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("\n Bienvenue sur verbes irréguliers !");

		// dérouler d'une partie
		importerVerbes();
		compterLeNombreDeVerbes();
		separation();
		nouveauJeu();
		sc.close();
	}
	
	/**
	 * Affiche une ligne séparatrice
	 */
	private static void separation() {
		System.out.println("\n ========================================================================================= \n");
	}

	/**
	 * Permet d'importer une liste de 161 verbes irréguliers en anglais
	 */
	public static void importerVerbes() {
		
		try {
			URL url = new URL("https://www.clelia.fr/verbes.csv");
			InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");
			BufferedReader readerBuffered = new BufferedReader(reader);
		
			try (readerBuffered) {

				String ligne;
				
				// Lire chaque ligne du fichier CSV et créer un objet Verbe
				while( (ligne = readerBuffered.readLine()) != null) {
					String[] colonne = ligne.split(",");
					
					String baseVerbale = colonne[NomColonneVerbesCSV.BASE_VERBALE.ordinal()];
					String participePasse = colonne[NomColonneVerbesCSV.PARTICIPE_PASSE.ordinal()];
					String preterit = colonne[NomColonneVerbesCSV.PRETERIT.ordinal()];
					String traductionFR = colonne[NomColonneVerbesCSV.TRADUCTION_FR.ordinal()];
					
					Verbe verbe = new Verbe(baseVerbale, participePasse, preterit, traductionFR);
					verbes.add(verbe);
				}
			}
		} catch (Exception e) {
			// En cas d'erreur lors de la lecture du fichier, afficher un message d'erreur
			System.out.println("Une erreur est survenue : " + e.getMessage());
		}
	}
	
	/**
	 * Permet d'afficher le nombre de verbes dans la liste de verbes
	 */
	public static void compterLeNombreDeVerbes() {
		System.out.println(" Nombre de verbes irréguliers disponibles : " + verbes.size());
	}
	
	/**
	 * Permet de démarrer un nouveau jeux
	 */
	public static void nouveauJeu() {
	    // Commencer une nouvelle partie
	    System.out.println(" Nouvelle partie !");

	    // Créer une nouvelle instance de Partie
	    Partie partie = new Partie();

	    // Demander à l'utilisateur combien de questions il souhaite pour cette partie
	    System.out.print(" Combien de verbes pour cette partie ? ");
	    int nombreDeVerbes = sc.nextInt();
	    sc.nextLine();  // Consommer le retour à la ligne restant
	    partie.setNbQuestionsSouhaitees(nombreDeVerbes);

	    // Créer une nouvelle instance de Random pour générer des nombres aléatoires
	    Random rand = new Random();

	    // Pour chaque question, sélectionner un verbe aléatoire et poser la question à l'utilisateur
	    for (int i = 0; i < nombreDeVerbes; i++) {
	        int indexVerbe = rand.nextInt(verbes.size());
	        Verbe verbe = verbes.get(indexVerbe);
	        
	        // Créer une nouvelle instance de Question
	        Question question = new Question();
	        question.setDateHeureEnvoi(LocalDateTime.now());
	        question.setVerbe(verbe);

	        // Poser la question à l'utilisateur
	        System.out.print(" Question " + (i+1) + " : donnez le prétérit et le participe passé du verbe " 
	                           + verbe.getBaseVerbale() + " (" + verbe.getTraduction() + ") : ");
	        String reponse = "";
	        String[] reponseSplit;
	        // Insister pour que l'utilisateur donne deux réponses séparées par une virgule
	        do {
	            reponse = sc.nextLine();
	            reponseSplit = reponse.split(",");
	            if (reponseSplit.length != 2) {
	                System.out.println(" /¡\\ Erreur : Veuillez entrer deux réponses séparées par une virgule.");
	            }
	        } while (reponseSplit.length != 2);

	        // Enregistrer les réponses de l'utilisateur
	        question.setResponsePreterit(reponseSplit[0].trim());
	        question.setReponseParticipePasse(reponseSplit[1].trim());

	        // Enregistrer l'heure de la réponse
	        question.setDateHeureReponse(LocalDateTime.now());

	        // Vérifier si les réponses de l'utilisateur sont correctes
	        if (verbe.getPreterit().equalsIgnoreCase(question.getResponsePreterit()) && 
	            verbe.getParticipePasse().equalsIgnoreCase(question.getReponseParticipePasse())) {
	            // Si les réponses sont correctes, augmenter le score de l'utilisateur et afficher un message de félicitation
	            System.out.println(" Bravo ! Score : " + (partie.getScore() + 1) + "/" + (i+1));
	            partie.setScore(partie.getScore() + 1);
	        } else {
	            // Si les réponses sont incorrectes, afficher un message d'erreur
	            System.out.println(" /!\\ Erreur: Ce n’est pas la bonne réponse. Score final : " + partie.getScore() + "/" + (i+1));
	        }
	        // Ajouter la question à la liste des questions de la partie
	        partie.questions.add(question);
	    }

	    // Calculer le temps moyen de réponse
	    long totalTime = 0;
	    // Parcourir toutes les questions posées lors de la partie
	    for (Question question : partie.questions) {
	        // Ajouter le temps de réponse à la variable totalTime (calculée en secondes)
	        totalTime += Duration.between(question.getDateHeureEnvoi(), question.getDateHeureReponse()).getSeconds();
	    }
	    // Afficher le temps moyen de réponse
	    System.out.println(" Temps moyen de réponse : " + (double) totalTime / partie.questions.size() + " secondes.");

	    // Afficher l'historique des verbes demandés lors de la partie
	    System.out.println(" Historique des verbes demandés :");
	    for (Question question : partie.questions) {
	        System.out.println("\t- " + question.getVerbe().getBaseVerbale() + " " 
	                           + question.getVerbe().getPreterit() + " " 
	                           + question.getVerbe().getParticipePasse());
	    }
	    
	    // Demander à l'utilisateur s'il souhaite jouer une nouvelle partie
	    questionNouvellePartie();

	}
	
	/**
	 * Permet de demander à l'utilisateur de faire ou non une nouvelle partie
	 */
	public static void questionNouvellePartie() {
	    System.out.print(" Souhaitez-vous faire une nouvelle partie (O/N) ? ");
	    String nouvellePartie = sc.nextLine();
	    
	    // Si l'utilisateur souhaite jouer une nouvelle partie, rappeler la méthode nouveauJeu()
	    if (nouvellePartie.equalsIgnoreCase("O")) {
	        nouveauJeu();
	    } else {
	        // Sinon, afficher un message de fin et terminer le programme
	        System.out.println(" Au revoir");
	    }
	}
}
