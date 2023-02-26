/*************************************
 * Class RandomRacer
 * Author: Zachery Rich and Nathan Wesley
 * Date: 2/26/23
 * 
 * Purpose: Racer class with random speed.
 * 
 * Attributes:  location: int
 *              racerNumber: int
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
public class RandomRacer extends GenericRacer{

    public RandomRacer(int id) {
        super(id, "random");
    }
    @Override
    public void move(){
        location += (int)(Math.random()*(10)+1);
    }
}
