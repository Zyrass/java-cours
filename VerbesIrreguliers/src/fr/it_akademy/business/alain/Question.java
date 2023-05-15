package fr.it_akademy.business.alain;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * La classe Question représente une question posée lors d'une partie du jeu.
 * Chaque question est liée à un verbe, et contient les réponses fournies par
 * l'utilisateur.
 */
public class Question {

	// Attributs
	private Long id;
	private String responsePreterit;
	private String reponseParticipePasse;
	private LocalDateTime dateHeureEnvoi;
	private LocalDateTime dateHeureReponse;
	private static Long compteur = 0L;
	private Partie partie;
	private Verbe verbe;

	/**
	 * =========================================================================
	 * CONSTRUCTEURS
	 * =========================================================================
	 */

	/**
	 * Constructeur par défaut de la classe Question. Incrémente le compteur de
	 * questions.
	 */
	public Question() {
		if (compteur == null) {
	        compteur = 0L;
	    }
	    ++compteur;
	    
		this.id = compteur;
	}

	/**
	 * =========================================================================
	 * GETTERS & SETTERS
	 * =========================================================================
	 */

	/**
	 * @return
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @param value
	 */
	public void setId(Long value) {
		this.id = value;
	}

	/**
	 * @return
	 */
	public String getResponsePreterit() {
		return this.responsePreterit;
	}

	/**
	 * @param value
	 */
	public void setResponsePreterit(String value) {
		this.responsePreterit = value;
	}

	/**
	 * @return
	 */
	public String getReponseParticipePasse() {
		return this.reponseParticipePasse;
	}

	/**
	 * @param value
	 */
	public void setReponseParticipePasse(String value) {
		this.reponseParticipePasse = value;
	}

	/**
	 * @return
	 */
	public LocalDateTime getDateHeureEnvoi() {
		return this.dateHeureEnvoi;
	}

	/**
	 * @param value
	 */
	public void setDateHeureEnvoi(LocalDateTime value) {
		this.dateHeureEnvoi = value;
	}

	/**
	 * @return
	 */
	public LocalDateTime getDateHeureReponse() {
		return this.dateHeureReponse;
	}

	/**
	 * @param value
	 */
	public void setDateHeureReponse(LocalDateTime value) {
		this.dateHeureReponse = value;
	}

	/**
	 * @return
	 */
	public Partie getPartie() {
		return this.partie;
	}

	/**
	 * @param value
	 */
	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	/**
	 * @return
	 */
	public Verbe getVerbe() {
		return this.verbe;
	}

	/**
	 * @param value
	 */
	public void setVerbe(Verbe verbe) {
		this.verbe = verbe;
	}

	/**
	 * =========================================================================
	 * METHODS OVERRIDE
	 * =========================================================================
	 */

	@Override
	public int hashCode() {
		return Objects.hash(dateHeureEnvoi, dateHeureReponse, id, partie, reponseParticipePasse, responsePreterit,
				verbe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(dateHeureEnvoi, other.dateHeureEnvoi)
				&& Objects.equals(dateHeureReponse, other.dateHeureReponse) && Objects.equals(id, other.id)
				&& Objects.equals(partie, other.partie)
				&& Objects.equals(reponseParticipePasse, other.reponseParticipePasse)
				&& Objects.equals(responsePreterit, other.responsePreterit) && Objects.equals(verbe, other.verbe);
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", responsePreterit=" + responsePreterit + ", reponseParticipePasse="
				+ reponseParticipePasse + ", dateHeureEnvoi=" + dateHeureEnvoi + ", dateHeureReponse="
				+ dateHeureReponse + ", partie=" + partie + ", verbe=" + verbe + "]";
	}
}