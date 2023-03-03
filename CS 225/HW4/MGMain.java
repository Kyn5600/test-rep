//Edits: Removed both createMaze methods. Reason: Redundant for GameController createMaze methods.

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class MGMain {
    private GameController ctrl;

    public static void main(String[] args) throws FileNotFoundException{
        MGMain ctrl = new MGMain();
        Random rnd = new Random();
        rnd.setSeed(rnd.nextLong());
        GameController gc = new GameController();
        Scanner scan = new Scanner(System.in);

        System.out.println("Read from file or randomize maze? (Input file or random)");
        String mazeOrRand = scan.nextLine();
        mazeOrRand = mazeOrRand.toLowerCase();

        if(mazeOrRand.equals("file")){
            // Assume file is CSV or text file set up like this:
            // x,y,True,True,False,False

            System.out.println("Enter Filename: ");
            String filename = scan.nextLine();
            File file = new File(filename);
            int length = (int)file.length();
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            
            gc.createMaze(length, length);

            String row;
            while ((row = br.readLine() ) != null) {
                String[] cols = row.split(",");
                int x = Integer.parseInt(cols[0]);
                int y = Integer.parseInt(cols[1]);
                ArrayList<Boolean> fileBool = new ArrayList<Boolean>();
                for(int i = 3;i<7;i++)
                    fileBool.add(Boolean.parseBoolean(cols[i]));
                gc.createMaze(x, y,fileBool);
            }
            br.close();
            fr.close();
        } else if(mazeOrRand.equals("random")){
            ArrayList<Boolean> isLockedTrue = new ArrayList<Boolean>();
            System.out.println("What size would you like the maze to be? Please enter an odd number.");
            double size = scan.nextDouble();
            if(size % 2 != 0){
                gc.createMaze((int)size, (int)size);
                for(int i = 0; i<size;i++){
                    for(int j = 0; j<size;j++){
                        if (j == 0) {
                            for (int l = 0; l < 4; l++) {
                                isLockedTrue.add(rnd.nextBoolean());
                            }
                        } else {
                            for (int l = 0; l < 4; l++) {
                                isLockedTrue.set(l, rnd.nextBoolean());
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