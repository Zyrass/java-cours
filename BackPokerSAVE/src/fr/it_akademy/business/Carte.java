package fr.it_akademy.business;

public class Carte {

	/**
	 * Attributs
	 */
	private int valeur;
	private String nom;
	private Couleur couleur;

	/**
	 * =============================================== CONSTRUCTOR
	 */

	/**
	 * Constructeur de ma classe Carte
	 * 
	 * @param String nom
	 * @param int    valeur
	 */
	public Carte(int valeur, Couleur couleur) {

		switch (valeur) {
		case 1:
			this.setNom("AS");
			break;
		case 2:
			this.setNom("2");
			break;
		case 3:
			this.setNom("3");
			break;
		case 4:
			this.setNom("4");
			break;
		case 5:
			this.setNom("5");
			break;
		case 6:
			this.setNom("6");
			break;
		case 7:
			this.setNom("7");
			break;
		case 8:
			this.setNom("8");
			break;
		case 9:
			this.setNom("9");
			break;
		case 10:
			this.setNom("10");
			break;
		case 11:
			this.setNom("Valet");
			break;
		case 12:
			this.setNom("Dame");
			break;
		case 13:
			this.setNom("Roi");
			break;
		default:
			this.setNom("Joker");
		} // end switch

		this.valeur = valeur;
		this.couleur = couleur;
	}

	/**
	 * =============================================== GETTERS
	 */

	/**
	 * Retourne le nom de la carte
	 * 
	 * @return String
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Retourne la valeur de la carte
	 * 
	 * @return int
	 */
	public int getValeur() {
		return this.valeur;
	}

	/**
	 * Retourne la couleur de la carte
	 * 
	 * @return String
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}

	/**
	 * =============================================== SETTERS
	 */

	/**
	 * Edite le nom de la carte
	 * 
	 * @param String nom
	 */
	public void setNom(String value) {
		this.nom = value;
	}

	/**
	 * Edite la valeur de la carte
	 * 
	 * @param int valeur
	 */
	public void setValeur(int value) {
		this.valeur = value;
	}

}