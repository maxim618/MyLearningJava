import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        HashMap<String,String> map = new HashMap<>();
        map.put("Фам1", "Иван");
        map.put("Фам2", "Олег");
        map.put("Фам3", "Петя");
        map.put("Фам4", "Антон");
        map.put("Фам5", "Иван");
        map.put("Фам6", "Костя");
        map.put("Фам7", "Петя");
        map.put("Фам8", "Антон");
        map.put("Фам9", "Сергей");
        map.put("Фам10", "Олег");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        HashMap<String, String> test = new HashMap<>(map);
        List<String> list = new ArrayList<>();

        Iterator<Map.Entry<String, String>> iterator = test.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String value = pair.getValue();
            String key = pair.getKey();

            Iterator<Map.Entry<String, String>> iterator2 = test.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry<String, String> pair2 = iterator2.next();
                String value2 = pair2.getValue();
                String key2 = pair2.getKey();
                if (value2.equals(value) && !key2.equals(key))
                    list.add(value2);
            }
        }
        for(String s: list) {
            removeItemFromMapByValue(map, s);
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}