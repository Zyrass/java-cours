package fr.it_akademy.business;

import java.util.Set;

public class Couleur {

	// Attributs
	private String nom;

	/**
	 * =============================================== CONSTRUCTOR
	 */

	/**
	 * Constructeur de ma classe Couleur
	 * 
	 * @param String nom
	 */
	public Couleur(String nom) {
		this.nom = nom;
	}

	/**
	 * =============================================== GETTERS
	 */

	/**
	 * Retourne le nom de la couleur
	 * 
	 * @return String
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * =============================================== SETTERS
	 */

	/**
	 * Edite le nom de la couleur
	 * 
	 * @param String nom
	 */
	public void setNom(String value) {
		this.nom = value;
	}

	/**
	 * =============================================== SET ????
	 */

	/**
	 * ??????????????????
	 */
	private Set<Carte> cartes;

}