package fr.it_akademy.poker.business;

//import java.util
import java.util.Objects;

public class Ville {

	// Attributs
	private Long id;
	private String nom;
	private String codePostal;
	private double latitude;
	private double longitude;
	private double altitude;

	// =======================================
	// ============= STATIC METHODS
	// =======================================

	// l'objet compteur est une variable de classe
	// il existe en un seul exemplaire
	// tous les objets de type Ville vont pointer
	// vers le même espace mémoire pour accéder au compteur
	public static Long compteur = 0L; // Autoboxing

	// =======================================
	// ============= CONSTRUCTOR
	// =======================================

	/**
	 * Constructeur d'origine de la classe Ville On note la présence de plusieurs
	 * constructeurs on a fait une surcharge de constructeurs (overload) Default
	 * constructor : constructeur par défaut un constructeur sans paramètre
	 */
	public Ville() {

		// D'abord on incrémente puis on affecte
		this.id = ++compteur;
		// Evite d'avoir deux lignes soit :

		// compteur++;
		// id = compteur;
	}

	/**
	 * Surcharge du constructeur principal
	 * 
	 * @param String nom
	 */
	public Ville(String nom) {
		this(); // Ici on ré-utilise le constructeur précédent
		this.nom = nom;
	}

	/**
	 * Surcharge du constructeur précédent
	 * 
	 * @param String nom
	 * @param String codePostal
	 */
	public Ville(String nom, String codePostal) {
		this(nom);
		this.codePostal = codePostal;
	}

	/**
	 * Surcharge du constructeur précédent
	 * 
	 * @param String nom
	 * @param String codePostal
	 * @param double latitude
	 * @param double longitude
	 * @param double altitude
	 */
	public Ville(String nom, String codePostal, double latitude, double longitude, double altitude) {
		this(nom, codePostal);
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}

	// =======================================
	// ============= GETTERS
	// =======================================

	/**
	 * Affiche l'identifiant de la ville
	 * 
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Affiche le nom de la ville
	 * 
	 * @return String
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Affiche le code postale de la ville
	 * 
	 * @return String
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Affiche la lattitude de la ville
	 * 
	 * @return double
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Affiche la longitudede la ville
	 * 
	 * @return double
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Affiche l'altitude de la ville
	 * 
	 * @return double
	 */
	public double getAltitude() {
		return altitude;
	}

	// =======================================
	// ============= SETTERS
	// =======================================

	/**
	 * Edite l'identifiant de la ville
	 * 
	 * @param Long id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Edite le nom de la ville
	 * 
	 * @param String nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Edite le code postale de la ville
	 * 
	 * @param String codePostal
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Edite la latitude de la ville
	 * 
	 * @param double latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Edite la longitude de la ville
	 * 
	 * @param double longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Edite l'altitude de la ville
	 * 
	 * @param double altitude
	 */
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	// =======================================
	// ============= METHODS
	// =======================================

	// chaque objet a un code barre
	// représentation technique
	@Override
	public int hashCode() {
		return Objects.hash(altitude, codePostal, id, latitude, longitude, nom);
	}

	// représentation fonctionnelle
	// la méthode equals va nous servir à faire
	// des comparaisons pour pouvoir trier les villes
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Ville other = (Ville) obj;
		return Double.doubleToLongBits(altitude) == Double.doubleToLongBits(other.altitude)
				&& Objects.equals(codePostal, other.codePostal) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(latitude) == Double.doubleToLongBits(other.latitude)
				&& Double.doubleToLongBits(longitude) == Double.doubleToLongBits(other.longitude)
				&& Objects.equals(nom, other.nom);
	}

	@Override
	public String toString() {
		return "Ville [ id = " + id + ", nom = " + nom + ", codePostal = " + codePostal + ", latitude = " + latitude
				+ ", longitude = " + longitude + ", altitude = " + altitude + " ]";
	}

}
