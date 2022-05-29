package Example;

public class SplitExample {
    public static void main(String[] args) {
        String text = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        String[] words = text.split("\\?");
        for(String word : words){
            System.out.println(word);
        }
        System.out.println("---------------------");

        words = words[1].split("&");
        for(String word : words){
            System.out.println(word);
        }

        System.out.println("---------------------");





    }
}
