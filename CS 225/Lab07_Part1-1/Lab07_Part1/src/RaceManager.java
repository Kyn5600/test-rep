import java.util.Scanner;

public class RaceManager {
	
	// Array of racers
	private GenericRacer[] racers;

	
	public static void main(String[] args) {
		
		RaceManager rm = new RaceManager();
		rm.raceLineup();

	}
	
	// Setting up the race
	public void raceLineup() {
		
		Scanner scanner = new Scanner(System.in);
		int constantRacers = 0;
		boolean validInput = false;
		while (!validInput) {
			System.out.println("How many constant racers do you want?");
			constantRacers = scanner.nextInt();
			if (constantRacers < 0) {
				System.out.println("Invalid number, try again");
			} else {
				validInput = true;
			}
		}
		
		int randomRacers = 0;
		validInput = false;
		while (!validInput) {
			System.out.println("How many random racers do you want?");
			randomRacers = scanner.nextInt();
			if (randomRacers < 0) {
				System.out.println("Invalid number, try again");
			} else {
				validInput = true;
			}
		}
		
		
		System.out.println("\nRace contains " + constantRacers + " constant racers and " + randomRacers + " random racers\n");
		int numberOfRacers = constantRacers + randomRacers;
		racers = new GenericRacer[numberOfRacers];
		
		for (int i = 0; i < racers.length; i++) {
			if (i < constantRacers) {
				racers[i] = new ConstantRacer(i+1, "Constant");
			} else {
				racers[i] = new RandomRacer(i+1, "Random");
			}
		}
		
		startRace();
	}

	
	private void startRace() {
		System.out.println("Race starting!");
		int winner = -1;
		boolean raceOver = false;
		int lap = 0;
		while (!raceOver) {
			System.out.println("Lap #" + lap);
			for (int i = 0; i < racers.length; i++) {
				System.out.println("\n Current racer move: ");
				racers[i].move();
				racers[i].printRacer();
				
				if ((racers[i].getLocation() >= 100) && (!raceOver)) {
					raceOver = true;
					winner = racers[i].getRacerIDNumber();
				}
				
			}
			lap++;
			System.out.println();
		}
		System.out.println("The winner is racer #" + winner);
	}

}
