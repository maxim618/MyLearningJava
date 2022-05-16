import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        Cat cat = new Cat("Мозг", "Сердце", "Хвост");
    }
    public static class Animal {

        String brain = "Изначальное значение brain в классе Animal";
        String heart = "Изначальное значение heart в классе Animal";

        public static int animalCount = 7700000;

        public Animal(String brain, String heart) {
            System.out.println("Выполняется конструктор базового класса Animal");
            System.out.println("Были ли уже проинициализированы переменные класса Animal?");
            System.out.println("Текущее значение статической переменной animalCount = " + animalCount);
            System.out.println("Были ли уже проинициализированы переменные класса Cat?");
            System.out.println("Текущее значение статической переменной catsCount = " + Cat.catsCount);
            System.out.println("Текущее значение brain в классе Animal = " + this.brain);
            System.out.println("Текущее значение heart в классе Animal = " + this.heart);
            
            this.brain = brain;
            this.heart = heart;

            System.out.println("Текущее значение brain = " + this.brain);
            System.out.println("Текущее значение heart = " + this.heart);
            System.out.println("Конструктор базового класса Animal завершил работу!");
        }
    }

    public static class Cat extends Animal {

        String tail = "Изначальное значение tail в классе Cat";

        static int catsCount = 37;

        public Cat(String brain, String heart, String tail) {
            super(brain, heart);
            System.out.println("Конструктор класса Cat начал работу (конструктор Animal уже был выполнен)");
            System.out.println("Текущее значение статической переменной catsCount = " + catsCount);
            System.out.println("Текущее значение tail = " + this.tail);
            this.tail = tail;
            System.out.println("Текущее значение tail = " + this.tail);
        }


    }
}
