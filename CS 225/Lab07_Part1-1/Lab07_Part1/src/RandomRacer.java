
public class RandomRacer extends GenericRacer {
	
	
	public RandomRacer(int idNum, String racerType) {
		super(idNum, racerType);
		
	}

	@Override
	protected void move() {
		setLocation((int) (getLocation() + randomFrom(1, 10)));	
	}

}
