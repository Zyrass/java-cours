package fr.it_akademy.util;

import java.util.Comparator;

import fr.it_akademy.poker.business.Carte;

public class ComparateurDeCarteSurValeur implements Comparator<Carte> {

	@Override
	public int compare(Carte carte1, Carte carte2) {
		return Integer.valueOf(carte1.getValeur()).compareTo(carte2.getValeur());
	}

}
