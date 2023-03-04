/*************************************
 * Class: GenericTile
 * Author: 
 * Date: 3/3/23
 * 
 * Purpose: Parent class for the tiles.
 * 
 * Attributes:  -exits:Boolean[4]
 *              -description:String
 * 
 * Methods: +enterAction():void
 *          +exitAction():void
 *          +specialAction():void
 *          +setExits(ArrayList<Boolean>):void
 *          +getExits():boolean
 *************************************/
//Edits: Added setter and getter for exit
import java.util.ArrayList;

public class GenericTile {
    private boolean[] exits = new boolean[4];
    private String description;

    public void enterAction(){}
    public void exitAction(){}
    public void specialAction(){}

    public void setExits(ArrayList<Boolean> a){
        for(int i = 0; i<4; i++){
            exits[i] = a.get(i);
        }
    }
    public boolean[] getExits(){
        return exits;
    }
}
