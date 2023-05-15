package fr.it_akademy.util;

import java.util.Comparator;

import fr.it_akademy.poker.business.Joueur;

public class ComparateurDeJoueurSurPrenom implements Comparator<Joueur> {

	@Override
	public int compare(Joueur joueur1, Joueur joueur2) {
		int value = 0;
		
		if (joueur1.getPseudo().isEmpty() && joueur2.getPseudo().isEmpty()) {
			value = String.valueOf(joueur1.getPrenom()).compareTo(joueur2.getPrenom());
		} else {
			value = String.valueOf(joueur1.getPrenom()).compareTo(joueur2.getPrenom());
		}
		
		return value;
	}

}
