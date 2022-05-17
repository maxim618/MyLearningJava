import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
/*
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        List<Integer>list=new ArrayList<Integer>();
        List<Integer>listTemp=new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count=1;
        int j=0;
        for(int i=0;i<9;i++){
            listTemp.add(j);
        }
        for(int i=0;i<10;i++){
            list.add(Integer.parseInt(reader.readLine()));
        }
        for(int i=1;i<10;i++){
            if(list.get(i-1).equals(list.get(i))){
                count++;
                System.out.println(count);

            }else{
                count=1;
            }
            listTemp.set(i-1,count);
        }
        Collections.sort(listTemp);
        System.out.println((listTemp.get(listTemp.size()-1)));
    }
}