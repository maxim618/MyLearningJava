import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Задача по алгоритмам Ӏ Java Syntax: 9 уровень, 11 лекция
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        ArrayList<String> list_str = new ArrayList<>();
        ArrayList<Integer> list_int = new ArrayList<>();
        for (String s : array) {
            if (isNumber(s)) {
                list_int.add(Integer.parseInt(s));
            } else {
                list_str.add(s);
            }
        }
        String temp=null;
        for(int j = 0 ; j < list_str.size(); j++){
            for(int i = 0 ; i < list_str.size() - 1; i++){
                if(isGreaterThan(list_str.get(i),(list_str.get(i+1)))){
                    temp=list_str.get(i);
                    list_str.set(i,list_str.get(i+1));
                    list_str.set((i+1),temp);
                }
            }
        }
        Collections.sort(list_int);
       // Collections.sort(list_str);
        Collections.reverse(list_int);
        int count1=0, count2=0;
        for (int i=0;i<array.length;i++){
            if (isNumber(array[i])) {
                array[i]=list_int.get(count1).toString();
                count1++;
            } else {
                array[i]=list_str.get(count2);
                count2++;
            }
        }
    }





        // Метод для сравнения строк: 'а' больше чем 'b'
        public static boolean isGreaterThan(String a, String b) {
            return a.compareTo(b) > 0;
        }


        // Переданная строка - это число?
        public static boolean isNumber(String s) {
            if (s.length() == 0) {
                return false;
            }

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if ((i != 0 && c == '-') // Строка содержит '-'
                        || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                        || (chars.length == 1 && c == '-')) // или одиночный '-'
                {
                    return false;
                }
            }
            return true;
        }
    }
