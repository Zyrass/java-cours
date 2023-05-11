package fr.it_akademy.business;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class Joueur {

	// Attributs
	//	private UUID id = UUID.randomUUID();
	private Long id;
	private String nom;
	private float solde;
	private Ville ville;
	private LocalDate dateNaissance;
	private List<Carte> main = new ArrayList<>();

	/**
	 * =============================================== CONSTRUCTOR
	 */

	/**
	 * Constructeur de ma classe Joueur
	 * 
	 * @param String 	nom
	 * @param float		solde
	 * @param LocalDate	dateNaissance
	 * @param Ville		ville
	 */
	public Joueur(String nom, float solde, LocalDate dateNaissance, Ville ville) {
		//		this.id = UUID.randomUUID();
		this.nom = nom;
		this.solde = solde;
		this.ville = ville;
		this.dateNaissance = dateNaissance;
	}

	/**
	 * =============================================== GETTERS
	 */

	/**
	 * Retourne l'id du joueur
	 * 
	 * @return UUID
	 */
	public UUID getId() {
		return this.id;
	}

	/**
	 * Retourne le nom du joueur
	 * 
	 * @return String
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * retourne le solde du joueur
	 * 
	 * @return float
	 */
	public float getSolde() {
		return this.solde;
	}

	/**
	 * Retourne la date de naissance du joueur
	 * 
	 * @return LocalDate
	 */
	public LocalDate getDateNaissance() {
		return this.dateNaissance;
	}

	/**
	 * =============================================== SETTERS
	 */

	/**
	 * Edite le nom du joueur
	 * 
	 * @param String value
	 */
	public void setNom(String value) {
		this.nom = value;
	}

	/**
	 * Edite le solde du joueur
	 * 
	 * @param float value
	 */
	public void setSolde(float value) {
		this.solde = value;
	}

	/**
	 * Edite la date de naissance du joueur
	 * 
	 * @param LocalDate value
	 */
	public void setDateNaissance(LocalDate value) {
		this.dateNaissance = value;
	}

	/**
	 * =============================================== SET ???
	 */

	/**
	 * 
	 */
	private Set<Carte> main;

}