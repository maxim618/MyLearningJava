package fifth;

/*
+Текущий кон не меняется
+По умолчанию изменяемый
+Нельзя привести тип
+Можно добавить кэш
-Нельзя создать неизменяемый без изменяемого
 */
public class Main {
    public static void main(String[] args) {
        ImmutablePerson immutablePerson = new Person().immutable();
        String personName = immutablePerson.getName();
        System.out.println(personName);
//        Ошибка
//        Person person = (Person) immutablePerson;
//        person.setName("new name");

        System.out.println(personName);


    }
}
