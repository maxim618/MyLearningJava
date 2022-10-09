import java.util.ArrayList;

public class Solution {

   public static  ArrayList<Character> arrayList = new ArrayList<>();

   public  static  void myRearranges(int prefix){
      while (prefix!=0){
          arrayList.add(0, (char) (prefix % 10+'0'));
          prefix/=10;
      }


}
    public static void main(String[] args) {

       myRearranges(123);
       System.out.println(arrayList.toString());
       int digit = 1000000;
        for(int arm_num = 0 ; arm_num < digit ; arm_num++)
        {
            String[] data = String.valueOf(arm_num).split("");

            int length = data.length;

            int arm_t_num = 0;

            int[] ary = new int[length];

            for(int i = 0 ; i < length ; i++)
            {
                int parseIntData = Integer.parseInt(data[i]);

                ary[i] = parseIntData;

                for(int x = 0 ; x < length-1 ; x++)
                {
                    ary[i] = ary[i] * parseIntData;
                }

                arm_t_num+=ary[i];
            }

            if(arm_num == arm_t_num)
            {
                System.out.println("Number is ArmStrong : "+arm_num);
            }
        }


    }
}
