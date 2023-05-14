package fr.it_akademy.poker.business;

// Importation des classes nécessaires
import java.util.Objects;

/**
 * Classe représentant une couleur dans un jeu de cartes.
 * Chaque couleur a un nom (par exemple, "Coeur" ou "Pique") et un symbole associé.
 */
public class Couleur {

	// Attributs de la classe Couleur
	private String nom;
	private String symbol;
	private static final String[] FORME_LOGO_COULEUR = { "♦", "♥", "♠", "♣" };

	// =======================================
	// ============= CONSTRUCTOR
	// =======================================

	/**
	 * Constructeur de la classe Couleur qui initialise le nom et le symbole de la couleur.
	 * Le symbole est déterminé en fonction du nom de la couleur.
	 * 
	 * @param nom Le nom de la couleur. Doit être "Carreaux", "Coeur", "Pique" ou "Trèfle".
	 * @throws IllegalArgumentException si le nom n'est pas l'un des quatre noms de couleur valides.
	 */
	public Couleur(String nom) {
		this.nom = nom;

		switch (this.nom) {
		case "Carreaux":
			this.setSymbol(0);
			break;
		case "Coeur":
			setSymbol(1);
			break;
		case "Pique":
			setSymbol(2);
			break;
		case "Trèfle":
			setSymbol(3);
			break;
		default:
			throw new IllegalArgumentException("Nom de couleur invalide: " + nom);
		}
	}

	// =======================================
	// ============= GETTERS
	// =======================================

	/**
	 * Retourne le nom de la couleur.
	 * 
	 * @return Le nom de la couleur.
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Retourne le symbole associé à la couleur.
	 * 
	 * @return Le symbole de la couleur.
	 */
	public String getSymbol() {
		return this.symbol;
	}

	// =======================================
	// ============= SETTERS
	// =======================================

	/**
	 * Définit le nom de la couleur
	 * 
	 * @param String value
	 */
	public void setNom(String value) {
		this.nom = value;
	}

	/**
	 * Définit le symbole de la couleur en utilisant une position donnée dans le tableau de symboles.
	 * 
	 * @param positionFormeLogoCouleur L'indice du symbole dans le tableau.
	 * @throws IllegalArgumentException si l'indice est hors des limites du tableau.
	 */
	public void setSymbol(int positionFormeLogoCouleur) {

		if (positionFormeLogoCouleur < 0 || positionFormeLogoCouleur >= FORME_LOGO_COULEUR.length) {
			throw new IllegalArgumentException(
					"Position de forme de logo de couleur invalide: " + positionFormeLogoCouleur);
		}
		this.symbol = FORME_LOGO_COULEUR[positionFormeLogoCouleur];
	}

	// =======================================
	// ============= METHODS @OVERRIDE
	// =======================================

    /**
     * Redéfinition de la méthode hashCode() de la classe Object.
     * Elle retourne un code de hachage pour cette instance de Couleur, basé sur ses attributs.
     *
     * @return le code de hachage pour cette instance de Couleur.
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Objects.hash(nom, symbol);
		return result;
	}

    /**
     * Redéfinition de la méthode equals() de la classe Object.
     * Elle permet de vérifier l'égalité entre cette instance de Couleur et un autre objet.
     *
     * @param obj L'objet à comparer avec cette instance de Couleur.
     * @return true si l'objet est une instance de Couleur et a les mêmes valeurs pour tous ses attributs, false sinon.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Couleur other = (Couleur) obj;
		return Objects.equals(nom, other.nom) && Objects.equals(symbol, other.symbol);
	}
	
    /**
     * Redéfinition de la méthode toString() de la classe Object.
     * Elle retourne une représentation textuelle de cette instance de Couleur, incluant toutes ses informations.
     *
     * @return une chaîne de caractères représentant cette instance de Couleur.
     */
	@Override
	public String toString() {
		return " " + (symbol != null ? symbol : "");
	}

}
