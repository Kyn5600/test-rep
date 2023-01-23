/*************************************
 * Class SurfaceAreaCalculator
 * Author: Zachery Rich
 * 
 * Purpose: Calculate surface area of 3 user defined dimensions as well as 3 test cases.
 * 
 * Attributes: l,w,h, userl, userw, userh, SA, SASI, userSA, userSASI, test1SA, test1SASI, test2SA, test2SASI, test3SA, test3SASI, scan
 * 
 * Methods: SA, SASI, main
 */

import java.util.Scanner;

public class SurfaceAreaCalculator{
    public static int SA(int l,int w, int h){
        int SA = l*h+w*h+l*w;
        SA *= 2;
        return SA;
    }
    public static double SASI(int SA){
        double SASI = SA*2.54*2.54;
        SASI *= 100;
        SASI = Math.round(SASI);
        SASI /=100;
        return SASI;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Input variable Length: ");
        int userl = scan.nextInt(); 
        
        System.out.println("Input variable Width: ");
        int userw = scan.nextInt(); 

        System.out.println("Input variable Height: ");
        int userh = scan.nextInt(); 

        int userSA = SA(userl,userw,userh);
        double userSASI = SASI(userSA);
        System.out.println("\nUser defined SA = " + userSA + " square inches");
        System.out.println("User defined SASI = " + userSASI + " square centimeters");
        

        int test1SA = SA(0,0,0);
        double test1SASI = SASI(test1SA);
        System.out.println("\nTest 1 SA = " + test1SA + " square inches");
        System.out.println("Test 1 SASI = " + test1SASI + " square centimeters");
        if(test1SA == 0 && test1SASI == 0.0){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        int test2SA = SA(15,10,0);
        double test2SASI = SASI(test2SA);
        System.out.println("\nTest 2 SA = " + test2SA + " square inches");
        System.out.println("Test 2 SASI = " + test2SASI + " sqaure centimeters");
        if(test2SA == 300 && test2SASI == 1935.48){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        int test3SA = SA(10,1,1);
        double test3SASI = SASI(test3SA);
        System.out.println("\nTest 3 SA = " + test3SA + " square inches");
        System.out.println("Test 3 SASI = " + test3SASI + " square centimeters");
        if(test3SA == 42 && test3SASI == 270.97){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
    
}