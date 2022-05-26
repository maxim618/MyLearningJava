public class Solution {
    public static void main(String[] args) {

        int code   = 50;//data.getCountryPhoneCode();
        long numder =4567890;//(long) data.getPhoneNumber();
        long razrS = (int)Math.log10(numder) + 1;                //разрядность
        long mn = 1;
        //for(int i = 1; i<razrS; i++){mn*=10;};                  //количество 0
        int[]d = new int[10];
        for(int i = 9;i>-1;i--){
            long temp = numder/mn%10;
            mn*=10;
            d[i]=(int)temp;
        }
        String phoneNumber = String.format("%s%d%s%d%d%d%s%d%d%d%s%d%d%s%d%d",
                "+",code,"(",d[0],d[1],d[2],")",d[3],d[4],d[5],"-",d[6],d[7],"-",d[8],d[9]);
        System.out.println(phoneNumber);
    }
}


