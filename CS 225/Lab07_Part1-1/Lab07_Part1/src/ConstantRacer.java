import java.util.Scanner;

public class ConstantRacer extends GenericRacer {
	
	// Attribute that is the constant value the racer is incremented by
	private int moveBy;

	public ConstantRacer(int idNum, String racerType) {
		super(idNum, racerType);
		moveBy = setMoveBy();
		
	}
	
	private int setMoveBy() {
		Scanner scanner = new Scanner(System.in);
		int constant = -1;
		boolean validInput = false;
		while (!validInput) {
			System.out.println("\nEnter the constant value from 3 to 7 for racer #" + getRacerIDNumber());
			constant = scanner.nextInt();
			if ((constant >= 3) && (constant <= 7)) {
				System.out.println("New constant racer moves by " + constant);
				validInput = true;
			} else {
				System.out.println("Invalid number, try again");
			}
		}
		return constant;
	}

	@Override
	protected void move() {
		setLocation(getLocation() + moveBy);		
	}

}
