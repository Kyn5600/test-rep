package Lab6;

public class GenericRacer {

	// TODO: Create attributes
	private int location;
	private int racerNumber;
	private String racerType = "";

	// TODO: Create Constructor
	public GenericRacer(int id, String type){
		location = 0;
		racerNumber = id;
		racerType = type;
	} 
	// TODO: Create move() method
	// Note: Use: Math.random()*10 to get random number from 0 to 10
	protected void move(){
	}
	protected int randomFrom(int min, int max){
		double randomNum = Math.random() * (max - min) +min;
		return (int)(randomNum);
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
