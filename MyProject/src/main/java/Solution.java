import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        MyObject obj = new MyObject(5);
        modifyObject(obj);
        System.out.println(obj.value); // Вывод: 10

        int a = 5;
        modifyPrimitive(a);
        System.out.println(a); // Вывод: 5
    }

    private static void modifyObject(MyObject obj) {
        obj.value = 10; // Изменение влияет на оригинальный объект

    }
    static class MyObject {
        int value;

        MyObject(int value) {
            this.value = value;
        }
    }
    private static void modifyPrimitive(int num) {
        num = 10; // Изменение не повлияет на 'a'
    }

}
