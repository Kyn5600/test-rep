import java.util.Random;

public class PrizeBoxes{
    private int value = 0;
    private PrizeBoxes[] num = new PrizeBoxes[30];
    public static void main(String[] args){
        PrizeBoxes prizeBox = new PrizeBoxes();
        prizeBox.setBoxValues();
    }
    private PrizeBoxes[] setBoxValues(){
        Random rand = new Random();

        int min = 20;

        for(int i = 0;i<30;i++){
            num[i] = new PrizeBoxes();
        }

        int randomNum = (int)(rand.nextInt(1000));
        int randomNum2 = (int)(rand.nextInt(1000));
        
        rand.setSeed(randomNum);
        int zeroBoxNum = (int)(rand.nextInt(30));
        num[zeroBoxNum].setValue(0);

        rand.setSeed(randomNum2);
        int negativeBoxNum = (int)(rand.nextInt(30));
        num[negativeBoxNum].setValue(-100);
        

        for(int i = 0; i<30; i++){
            if(i == zeroBoxNum || i == negativeBoxNum){
                i++;
            }
            rand.setSeed(i*randomNum);
            num[i].setValue((int)(rand.nextInt(80))+min);
        }
        return num;
    }

    public int getValue(){
        return value;
    }
    public void setValue(int val){
        this.value = val;
    }
    public PrizeBoxes[] getBoxes(){
        PrizeBoxes[] boxes = this.setBoxValues();
        return boxes;
    }
}
