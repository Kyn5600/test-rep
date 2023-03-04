/*************************************
 * Class: GameController
 * Author: 
 * Date: 3/3/23
 * 
 * Purpose: Controls the maze generation.
 * 
 * Attributes:  -maze:GenericTile[][]
 *              -agent:GenericAgent
 *              -agentLocation:int[2]
 *              -turnCounter:int
 *              -exitStrings:String[][][]
 *              +tempString:String
 *              +tempBool:Boolean
 * 
 * Methods: +playGame():void
 *          +agentIsInGoal():boolean
 *          +hasAgentWon():boolean
 *          +hasAgentLost():boolean
 *          +moveAgent:void
 *          +isMoveLegal():boolean
 *          +isDoorLocked(GenericTile, int):boolean
 *          +createMaze(int, int):void
 *          +createMaze(int,int,ArrayList<Boolean>):void
 *          +printMaze():void
 *          +printMazeSummary():void
 *          +convertExitsToString():void
 *          +printAgentLocation():void
 *          +setAgent(Agent):void
 *************************************/
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
            for(int j = 0; j<b;j++){
                maze[i][j] = new GenericTile();
            }
        }
        exitStrings = new String[a][b][4];
    }
    public void createMaze(int a,int b, ArrayList<Boolean> c){
        maze[a][b].setExits(c);
    }
    public void printMaze(){
        convertExitstoString();
        for(int i = 0; i<maze.length;i++){
            for(int j = 0; j<maze[0].length;j++){
                System.out.println("Tile (" + i + ", " + j + ") (N,S,E,W) Status: (" + exitStrings[i][j][0] + ", " + exitStrings[i][j][1] + ", " + exitStrings[i][j][2] + ", " + exitStrings[i][j][3] + ")");
            }
        }
    }
    public void printMazeSummary(){}
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
