import java.util.Scanner;

public class LabTwoWithMethod {

    public static void main(String[] args){
        LabTwoWithMethod lab2 = new LabTwoWithMethod();
        lab2.runProgram();
    }
    public void runProgram() {
        Scanner in = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = in.nextLine();
        System.out.println("Hello there, " + name + "!\n");

        in.close();
    }

}

