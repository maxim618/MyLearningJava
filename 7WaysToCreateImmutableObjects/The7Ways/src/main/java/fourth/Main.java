package fourth;
/*
+Ограниченный интерфейс.
+Мало изменений в коде.
+По умолчанию изменяемый.
+Контроль мест, где класс изменяемый.
-Не совсем immutable/
-Можно привести к Person и получить доступ к сеттерам.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ImmutablePerson person = new Person();
        String string =  person.getName();
        List<ImmutablePerson>list = new ArrayList<>();
        list.add(person);
        System.out.println(list.get(0).getName());
        System.out.println(string);

        Person mutable = (Person) person;
        mutable.setName("new Name");

        System.out.println(person.getName());
        System.out.println(mutable.getName());

    }
}
