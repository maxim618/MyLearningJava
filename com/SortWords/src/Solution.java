
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {

        HashMap<String, Integer> result = new HashMap<String, Integer>();
        int n = 0;
        ArrayList<Integer> numbs = new ArrayList<Integer>();
        for(int i = 0; i < 20; i++){
            for(int j = 0; j<20; j++){
                if(list.get(i).equals(list.get(j)))
                {
                    n++;
                }
            }
            numbs.add(n);
            n = 0;
        }
        for(int i = 0; i < 20; i++){
            result.put(list.get(i), numbs.get(i));
        }
        return result;
    }

}