package fr.it_akademy.business;

import java.util.Objects;

public class Ville {

	// Attributs
	private Long id;
	private String nom;
	private String codePostal;
	private double latitude;
	private double longitude;
	private double altitude;

	// l'objet compteur est une variable de classe
	// il existe en un seul exemplaire
	// tous les objets de type Ville vont pointer
	// vers le même espace mémoire pour accéder au compteur
	private static Long compteur = 0L; // Autoboxing

	// Constructeur(s)
	// On note la présence de plusieurs constructeurs
	// on a fait une surcharge de constructeurs (overload)
	// Default constructor : constructeur par défaut
	// un constructeur sans paramètre
	public Ville() {
		// d'abord on incrémente puis on affecte
		id = ++compteur;
		// équivalent à :
		// compteur++;
		// id=compteur;
	}

	/**
	 * Ce constructeur crée une ville en utilisant le nom donné en paramètre
	 * 
	 * @param nom
	 */
	public Ville(String nom) {
		this();
		this.nom = nom;
	}

	public Ville(String nom, String codePostal) {
		this(nom);
		this.codePostal = codePostal;
	}

	public Ville(String nom, String codePostal, double latitude, double longitude, double altitude) {
		this(nom, codePostal);
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}

	// Getters et Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

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
		return "Ville [id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", altitude=" + altitude + "]";
	}

}