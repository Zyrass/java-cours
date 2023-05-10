package fr.it_akademy.hello_world;

public class App {
	
	
	private String firstName;
	private String lastName;
	private int year;
	

	public static void main(String[] args) {
		
		App myNewApp = new App();
		
		myNewApp.setFirstName("Tarek");
		myNewApp.setLastName("Taguine");
		myNewApp.setYear(28);
		
		System.out.println("\n");
		System.out.println("Bonjour " + myNewApp.getFirstName() + " " + myNewApp.getLastName());
		System.out.println("Tu as " + myNewApp.getYear() + " ans.");

	}
	
	// GETTERS
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public int getYear() {
		return this.year;
	}
	
	// SETTERS
	public void setFirstName(String firstName) {
		this.firstName = firstName.trim();
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName.toUpperCase();
	}
	
	public void setYear(int year) {
		this.year = year;
	}

}
