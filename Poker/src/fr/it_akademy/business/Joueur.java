package fr.it_akademy.business;


import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Joueur {

    /**
     * Default constructor
     */
    public Joueur() {
    }

    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private float solde;

    /**
     * 
     */
    private LocalDate dateNaissance;

    /**
     * 
     */
    private Ville ville;

    /**
     * 
     */
    private Set<Carte> main;

    /**
     * @return
     */
    public Long getId() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setId(Long value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getNom() {
        // TODO implement here
        return "";
    }

    /**
     * @param value
     */
    public void setNom(String value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public float getSolde() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @param value
     */
    public void setSolde(float value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public LocalDate getDateNaissance() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setDateNaissance(LocalDate value) {
        // TODO implement here
    }

}