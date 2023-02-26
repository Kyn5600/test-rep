public class GenericRacer {

	// TODO: Create attributes
	protected int location;
	protected int racerNumber;
	protected String racerType = "";

	// TODO: Create Constructor
	public GenericRacer(int id, String type){
		location = 0;
		racerNumber = id;
		racerType = type;
	} 
	// TODO: Create move() method
	// Note: Use: Math.random()*10 to get random number from 0 to 10
	public void move(){
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
	public String getRacerType(){
		return racerType;
	}	
	public void setRacerType(String racerType){
		this.racerType = racerType;
	}
	protected void printRacer(){
		System.out.println(this.getRacerType());
		System.out.println(this.getRacerNumber());
		System.out.println(this.getLocation());
	}
}
