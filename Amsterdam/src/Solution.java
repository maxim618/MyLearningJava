
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/*
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        //System.out.println(getLine("Киев", "Нью-Йорк", "Роттердам", "Вена", "Мельбурн"));
        //Киев Нью-Йорк Амстердам Вена Мельбурн
        //System.out.println(getLine("Киев", "Нью-Йорк", "Амстердам", "Вена", "Мельбурн"));
        List<String>list = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader bufferedReader2 = new BufferedReader(
                    new InputStreamReader(Files.newInputStream(Paths.get(bufferedReader.readLine()))))) {
            while (bufferedReader2.ready()){
                String []tmp = bufferedReader2.readLine().split(" ");
                list.addAll(Arrays.asList(tmp));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        String []words = list.toArray(new String[0]);

        StringBuilder result = getLine(words);
        System.out.println(result.toString());

    }
    public static String theFirstWord (List<String>lst){ //Нахожднение первого слова
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

    public static StringBuilder getLine(String... words) {

        if (words == null || words.length == 0) return new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();

        List<String>list = new ArrayList<>();//делаем все буквы маленькими
        for(String s:words){
            list.add(s.toLowerCase());
        }
        String theFirst = theFirstWord(list);//ищем 1 слово
        stringBuilder.append(theFirst).append(" ");
        // listResult.add(theFirst);
        list.remove(theFirst);
        while (!list.isEmpty()){
            if(stringBuilder.charAt(stringBuilder.length()-2)==list.get(0).charAt(0)){

                stringBuilder.append(list.get(0)).append(" ");
                // listResult.add(list.get(0));
                list.remove(list.get(0));
            }else if(stringBuilder.charAt(0)==list.get(0).charAt(list.get(0).length()-1)){

                stringBuilder.insert(0, list.get(0) + " ");
                //listResult.add(0,list.get(0));
                list.remove(list.get(0));
            }else {
                String s = list.get(0);
                list.remove(s);
                list.add(s);
            }
        }


        return getResult(stringBuilder);
    }

    private static StringBuilder getResult(StringBuilder stringBuilder) {
        String s1 = "";
        StringBuilder s2 = new StringBuilder();
        s1= String.valueOf(stringBuilder);
        s2.append(s1.substring(0, 1).toUpperCase());
        //первый символ делаем заглавным
        for (int i=1; i < s1.length(); i++) {
            // смотрим, был ли слева пробел:
            if (" ".equals(s1.substring(i-1, i))) s2.append(s1.substring(i, i + 1).toUpperCase());
            else s2.append(s1.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        result.append(s2);
        return result;
    }
}
