package fr.it_akademy.poker.business;

//Importation des classes nécessaires
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.LocalDate;

/**
 * La classe Joueur représente un joueur de poker. Elle hérite de la classe
 * Personne.
 */
public class Joueur extends Personne {

	// Attributs de la classe joueur
	private String pseudo; // Le pseudo du joueur
	private float solde; // Le solde du joueur
	private List<Carte> main = new ArrayList<>(); // La main du joueur, constituée de cartes

	// =======================================
	// ============= STATIC METHODS
	// =======================================

	@SuppressWarnings("unused")
	private static int compteur = 0; // Compteur pour suivre le nombre total de joueurs créés

	// =======================================
	// ============= CONSTRUCTOR
	// =======================================

	/**
	 * Constructeur par défaut de la classe Joueur. Il crée un joueur sans pseudo ni
	 * solde. Il incrémente également le compteur de joueurs.
	 */
	public Joueur() {
		++compteur;
	}

	/**
	 * Constructeur avec pseudo. Il crée un joueur avec - un pseudo - sans solde.
	 * 
	 * @param String pseudo - Le pseudo du joueur
	 */
	public Joueur(String pseudo) {
		this();
		this.pseudo = pseudo;
	}

	/**
	 * Constructeur avec pseudo et solde. Il crée un joueur avec - un pseudo - un
	 * solde.
	 * 
	 * @param String pseudo - Le pseudo du joueur
	 * @param float  solde - Le solde du joueur
	 */
	public Joueur(String pseudo, float solde) {
		this(pseudo);
		this.solde = solde;
	}

	public Joueur(LocalDate dateDeNaissance, String pseudo, float solde) {
		super(dateDeNaissance);
		this.pseudo = pseudo;
		this.solde = solde;
	}

	public Joueur(String prenom, String nom, LocalDate dateDeNaissance, float solde) {
		super(prenom, nom, dateDeNaissance);
		this.solde = solde;
	}

	/**
	 * Constructeur avec pseudo, solde et main. Il crée un joueur avec - un pseudo,
	 * - un solde - une main de cartes.
	 * 
	 * @param String      pseudo - Le pseudo du joueur
	 * @param float       solde - Le solde du joueur
	 * @param List<Carte> main - La main du joueur
	 */
	public Joueur(String pseudo, float solde, List<Carte> main) {
		this(pseudo, solde);
		this.main = main;
	}

	// =======================================
	// ============= GETTERS
	// =======================================

	/**
	 * Retourne le pseudo du joueur.
	 * 
	 * @return String - Le pseudo du joueur
	 */
	public String getPseudo() {
		return this.pseudo;
	}

	/**
	 * Retourne le solde du joueur.
	 * 
	 * @return double - Le solde du joueur
	 */
	public float getSolde() {
		return this.solde;
	}

	/**
	 * Retourne la main du joueur.
	 * 
	 * @return List<Carte> - La main du joueur
	 */
	public List<Carte> getMain() {
		return this.main;
	}

	// =======================================
	// ============= SETTERS
	// =======================================

	/**
	 * Définit le pseudo du joueur.
	 * 
	 * @param pseudo Le nouveau pseudo du joueur
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Définit le solde du joueur.
	 * 
	 * @param solde Le nouveau solde du joueur
	 */
	public void setSolde(float solde) {
		this.solde = solde;
	}

	/**
	 * Définit la main du joueur.
	 * 
	 * @param main La nouvelle main du joueur
	 */
	public void setMain(List<Carte> main) {
		this.main = main;
	}

	// =======================================
	// ============= METHODS @OVERRIDE
	// =======================================

	/**
	 * Méthode hashCode() surchargée de la classe Object.
	 *
	 * Cette méthode est utilisée pour le calcul du hashcode, qui est généralement
	 * utilisé dans les collections. Elle doit renvoyer le même entier si deux
	 * objets sont égaux.
	 * 
	 * @return Un entier qui est le hashcode de l'objet Joueur.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(main, pseudo, solde);
		return result;
	}

	/**
	 * Méthode equals() surchargée de la classe Object.
	 *
	 * Cette méthode vérifie l'égalité entre l'objet actuel et l'objet passé en
	 * paramètre. Deux objets Joueur sont considérés comme égaux s'ils ont le même
	 * pseudo, le même solde et la même main.
	 * 
	 * @param obj L'objet à comparer avec l'objet actuel.
	 * @return true si les objets sont égaux, false sinon.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		return Objects.equals(main, other.main) && Objects.equals(pseudo, other.pseudo)
				&& Float.compare(this.solde, other.solde) == 0;
	}

	/**
	 * Méthode toString() surchargée de la classe Object.
	 *
	 * Cette méthode retourne une représentation sous forme de chaîne de caractères
	 * de l'objet Joueur. Elle est généralement utilisée pour le débogage et le
	 * logging.
	 * 
	 * @return Une représentation sous forme de chaîne de l'objet Joueur.
	 */
	@Override
	public String toString() {
		return "Joueur [" + (pseudo != null ? "pseudo=" + pseudo + ", " : "") + "solde=" + solde + ", "
				+ (main != null ? "main=" + main : "") + "]";
	}

}
