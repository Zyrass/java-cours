package fr.it_akademy.poker.business;

// Importation des classes nécessaires
import java.time.LocalDate;
import java.util.Objects;

/**
* Classe représentant une personne.
* Cette classe contient des informations générales comme le nom, le prénom et la date de naissance d'une personne.
* Elle sert de classe de base pour d'autres classes comme Joueur.
*/
public class Personne {

    // Attributs de la classe Personne
    private Long id; // Identifiant unique pour chaque personne
    protected String nom; // Nom de la personne
    protected String prenom; // Prénom de la personne
    protected LocalDate dateNaissance; // Date de naissance de la personne

    // Variable statique pour garder une trace du nombre d'instances de la classe Personne
    private static Long compteur = 0L;

    /**
     * Constructeur par défaut de la classe Personne.
     * Il initialise l'identifiant unique pour chaque personne.
     */
	public Personne() {
		super();
		this.id = ++compteur;
	}

    /**
     * Surcharge du constructeur Personne précédent.
     * 
     * @param prenom Le prénom de la personne.
     */
	public Personne(String prenom) {
		this();
		this.prenom = prenom;
	}

    /**
     * Surcharge du constructeur Personne précédent.
     * 
     * @param prenom Le prénom de la personne.
     * @param nom Le nom de la personne.
     */
	public Personne(String prenom, String nom) {
		this(prenom);
		this.nom = nom;
	}

    /**
     * Surcharge du constructeur Personne précédent.
     * 
     * @param prenom Le prénom de la personne.
     * @param nom Le nom de la personne.
     * @param dateNaissance La date de naissance de la personne.
     */
	public Personne(String prenom, String nom, LocalDate dateNaissance) {
		this(prenom, nom);
		this.dateNaissance = dateNaissance;
	}

	// =======================================
	// ============= GETTERS
	// =======================================
	
    /**
     * Retourne l'identifiant de la personne.
     * 
     * @return L'identifiant de la personne.
     */
	public final Long getId() {
	    return this.id;
	}

    /**
     * Retourne le prénom de la personne.
     * 
     * @return Le prénom de la personne.
     */
	public String getPrenom() {
		return prenom;
	}

	  /**
     * Retourne le nom de la personne.
     * 
     * @return Le nom de la personne.
     */
	public String getNom() {
		return nom;
	}

    /**
     * Retourne la date de naissance de la personne.
     * 
     * @return La date de naissance de la personne.
     */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	// =======================================
	// ============= SETTERS
	// =======================================

    /**
     * Définit le prénom de la personne.
     * 
     * @param prenom Le prénom de la personne.
     */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

    /**
     * Définit le nom de la personne.
     * 
     * @param nom Le nom de la personne.
     */
	public void setNom(String nom) {
		this.nom = nom;
	}

    /**
     * Définit la date de naissance de la personne.
     * 
     * @param dateNaissance La date de naissance de la personne
     */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	// =======================================
	// ============= METHODS @OVERRIDE
	// =======================================

    /**
     * Redéfinition de la méthode hashCode() de la classe Object.
     * Elle retourne un code de hachage pour cette instance de Personne, basé sur ses attributs.
     *
     * @return le code de hachage pour cette instance de Personne.
     */
	@Override
	public int hashCode() {
		return Objects.hash(dateNaissance, id, nom, prenom);
	}

    /**
     * Redéfinition de la méthode equals() de la classe Object.
     * Elle permet de vérifier l'égalité entre cette instance de Personne et un autre objet.
     *
     * @param obj L'objet à comparer avec cette instance de Personne.
     * @return true si l'objet est une instance de Personne et a les mêmes valeurs pour tous ses attributs, false sinon.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		return Objects.equals(dateNaissance, other.dateNaissance) && Objects.equals(id, other.id)
				&& Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}

    /**
     * Redéfinition de la méthode toString() de la classe Object.
     * Elle retourne une représentation textuelle de cette instance de Personne, incluant toutes ses informations.
     *
     * @return une chaîne de caractères représentant cette instance de Personne.
     */
	@Override
	public String toString() {
		return "Personne [" + (id != null ? "id=" + id + ", " : "") + (nom != null ? "nom=" + nom + ", " : "")
				+ (prenom != null ? "prenom=" + prenom + ", " : "")
				+ (dateNaissance != null ? "dateNaissance=" + dateNaissance : "") + "]";
	}
}
