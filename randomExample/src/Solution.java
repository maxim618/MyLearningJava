
public class Solution {



    public static void main(String[] args) throws InterruptedException {

        int randomDigit = 5;

        for(int i = 0; i<10; i++){
            System.out.println((int)(Math.random() * randomDigit));
            Thread.sleep(500);
        }
    }
}
