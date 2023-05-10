package fr.it_akademy.greeting;

public class Person {
    
	// Attributs
    private String firstName;
    private String lastName;
    private int year;
    
    /**
     * Méthode pour obtenir le prénom
     * @return String
     */
    public String getFirstName() {
        return this.firstName;
    }
    
    /**
     * Méthode pour obtenir le nom de famille
     * @return String
     */
    public String getLastName() {
        return this.lastName;
    }
    
    /**
     * Méthode pour obtenir l'âge
     * @return int
     */
    public int getYear() {
        return this.year;
    }
    
    /**
     * Méthode pour définir le prénom
     * @param String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }
    
    /**
     * Méthode pour définir le nom de famille
     * @param String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName.toUpperCase();
    }
    
    /**
     * Méthode pour définir l'âge
     * @param int
     */
    public void setYear(int year) {
        this.year = year;
    }
}
