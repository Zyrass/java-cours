package fr.it_akademy.poker.business;

//Importation des classes nécessaires
import java.util.Objects;

/**
 * La classe Ville représente une ville avec ses différentes caractéristiques.
 * Cette classe contient plusieurs constructeurs pour permettre différentes
 * façons de créer une instance de Ville.
 */
public class Ville {

	// Attributs de la classe Ville
	private Long id; // L'identifiant unique de la ville
	private String nom; // Le nom de la ville
	private String codePostal; // Le code postal de la ville
	private double latitude; // La latitude de la ville
	private double longitude; // La longitude de la ville
	private double altitude; // L'altitude de la ville

	// =======================================
	// ============= STATIC METHODS
	// =======================================

	// Variable statique pour garder une trace du nombre total de villes créées
	private static Long compteur = 0L; // Autoboxing

	// =======================================
	// ============= CONSTRUCTOR
	// =======================================

	/**
	 * Constructeur par défaut de la classe Ville. Il initialise l'ID de la ville et
	 * incrémente le compteur de villes.
	 */
	public Ville() {
		this.id = ++compteur;
	}

	/**
	 * Constructeur de la classe Ville qui prend le nom de la ville en paramètre.
	 * 
	 * @param nom Le nom de la ville
	 */
	public Ville(String nom) {
		this();
		this.nom = nom;
	}

	/**
	 * Constructeur de la classe Ville qui prend le nom et le code postal de la
	 * ville en paramètres.
	 * 
	 * @param nom        Le nom de la ville
	 * @param codePostal Le code postal de la ville
	 */
	public Ville(String nom, String codePostal) {
		this(nom);
		this.codePostal = codePostal;
	}

	/**
	 * Constructeur de la classe Ville qui prend le nom, le code postal, la latitude
	 * et la longitude de la ville en paramètres.
	 * 
	 * @param nom        Le nom de la ville
	 * @param codePostal Le code postal de la ville
	 * @param latitude   La latitude de la ville
	 * @param longitude  La longitude de la ville
	 */
	public Ville(String nom, String codePostal, double latitude, double longitude) {
		this(nom, codePostal);
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Constructeur de la classe Ville qui prend le nom, le code postal, la
	 * latitude, la longitude et l'altitude de la ville en paramètres.
	 * 
	 * @param nom        Le nom de la ville
	 * @param codePostal Le code postal de la ville
	 * @param latitude   La latitude de la ville
	 * @param longitude  La longitude de la ville
	 * @param altitude   L'altitude de la ville
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
	 * Retourne l'identifiant de la ville
	 * 
	 * @return L'identifiant unique de la ville de type Long.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Retourne le nom de la ville
	 * 
	 * @return Le nom de la ville de type String.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Retourne le code postale de la ville
	 * 
	 * @return Le code postal de la ville de type String.
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Retourne la lattitude de la ville
	 * 
	 * @return La latitude de la ville de type double.
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Retourne la longitudede la ville
	 * 
	 * @return La longitude de la ville de type double.
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Retourne l'altitude de la ville
	 * 
	 * @return L'altitude de la ville de type double.
	 */
	public double getAltitude() {
		return altitude;
	}

	// =======================================
	// ============= SETTERS
	// =======================================

	/**
	 * Définit l'identifiant de la ville
	 * 
	 * @param id L'identifiant unique de la ville à définir.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Définit le nom de la ville
	 * 
	 * @param nom Le nom de la ville à définir.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Définit le code postale de la ville
	 * 
	 * @param codePostal Le code postal de la ville à définir.
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Définit la latitude de la ville
	 * 
	 * @param latitude La latitude de la ville à définir.
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Définit la longitude de la ville
	 * 
	 * @param longitude La longitude de la ville à définir.
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Définit l'altitude de la ville
	 * 
	 * @param altitude L'altitude de la ville à définir.
	 */
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	// =======================================
	// ============= METHODS
	// =======================================

	/**
	 * Cette méthode génère une valeur de hachage pour cette instance de Ville, qui
	 * est utilisée dans certaines collections Java, comme HashMap. Elle utilise
	 * tous les champs de l'objet pour générer une valeur de hachage unique.
	 *
	 * @return Une valeur de hachage pour cette instance de Ville.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(altitude, codePostal, id, latitude, longitude, nom);
	}

	/**
	 * Cette méthode compare cet objet Ville avec un autre objet pour vérifier s'ils
	 * sont égaux. Deux objets Ville sont considérés comme égaux s'ils ont les mêmes
	 * valeurs pour tous leurs champs.
	 *
	 * @param obj L'objet à comparer avec cet objet Ville.
	 * @return true si les deux objets sont égaux, false sinon.
	 */
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

	/**
	 * Cette méthode fournit une représentation sous forme de chaîne de caractères
	 * de l'objet Ville, qui peut être utile pour le débogage. Elle inclut toutes
	 * les informations sur la Ville.
	 *
	 * @return Une chaîne de caractères qui représente l'objet Ville.
	 */
	@Override
	public String toString() {
		return "Ville [ id = " + id + ", nom = " + nom + ", codePostal = " + codePostal + ", latitude = " + latitude
				+ ", longitude = " + longitude + ", altitude = " + altitude + " ]";
	}

}
