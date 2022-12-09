import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        List<Character> chars = new ArrayList<>();

        int max = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmpChar = s.charAt(i);
            System.out.print("итерациия: " + i + " j = " + j + " tmpChar = " + tmpChar +"  ");
            System.out.println(chars);
            while (chars.contains(tmpChar)) {
                Character remove = chars.remove(0);// Удаляем первый элемент, чтобы сдвинуть окно
                j++;

                System.out.println("  удаляемый объект : " + remove);

            }
            System.out.println("в chars добавляется: " + tmpChar);
            chars.add(tmpChar);
            max = Math.max(max, i - j + 1);
        }
        System.out.println(max);
        System.out.println(chars);

    }


}
