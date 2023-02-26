public class RandomRacer extends GenericRacer{

    public RandomRacer(int id) {
        super(id, "random");
    }
    @Override
    public void move(){
        location += (int)(Math.random()*(10)+1);
    }
}
