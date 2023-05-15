package fr.it_akademy.business.alain;

import java.util.Objects;

/**
 * 
 */
public class Verbe {

	// Attributs
	private Long id;
	private String baseVerbale;
	private String preterit;
	private String participePasse;
	private String traduction;
	private static Long compteur;

	/**
	 * =========================================================================
	 * CONSTRUCTEURS
	 * =========================================================================
	 */

	/**
	 * Default constructor
	 */
	public Verbe() {
		if (compteur == null) {
	        compteur = 0L;
	    }
	    ++compteur;
	    
		this.id = compteur;
	}

	public Verbe(String baseVerbale, String participePasse, String preterit, String traduction) {
		this();
		this.baseVerbale = baseVerbale;
		this.participePasse = participePasse;
		this.preterit = preterit;
		this.traduction = traduction;
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
	public String getBaseVerbale() {
		return this.baseVerbale;
	}

	/**
	 * @param value
	 */
	public void setBaseVerbale(String value) {
		this.baseVerbale = value;
	}

	/**
	 * @return
	 */
	public String getParticipePasse() {
		return this.participePasse;
	}

	/**
	 * @param value
	 */
	public void setParticipePasse(String value) {
		this.participePasse = value;
	}

	/**
	 * @return
	 */
	public String getPreterit() {
		return this.preterit;
	}

	/**
	 * @param value
	 */
	public void setPreterit(String value) {
		this.preterit = value;
	}

	/**
	 * @return
	 */
	public String getTraduction() {
		return this.traduction;
	}

	/**
	 * @param value
	 */
	public void setTraduction(String value) {
		this.traduction = value;
	}

	/**
	 * @return
	 */
	public Long getCompteur() {
		return compteur;
	}

	/**
	 * =========================================================================
	 * METHODS OVERRIDE
	 * =========================================================================
	 */
	
	@Override
	public int hashCode() {
		return Objects.hash(baseVerbale, id, participePasse, preterit, traduction);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Verbe other = (Verbe) obj;
		return Objects.equals(baseVerbale, other.baseVerbale) && Objects.equals(id, other.id)
				&& Objects.equals(participePasse, other.participePasse) && Objects.equals(preterit, other.preterit)
				&& Objects.equals(traduction, other.traduction);
	}

	@Override
	public String toString() {
		return "Verbe [id=" + id + ", baseVerbale=" + baseVerbale + ", preterit=" + preterit + ", participePasse="
				+ participePasse + ", traduction=" + traduction + "]";
	}

	
}