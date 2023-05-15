package fr.it_akademy.business.alain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * La classe Partie représente une partie du jeu. Chaque partie contient un ensemble
 * de questions, ainsi qu'un score et un compteur pour suivre les progrès du joueur.
 */
public class Partie {

	// Attributs
	private Long id;
	private int nbQuestionsSouhaitees;
	private int score;
	private Long compteur;

	public List<Question> questions;

	/**
	 * =========================================================================
	 * CONSTRUCTEURS
	 * =========================================================================
	 */

	/**
	 * Default constructor
	 */
	public Partie() {
		if (compteur == null) {
	        compteur = 0L;
	    }
	    ++compteur;
	    	
		this.id = compteur;
	    this.questions = new ArrayList<>();
	}

	/**
	 * =========================================================================
	 * GETTERS
	 * =========================================================================
	 */
	
	/**
	 * @return value
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @return
	 */
	public int getNbQuestionsSouhaitees() {
		return this.nbQuestionsSouhaitees;
	}

	/**
	 * @return
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * @return
	 */
	public Long getCompteur() {
		return this.compteur;
	}

	/**
	 * =========================================================================
	 * SETTERS
	 * =========================================================================
	 */
	
	/**
	 * @param value
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param value
	 */
	public void setNbQuestionsSouhaitees(int value) {
		this.nbQuestionsSouhaitees = value;
	}

	/**
	 * @param value
	 */
	public void setScore(int value) {
		this.score = value;
	}

	/**
	 * @param value
	 */
	public void setCompteur(Long value) {
		this.compteur = value;
	}
	
	/**
	 * =========================================================================
	 * METHODS OVERRIDE
	 * =========================================================================
	 */

	@Override
	public int hashCode() {
		return Objects.hash(compteur, id, nbQuestionsSouhaitees, questions, score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partie other = (Partie) obj;
		return Objects.equals(compteur, other.compteur) && Objects.equals(id, other.id)
				&& nbQuestionsSouhaitees == other.nbQuestionsSouhaitees && Objects.equals(questions, other.questions)
				&& score == other.score;
	}

	@Override
	public String toString() {
		return "Partie [id=" + id + ", nbQuestionsSouhaitees=" + nbQuestionsSouhaitees + ", score=" + score
				+ ", compteur=" + compteur + ", questions=" + questions + "]";
	}
	
}