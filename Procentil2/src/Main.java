import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

class CalcPercentiles
{
    public static void calcPercentiles(LinkedHashMap<Integer, Integer> hashMap) {
        int size = hashMap.size();

        List<Integer> value_list = new ArrayList<>(hashMap.values());

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += value_list.get(i);
        }

        for (int i = 0; i < size; i++) {
            System.out.println(100 * value_list.get(i) / (float) sum);
        }
    }

    public static void main(String[] args)
    {
        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        hashMap.put(1, 5);
        hashMap.put(2, 8);
        hashMap.put(3, 0);
        hashMap.put(4, 0);
        hashMap.put(5, 1);
        hashMap.put(6, 5);
        hashMap.put(7, 5);
        hashMap.put(8, 5);
        hashMap.put(9,10);
        hashMap.put(10,6);
        CalcPercentiles.calcPercentiles(hashMap);
    }
}