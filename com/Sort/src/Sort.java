import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sort {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.valueOf(reader.readLine());
        }
        for(int i = 5; i > 0; i--){
            System.out.println("i= " + i);
            for(int j = 1; j < i; j++){
                System.out.println("j= " + j);
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }


        for (int i = 0; i<5; i++){
            System.out.println(arr[i]);
        }


    }
}
