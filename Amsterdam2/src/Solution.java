import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String fileName = null;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("File path: ");
            fileName = console.readLine();
        } catch (IOException e) { e.printStackTrace(); }

        StringBuilder words = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            for (String line; (line = reader.readLine()) != null;) {
                words.append(line).append(" ");
            }
        } catch (IOException e) { e.printStackTrace(); }

        StringBuilder result = getLine(words.toString().trim().split("\\s+"));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        // проверка words
        if (words == null || words.length == 0 || (words.length == 1 && words[0].equals(""))) return new StringBuilder();
        LinkedList<String> tempList, resultlist = new LinkedList<>();
        List<String> wordsList = Arrays.asList(words);

        // ind - индекс слова, с которого начинаем поиск
        for (int ind = words.length - 1; ind >= 0; ind--) {
            tempList = new LinkedList<>(wordsList);  // words во временный список
            resultlist.clear();
            resultlist.add(tempList.get(ind));                  // добавляем ind-е слово в результирующий список
            tempList.remove(ind);                               // удаляем его из временного

            // перебираем оставшийся временный список, пока он не закончится, или больше не будет соответствий
            boolean find = true;
            while (find && tempList.size() > 0) {
                String current = resultlist.getLast();                        // последнее слово из результирующего
                char a = current.toLowerCase().charAt(current.length() - 1);  // его последняя буква

                // если для данного слова соответствия не найдено
                // прекращаем перебор временного списка
                find = false;

                for (String word : tempList) {
                    char b = word.toLowerCase().charAt(0);  // первая буква данного слова
                    if (a == b) {
                        resultlist.add(word);               // добавляем найденное слово в результат
                        tempList.remove(word);              // удаляем его из временного списка
                        find = true;                        // флаг = соответствие найдено
                        break;                              // останавливаем поиск для данного слова
                    }
                }
            }
            // если размер результирующего списка уже равен размеру переданного массива - прерываем цикл
            if (resultlist.size() == words.length) break;
                // иначе, если уже дошли до конца цикла - перетасовываем исходный список и сбрасываем счетчик
            else if (ind == 0 && tempList.size() > 0) {
                Collections.shuffle(wordsList);
                ind = words.length - 1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (String s : resultlist)
            result.append(s).append(" ");
        result.setLength(result.length() - 1);
        return result;
    }
}
