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
