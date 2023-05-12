package fr.it_akademy.greeting;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        
        // Création d'une nouvelle instance de la classe Person
        Person person1 = new Person();
        
        // Demande du prénom à l'utilisateur
        askFirstName(person1);
        // Demande du nom de famille à l'utilisateur
        askLastName(person1);
        // Demande de l'âge à l'utilisateur
        askYear(person1);
        
        // Affichage d'un message de salutation à l'utilisateur
        System.out.println("\n");
        System.out.println("Bonjour " + person1.getFirstName() + " " + person1.getLastName());
        System.out.println("Tu as " + person1.getYear() + " ans.");

    }
    
    /**
     * Méthode pour demander le prénom à l'utilisateur
     * @param Person
     */
    public static void askFirstName(Person person) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nQuel est ton prénom ? ");
        person.setFirstName(sc.nextLine());
        
        // Fermeture du scanner pour libérer les ressources
        sc.close();
    }
    
    /**
     * Méthode pour demander le nom à l'utilisateur
     * @param Person
     */
    public static void askLastName(Person person) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nQuel est ton nom de famille ? ");
        person.setLastName(sc.nextLine());
        
        // Fermeture du scanner pour libérer les ressources
        sc.close();
    }
    
    /**
     * Méthode pour demander l'âge à l'utilisateur
     * @param Person
     */
    public static void askYear(Person person) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nQuel est ton âge ? ");
        person.setYear(sc.nextInt());
        
        // Fermeture du scanner pour libérer les ressources
        sc.close();
    }

}

