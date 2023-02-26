import java.util.Scanner;

public class RaceManager {
	
	// Attribute of GenericRacer array to hold all racers
	private GenericRacer[] racersArray;

	public static void main(String[] args) {
		// TODO: Create Manager object and call runProgram()

		RaceManager managerObj = new RaceManager();
		managerObj.raceLineup();

	}
	
	public void raceLineup() {
		// TODO: Ask for user input number of racers
		Scanner scan = new Scanner(System.in);
		System.out.println("Input number of random racers");
		int numOfRandRacers = scan.nextInt();
		System.out.println("Input number of constant racers");
		int numOfConstRacers = scan.nextInt();
		// TODO: Finish defining the racersArray with length of user input (using: racersArray = new ...)
		racersArray = new GenericRacer[numOfRandRacers+numOfConstRacers];

		// TODO: Assign a racer to each element in racersArray
		for(int i=0;i<numOfRandRacers;i++){
			racersArray[i] = new RandomRacer(i+1);
		}
		for(int i=numOfRandRacers-1;i<numOfRandRacers+numOfConstRacers;i++){
			racersArray[i] = new ConstantRacer(i+1);
		}
		// TODO: Call race() method
		startRace();
				
		scan.close();
	}
	
	private void startRace() {
		// Boolean variable to track if race is over
		boolean raceOver = false;
		int winner = -1;
		// While loop to run the race
		while (!raceOver) {
			// TODO: Call all racers move method, print current location, and check if they have crossed the finish line
			for(int i=0;i<racersArray.length;i++){
				racersArray[i].move();

				if(racersArray[i].getLocation()>=100){
					raceOver = true;
					System.out.println("Racer " + racersArray[i].getRacerNumber() + " position: " + racersArray[i].getLocation());
					System.out.println("Racer type: " + racersArray[i].getRacerType());
					winner = racersArray[i].getRacerNumber();
					i = racersArray.length+1;
				} else {
					System.out.println("Racer " + racersArray[i].getRacerNumber() + " position: " + racersArray[i].getLocation());
					System.out.println("Racer type: " + racersArray[i].getRacerType());
				}
			}
		}
		
		// TODO: Print which racer won
		System.out.println("Winner is racer number "+winner);
	}

}
