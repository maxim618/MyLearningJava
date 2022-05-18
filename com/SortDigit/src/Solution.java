import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static java.util.Collections.sort;


public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader1.readLine();
        reader1.close();//считали имя файла с консоли и закрыли поток1
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));//создали второй буфер для считывания данных из файла
        ArrayList<Integer> list = new ArrayList<>();//создали лист для записи четных чисел

        while(reader2.ready()) {
            Integer numb = Integer.parseInt(reader2.readLine());
            if (numb == null) { // если пустое число

            }
            else if(numb %2 == 0) {
                list.add(numb);
            }

            else if(numb < 0 && numb %2==0) {
                list.add(numb);
            }
        }

        reader2.close();
        Collections.sort(list);
        for (int x : list) {
            System.out.println(x);
        }


    }
}