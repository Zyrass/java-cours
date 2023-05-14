package fr.it_akademy.poker.business;

//Importation des classes nécessaires
import java.util.Objects;

/**
 * Classe représentant une carte de poker. Une carte a une valeur, un nom et une
 * couleur.
 */
public class Carte {

	// Attributs de la classe Carte
	private int valeur; // La valeur de la carte (de 2 à 14)
	private String nom; // Le nom de la carte (de "2" à "10", "Valet", "Dame", "Roi", "As")
	private Couleur couleur; // La couleur de la carte (Carreaux, Coeur, Pique, Trèfle)

	// =======================================
	// ============= CONSTRUCTOR
	// =======================================

	/**
	 * Constructeur de la classe Carte. Ce constructeur crée une carte avec une
	 * valeur et une couleur spécifiques. Le nom de la carte est automatiquement
	 * déduit de la valeur.
	 * 
	 * @param valeur  La valeur de la carte, qui doit être comprise entre 2 et 14.
	 * @param couleur La couleur de la carte, qui doit être une instance de la
	 *                classe Couleur.
	 */
	public Carte(int valeur, Couleur couleur) {
		this.valeur = valeur;
		this.couleur = couleur;

		// Détermination du nom de la carte en fonction de sa valeur
		switch (valeur) {
		case 11:
			this.nom = "Valet";
			break;
		case 12:
			this.nom = "Dame";
			break;
		case 13:
			this.nom = "Roi";
			break;
		case 14:
			// Note : dans le poker, l'As a la plus grande valeur, donc sa valeur est fixée
			// à 14 ici
			this.nom = "As";
			break;
		default:
			// Pour toutes les autres valeurs (de 2 à 10), le nom est simplement la valeur
			// sous forme de chaîne
			this.nom = String.valueOf(valeur);
			break;
		}
	}

	// =======================================
	// ============= GETTERS
	// =======================================

	/**
	 * Retourne la valeur de cette carte.
	 * 
	 * @return La valeur de cette carte, un entier compris entre 2 et 14.
	 */
	public int getValeur() {
		return this.valeur;
	}

	/**
	 * Retourne le nom de cette carte.
	 * 
	 * @return Le nom de cette carte, une chaîne qui peut être "2" à "10", "Valet",
	 *         "Dame", "Roi", ou "As".
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Retourne la couleur de cette carte.
	 * 
	 * @return La couleur de cette carte, une instance de la classe Couleur.
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}

	// =======================================
	// ============= SETTERS
	// =======================================

	/**
	 * Définit la valeur de cette carte.
	 * 
	 * @param valeur La nouvelle valeur de cette carte, qui doit être comprise entre
	 *               2 et 14.
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * Définit lle nom de cette carte.
	 * 
	 * @param nom Le nouveau nom de cette carte, qui doit être une chaîne valide
	 *            ("2" à "10", "Valet", "Dame", "Roi", "As").
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Définit la couleur de cette carte.
	 * 
	 * @param couleur La nouvelle couleur de cette carte, qui doit être une instance
	 *                de la classe Couleur.
	 */
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	// =======================================
	// ============= METHODS @OVERRIDE
	// =======================================

	/**
	 * Cette méthode génère un code de hachage unique pour cette carte en utilisant ses attributs.
	 * Elle est utilisée principalement lors de la manipulation d'ensembles de cartes pour garantir qu'aucune carte n'est dupliquée.
	 *
	 * @return Un entier qui représente le code de hachage unique de cette carte.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(couleur, nom, valeur);
	}

	/**
	 * Cette méthode vérifie si cette carte est égale à un autre objet.
	 * Elle renvoie vrai si l'objet est une carte avec la même valeur, le même nom et la même couleur.
	 *
	 * @param obj L'objet à comparer avec cette carte.
	 * @return Un booléen indiquant si cette carte est égale à l'objet spécifié.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		return Objects.equals(couleur, other.couleur) && Objects.equals(nom, other.nom) && valeur == other.valeur;
	}

	/**
	 * Cette méthode retourne une représentation sous forme de chaîne de caractères de cette carte.
	 * Elle affiche la valeur, le nom et la couleur de la carte.
	 *
	 * @return Une chaîne représentant cette carte, sous la forme "Carte [valeur=V, nom=N, couleur=C]".
	 */
	@Override
	public String toString() {
		return "✅ " + nom + " de" + couleur;
	}

}
