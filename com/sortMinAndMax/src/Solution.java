
public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //Напишите тут ваше решение
        String res[]= new String[]{"Корова","Кит","Собака","Неизвестное животное"};
        if(o instanceof  Cow){
            return res[0];
        }else if(o instanceof Dog){
            return  res[2];
        }else if(o instanceof Whale) {
            return res[1];
        }else {
            return  res[3];
        }

    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
