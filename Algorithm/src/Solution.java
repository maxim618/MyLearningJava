public class Solution {
    private static boolean isValid=true;

    public static void main(String[] args) throws InterruptedException {
        validStringNumber("12345p");

        System.out.println(isValid);
        isValid=true;
    }
    private static void validStringNumber(String data) throws InterruptedException {
        char[]ch = data.toCharArray();
        for (char c:ch){
            int d = (int)c;
            System.out.println(d);
            if (d<48||d>57){
                isValid=false;
            }else {
                isValid=true;
            }
        }
    }
}
