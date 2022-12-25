package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaRushTest {
    
    public static void main (String[]args)  throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            double sum = 0;
            double res;
            int i = 0;
            while (true) {
                int number = Integer.parseInt(reader.readLine());
                //int number = next;
                if (number == -1) break;
                sum += number;
                i++;
            }
            res = sum/i;
            System.out.println(res);
        }
    }


