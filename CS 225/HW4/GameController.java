//Edits: Changed createMaze(int,int,boolean) to (int,int,ArrayList<Boolean>)
//       Added String[][] exitStrings for array of exitStrings for convertExitstoString()
//       Changed convertExitString() to void

import java.util.ArrayList;

public class GameController {
    private GenericTile[][] maze;
    private String[][][] exitStrings;
    //private GenericAgent agent;
    //private int[] agentLocation = new int[2];
    private int turnCounter;

    //public void playGame(){}
    //public boolean agentIsInGoal(){}
    //public boolean hasAgentWon(){}
    //public boolean hasAgentLost(){}
    //public void moveAgent(){}
    //public boolean isMoveLegal(){}
    //public boolean isDoorLocked(GenericTile a, int b){}
    public void createMaze(int a,int b){
        maze = new GenericTile[a][b];
        for(int i = 0; i<a;i++){
            for(int j = 0;i<b;i++){
                maze[i][j] = new GenericTile();
            }
        }
        exitStrings = new String[a][b][4];
    }
    public void createMaze(int a,int b, ArrayList<Boolean> c){
        boolean[] tempBool = {c.get(0),c.get(1),c.get(2),c.get(3),};
        maze[a][b].setExits(tempBool);
    }
    public void printMaze(){
        for(int i = 0; i<maze.length;i++){
            for(int j = 0; j<maze[0].length;j++){
                System.out.println("Tile (" + i + ", " + j + ") (N,S,E,W) Status: (" + exitStrings[i][j][1] + ", " + exitStrings[i][j][2] + ", " + exitStrings[i][j][3] + ", " + exitStrings[i][j][4] + ")");
            }
        }
    }
    public void printMazeSummary(){

    }
    public void convertExitstoString(){
        String tempString;

        for(int i = 0; i<maze.length;i++){
            for(int j = 0; j<maze[0].length;j++){
                boolean[] tempBool  = maze[i][j].getExits();
                for(int k = 0;k<4;k++){
                    if(tempBool[k]){
                        tempString = "True";
                    }
                    else {
                        tempString = "False";
                    }
                    exitStrings[i][j][k] = tempString;
                }
            }
        }
    }
    //public void printAgentLocation(){}
    //public void setAgent(Agent a){}
}
