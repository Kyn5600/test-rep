//Edits: Removed both createMaze methods. Reason: Redundant for GameController createMaze methods.

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class MGMain {
    private GameController ctrl;

    public static void main(String[] args){
        MGMain ctrl = new MGMain();
        Random rnd = new Random();
        rnd.setSeed(rnd.nextLong());
        GameController gc = new GameController();
        Scanner scan = new Scanner(System.in);

        System.out.println("Read from file or randomize maze? (Input file or random)");
        String mazeOrRand = scan.nextLine();

        if(mazeOrRand.equals("file")){
            // Assume file is CSV or text file set up like this:
            // x,y,True,True,False,False
            // or x,y,l,u,u,l
            //System.out.println("Enter Filename: ");
            //String filename = scan.nextLine();
            //FileReader fr = new FileReader(filename);
            //BufferedReader br = new BufferedReader(fr);
            //...
        } else if(mazeOrRand.equals("random")){
            ArrayList<Boolean> isLockedTrue = new ArrayList<Boolean>();
            System.out.println("What size would you like the maze to be? Please enter an odd number.");
            double size = scan.nextDouble();
            if(size % 2 != 0){
                gc.createMaze((int)size, (int)size);
                for(int i = 0; i<size*size;i++){
                    for(int j = 0; j<size;j++){
                        for(int k=0;k<4;k++){
                            if(j>0){
                                isLockedTrue.set(k,rnd.nextBoolean());
                            }else{
                                isLockedTrue.add(rnd.nextBoolean());
                            }
                        }
                        gc.createMaze(i,j,isLockedTrue);
                    }
                }
                gc.printMaze();
            }
        }
        scan.close();
    }
    //private boolean isMazeLegal(int a,int b){}
    //private void createAgent(Agent a){}
    //private void playGame(){}
}