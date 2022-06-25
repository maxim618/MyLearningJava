package task1;

public class Main {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int[]array = new int[n*n+1];
        int j = 1;
        for(int i = 0;i< array.length; i++){
            array[i]= j;
            j++;
            if(j==n+1)j = 1;
        }
        for(int i = 0;i<array.length;i += m - 1){
            if(i!=0&&array[i]==1)break;
            System.out.print(array[i]);
        }
    }
}
