
public class GenericRacer {
	
	// Attributes
	protected int racerIDNumber;
	protected int location;
	protected String racerType;
	
	// Constructor
	public GenericRacer(int idNum, String racerType) {
		this.racerIDNumber = idNum;
		this.location = 0;
		this.racerType = racerType;
	}
	
	// Method that returns a random number between the min and max provided
	protected int randomFrom(int min, int max) {
		double randomNum = Math.random() * (max - min) + min;
		return (int) randomNum;
	}
	
	// Method to print the racers information
	protected void printRacer() {
		System.out.println("  Racer type: " + getRacerType());
		System.out.println("  Racer ID number: " + getRacerIDNumber());
		System.out.println("  Location: " + getLocation());
		
	}
	
	// Move method that gets override in the child classes
	protected void move() {
		
	}
	
	// Getters/Setters--->
	public int getRacerIDNumber() {
		return racerIDNumber;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public String getRacerType() {
		return racerType;
	}

	public void setRacerType(String racerType) {
		this.racerType = racerType;
	}

}
