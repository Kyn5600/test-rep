package Lab6;
import java.util.Scanner;

public class RaceManager {
	
	// Attribute of GenericRacer array to hold all racers
	private GenericRacer[] racersArray;

	public static void main(String[] args) {
		// TODO: Create Manager object and call runProgram()

		RaceManager managerObj = new RaceManager();
		managerObj.runProgram();

	}
	
	public void runProgram() {
		// TODO: Ask for user input number of racers
		Scanner scan = new Scanner(System.in);
		System.out.println("Input number of racers");
		int numOfRacers = scan.nextInt();

		// TODO: Finish defining the racersArray with length of user input (using: racersArray = new ...)
		racersArray = new GenericRacer[numOfRacers];

		// TODO: Assign a racer to each element in racersArray
		for(int i=0;i<numOfRacers;i++){
			racersArray[i] = new GenericRacer(i+1,"random");
		}

		// TODO: Call race() method
		race();
				
		scan.close();
	}
	
	private void race() {
		// Boolean variable to track if race is over
		boolean raceOver = false;
		int winner = -1;
		// While loop to run the race
		while (!raceOver) {
			// TODO: Call all racers move method, print current location, and check if they have crossed the finish line
			for(int i=0;i<racersArray.length;i++){
				racersArray[i].move();

				if(racersArray[i].getLocation()>=20){
					raceOver = true;
					System.out.println("Racer " + racersArray[i].getRacerNumber() + " position: " + racersArray[i].getLocation());
					winner = racersArray[i].getRacerNumber();
					i = racersArray.length+1;
				} else {
					System.out.println("Racer " + racersArray[i].getRacerNumber() + " position: " + racersArray[i].getLocation());
				}
			}
		}
		
		// TODO: Print which racer won
		System.out.println(winner);
	}

}
