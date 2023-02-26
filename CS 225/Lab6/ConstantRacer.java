public class ConstantRacer extends GenericRacer{
    private int speed;
    public ConstantRacer(int id) {
        super(id, "constant");
        speed = (int)(Math.random()*(4)+3);
    }
    @Override
    public void move(){
        location += speed;
    }
}
