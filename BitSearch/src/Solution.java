/*
Найдем число 2 в максимальной степени
*/

import static java.lang.Integer.MIN_VALUE;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxPowerOf2(140_000));   //131072
        System.out.println(maxPowerOf2(1026));      //1024
        System.out.println(maxPowerOf2(17));        //16
    }

    public static int maxPowerOf2(int x) {
        //Integer.highestOneBit(1);
        System.out.println(String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0'));
        x |= x >> 1;
        System.out.println(String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0'));
        x |= x >> 2;
        System.out.println(String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0'));

        x |= x >> 4;
        System.out.println(String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0'));
        x |= x >> 8;
        System.out.println(String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0'));
        x |= x >> 16;
        System.out.println(String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0'));
        int xx = (x >> 1);
        System.out.println("xx = \n"+String.format("%8s", Integer.toBinaryString(xx)).replace(' ', '0'));
        int x1 = x - xx;
        System.out.println("x : \n"+String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0'));
        System.out.println("x1 = x- xx : \n"+String.format("%8s", Integer.toBinaryString(x1)).replace(' ', '0'));

        return x1;
    }
}
