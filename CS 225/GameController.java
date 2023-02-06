import java.util.Scanner;

public class GameController {
    private int score = 0;
    public static void main(String[] args){
        GameController gameController = new GameController();
        gameController.pickBoxes();
        gameController.test1();
    }

    public void pickBoxes(){
        PrizeBoxes prizeBox = new PrizeBoxes();
        PrizeBoxes[] boxes = prizeBox.getBoxes();

        Scanner scan = new Scanner(System.in);
        for(int i=0; i<5;i++){
            String number = "0";
            int j = i+1;
            switch(j){
                case(1):
                    number = "st";
                break;
                case(2):
                    number = "nd";
                break;
                case(3):
                    number = "rd";
                break;
                default:
                    number = "th";
                break;
            }
            System.out.println("Enter " + j + number + " box:");
            int box1 = scan.nextInt();
            int boxVal = boxes[box1-1].getValue();
            System.out.println("Box " + box1 + " value: " + boxVal);
            score +=boxVal;
            if(i!=4)
                System.out.println("Current Score: " + score);
        }
        scan.close();
        System.out.println("Final score: " + score);
    }
    public void test1(){
        PrizeBoxes prizeBox = new PrizeBoxes();
        PrizeBoxes[] testboxes1 = prizeBox.getBoxes();
        for(int i=0; i<30; i++){
            testboxes1[i].setValue(101);
        }
        for(int i=0; i<30; i++){
            if(testboxes1[i].getValue()>100){
                System.out.println("At least one box has a value greater then 100");
                i=30;
            }
        }
    }
}
