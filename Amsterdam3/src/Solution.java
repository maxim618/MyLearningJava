

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(read.readLine()));
        String[] strings = reader.readLine().split(" ");
        StringBuilder result = getLine(strings);
        System.out.println(result.toString());
    }
    public static String theFirstWord (List<String>lst){//Нахожднение первого слова
        int count = 0;
        String res = lst.get(0);
        for (int i = 0; i<lst.size();i++){
            char s1 = lst.get(i).charAt(0);
            for (int j = 0; j<lst.size();j++){
                char s2 = lst.get(j).charAt(lst.get(j).length()-1);
                if(s1==s2&&i!=j){
                    count++;
                    if(count==lst.size()-1){
                        res = lst.get(i);
                    }
                }
            }
            count = 0;
        }
        return res;
    }

    public static StringBuilder getLine(String[] words) {

        StringBuilder nullresult = new StringBuilder("");
        if (words == null || words.length == 0)
            return nullresult;
        int countlist = 0;
        StringBuilder result = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(words[i]);
        }
        String s = theFirstWord(list);
        list.remove(s);
        list.add(0,s);
        while (true) {
            Collections.shuffle(list);


            for (int i = 0; i < list.size()-1 ; i++) {
                String string1 = list.get(i).substring(list.get(i).length() - 1);
                //System.out.println(string1);
                String string2 = list.get(i + 1).substring(0, 1);
                // System.out.println(string2);
                if (string1.equalsIgnoreCase(string2)) {
                    countlist++;
                }
            }
            //  System.out.println(" " + countlist);
            if (countlist+1  == list.size())
                break;
            else
                countlist = 0;
        }
        for (String string : list)
            result.append(string + " ");

        String sder = result.toString().trim();
        result = new StringBuilder(sder);

        return result;
    }
}
