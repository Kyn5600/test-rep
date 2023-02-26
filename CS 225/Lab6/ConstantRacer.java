/*************************************
 * Class ConstantRacer
 * Author: Zachery Rich and Nathan Wesley
 * Date: 2/26/23
 * 
 * Purpose: Racer class with constant speed.
 * 
 * Attributes:  speed:int
 *              location: int
 * 				racerNumber: int
 * 				racerType: String
 * 
 * Methods: +move():void
 * 			#randomFrom(int,int):int
 * 			+getLocation():int
 * 			+setLocation(int):void
 * 			+getRacerNumber():int
 * 			+setRacerNumber(int):void
 * 			+getRacerType():String
 * 			+setRacerType(String):void
 * 			#printRacer():void
 *************************************/
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
