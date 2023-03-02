import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class MGMain {
    private GameController ctrl;

    private static void main(String[] args){
        GameController gc = new GameController();
        Scanner scan = new Scanner(System.in);

        System.out.println("Read from file or randomize maze? (Input file or random)");
        String mazeOrRand = scan.nextLine();

        if(scan.equals("file")){
            System.out.println("Enter Filename: ");
            String filename = scan.nextLine();
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

        }
        scan.close();
    }
    private void createMaze(int a,int b){}
    private void createMaze(int a,int b, boolean c){}
    private boolean isMazeLegal(int a,int b){}
    //private void createAgent(Agent a){}
    private void playGame(){}
}