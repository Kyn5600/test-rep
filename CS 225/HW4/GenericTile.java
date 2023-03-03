//Edits: Added setter and getter for exit


public class GenericTile {
    private boolean[] exits = new boolean[4];
    private String description;

    public void enterAction(){}
    public void exitAction(){}
    public void specialAction(){}

    public void setExits(boolean[] a){
        exits = a;
    }
    public boolean[] getExits(){
        return exits;
    }
}
