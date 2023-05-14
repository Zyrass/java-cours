package fr.it_akademy.poker.business;

/**
 * Enumération représentant les différentes combinaisons possibles dans un jeu de poker.
 * Ces combinaisons sont classées par ordre croissant de valeur, allant de la carte haute à la quinte flush royale.
 */
public enum Combinaison {
	// La combinaison la plus faible, où aucune autre combinaison n'est possible. La valeur de la main est déterminée par la carte la plus haute.
	CARTE_HAUTE,
	
	// Une paire de cartes de la même valeur.
	PAIRE,
	
	// Deux paires de cartes de la même valeur.
	DOUBLE_PAIRE,
	
	// Trois cartes de la même valeur.
	BRELAN,
	
	// Cinq cartes consécutives, indépendamment de leur couleur.
	SUITE,
	
	// Cinq cartes de la même couleur, indépendamment de leur valeur.
	COULEUR,
	
	// Une paire et un brelan dans la même main.
	FULL,
	
	// Quatre cartes de la même valeur.
	CARRE,
	
	// Cinq cartes consécutives de la même couleur.
	QUINTE_FLUSH,
	
	// Une suite de la même couleur allant de 10 à l'As.
	QUINTE_FLUSH_ROYALE
}
