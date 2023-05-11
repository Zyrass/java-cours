package fr.it_akademy.poker.business;

//import java.util
import java.util.Objects;

public class Carte {

	// Attributs
	private int valeur;
	private String nom;
	private Couleur couleur;

	// =======================================
	// ============= CONSTRUCTOR
	// =======================================

	/**
	 * Ce constructeur construit un objet de type Carte en déduisant le nom de la
	 * carte à l'aide de la valeur donnée en paramètre
	 * 
	 * @param valeur
	 * @param couleur
	 */
	public Carte(int valeur, Couleur couleur) {
		this.valeur = valeur;
		this.couleur = couleur;

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
			// L'AS != 1 mais === 14
			this.nom = "As";
			break;
		default:
			// Commence à 2 jusqu'à 10
			this.nom = String.valueOf(valeur);
			break;
		}
	}

	// =======================================
	// ============= GETTERS
	// =======================================

	/**
	 * Affiche la valeur de la carte
	 * 
	 * @return int
	 */
	public int getValeur() {
		return this.valeur;
	}

	/**
	 * Affiche le nom de la carte
	 * 
	 * @return String
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Affiche la couleur de la carte
	 * 
	 * @return Couleur
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}

	// =======================================
	// ============= SETTERS
	// =======================================

	/**
	 * Edite la valeur de la carte
	 * 
	 * @param int valeur
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * Edite le nom de la carte
	 * 
	 * @param String nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Edite la couleur de la carte
	 * 
	 * @param Couleur couleur
	 */
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	// =======================================
	// ============= METHODS
	// =======================================

	@Override
	public int hashCode() {
		return Objects.hash(couleur, nom, valeur);
	}

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

	@Override
	public String toString() {
		// Big up Marc !
		return nom + " de " + couleur.getNom();
	}

}
