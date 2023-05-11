package fr.it_akademy.poker.business;

//import java.util
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Joueur {

	// Attributs
	private Long id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private float solde;
	private List<Carte> main = new ArrayList<>();
	
	// =======================================
	// ============= STATIC METHODS
	// =======================================

	public static Long compteur = 0L;

	// =======================================
	// ============= CONSTRUCTOR
	// =======================================
	
	/**
	 * Constructeur d'origine de la classe Joueur
	 */
	public Joueur() {
		this.id = ++compteur;
	}

	/**
	 * Surcharge du constructeur principal
	 * 
	 * @param String nom
	 */
	public Joueur(String nom) {
		this();
		this.nom = nom;
	}

	/**
	 * Surcharge du constructeur Joueur précédent
	 * 
	 * @param String nom
	 * @param String prenom
	 */
	public Joueur(String nom, String prenom) {
		this(nom);
		this.prenom = prenom;
	}

	/**
	 * Surcharge du constructeur Joueur précédent
	 * 
	 * @param String nom
	 * @param String prenom	
	 * @param LocalDate dateNaissance
	 */
	public Joueur(String nom, String prenom, LocalDate dateNaissance) {
		this(nom, prenom);
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Surcharge du constructeur Joueur précédent
	 * 
	 * @param String nom
	 * @param String prenom	
	 * @param LocalDate dateNaissance
	 * @param float solde
	 */
	public Joueur(String nom, String prenom, LocalDate dateNaissance, float solde) {
		this(nom, prenom, dateNaissance);
		this.solde = solde;
	}

	/**
	 * Surcharge du constructeur Joueur précédent
	 * 
	 * @param String nom
	 * @param String prenom	
	 * @param LocalDate dateNaissance
	 * @param float solde
	 * @param List<Carte> main
	 */
	public Joueur(String nom, String prenom, LocalDate dateNaissance, float solde, List<Carte> main) {
		this(nom, prenom, dateNaissance, solde);
		this.main = main;
	}

	// =======================================
	// ============= GETTERS
	// =======================================

	/**
	 * Affiche l'identifiance du joueur
	 * 
	 * @return Long
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Affiche la nom du joueur
	 * 
	 * @return String
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Affiche la prénom du joueur
	 * 
	 * @return String
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Affiche la date de naissance du joueur
	 * 
	 * @return LocalDate
	 */
	public LocalDate getDateNaissance() {
		return this.dateNaissance;
	}

	/**
	 * Affiche le solde du joueur
	 * 
	 * @return double
	 */
	public float getSolde() {
		return this.solde;
	}

	/**
	 * Affiche la main d'un joueur
	 * 
	 * @return List<Carte>
	 */
	public List<Carte> getMain() {
		return this.main;
	}

	// =======================================
	// ============= SETTERS
	// =======================================

	/**
	 * Edite l'identifiance du joueur
	 * 
	 * @param Long id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Edite la nom du joueur
	 * 
	 * @param String nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Edite la prénom du joueur
	 * 
	 * @param String nom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Edite la date de naissance du joueur
	 * 
	 * @param LocalDate dateNaissance
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Edite le solde du joueur
	 * 
	 * @param double solde
	 */
	public void setSolde(float solde) {
		this.solde = solde;
	}

	/**
	 * Edite la main d'un joueur
	 * 
	 * @param List<Carte> main
	 */
	public void setMain(List<Carte> main) {
		this.main = main;
	}

	// =======================================
	// ============= METHODS
	// =======================================

	@Override
	public int hashCode() {
		return Objects.hash(dateNaissance, id, main, nom, prenom, solde);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Joueur other = (Joueur) obj;
		return Objects.equals(dateNaissance, other.dateNaissance) && Objects.equals(id, other.id)
				&& Objects.equals(main, other.main) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom)
				&& Float.floatToIntBits(solde) == Float.floatToIntBits(other.solde);
	}

	@Override
	public String toString() {
		return "Joueur [ id = " + id + ", nom = " + nom + ", prenom = " + prenom + ", dateNaissance = " + dateNaissance
				+ ", solde = " + solde + ", main = " + main + " ]";
	}

}
