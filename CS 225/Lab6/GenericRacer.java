package Lab6;

public class GenericRacer {

	// TODO: Create attributes
	private int location;
	private int racerNumber;


	// TODO: Create Constructor
	public GenericRacer(int loc, int num){
		location = loc;
		racerNumber = num;
	}
	// TODO: Create move() method
	// Note: Use: Math.random()*10 to get random number from 0 to 10
	public void move(){
		location+=Math.random()*10;
	}
	// TODO: Generate Getters and Setters
	public int getLocation(){
		return location;
	}	
	public void setLocation(int location){
		this.location = location;
	}
	public int getRacerNumber(){
		return racerNumber;
	}	
	public void setRacerNumber(int racerNumber){
		this.racerNumber = racerNumber;
	}
	
}
