// Reference to the Scanner class in the java.util package 
import java.util.Scanner; 
public class LabTwoWithInput { 
 public static void main(String[] args) { 
  // Create a scanner for command line input 
  Scanner in = new Scanner(System.in); 
   
  // Print statement that prompts user 
  System.out.println("What is your name?"); 
// Getting name the name and saving it to a variable
  String name = in.nextLine(); 
   
  // Printing the name back 
  System.out.println("Hello there, " + name + "!\n"); 
   
  // Close the scanner 
  in.close(); 
 } 
} 