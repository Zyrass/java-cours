package fr.it_akademy.fr.horloge_de_berlin;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Donne moi l'heure qu'il est : ");
		
		int hour = sc.nextInt();
		int validHour = hour <= 0 || hour > 23 ? 0 : hour;
		
		int nbHour5 = hour / 5;
		int nbHour1 = hour % 5;
		
		System.out.print("Donne moi les minutes : ");
		int minutes = sc.nextInt();
		int validMinutes = minutes <= 0 || minutes > 59 ? 0 : minutes;
		
		int nbMinutes5 = minutes / 5;
		int nbMinutes1 = minutes % 5;
		
		
		System.out.print("\nIl est " + validHour + "h" + validMinutes + "\n");
		
		sc.close();
		
		System.out.println("\n --------- HORLOGE DE BERLIN ----------\n");
		
		getLines(nbHour5, 5);
		getLines(nbHour1, 4);
		getLines(nbMinutes5, 11);
		getLines(nbMinutes1, 4);

	}
	
	public static void getLines(int number, int totalCaseNumber) {
		
		for ( int i = 0; i < totalCaseNumber; i++ ) {
			if ( i < number ) {
				System.out.print("[X]");
			} else {
				System.out.print("[ ]");
			}
		}
		System.out.println("\n");
	}

}
