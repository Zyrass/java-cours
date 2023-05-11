package fr.it_akademy.poker.business;

//import java.util
import java.util.Objects;

public class Couleur {

	// Attributs
	private String nom;

	// =======================================
	// ============= CONSTRUCTOR
	// =======================================

	/**
	 * Constructeur d'origine de la classe Couleur
	 * 
	 * @param String nom
	 */
	public Couleur(String nom) {
		this.nom = nom;
	}

	// =======================================
	// ============= GETTERS
	// =======================================

	/**
	 * Affiche le nom de la couleur
	 * 
	 * @return String
	 */
	public String getNom() {
		return this.nom;
	}

	// =======================================
	// ============= SETTERS
	// =======================================

	/**
	 * Edite le nom de la couleur
	 * 
	 * @param String value
	 */
	public void setNom(String value) {
		this.nom = value;
	}

	// =======================================
	// ============= METHODS @OVERRIDE
	// =======================================

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Couleur other = (Couleur) obj;
		return Objects.equals(nom, other.nom);

	}

	@Override
	public String toString() {
		return "Couleur [ nom = " + nom + " ]";
	}

}
