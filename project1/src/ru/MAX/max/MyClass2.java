package ru.MAX.max;
import abc.MyClass1;
public class MyClass2 {
    public static void main(String[] args) {
        MyClass1.main(args);
        System.out.println("main from my class2");
        System.out.println(args.length);

        for (String arg: args) {
            System.out.println(arg);


        }
    }
}
