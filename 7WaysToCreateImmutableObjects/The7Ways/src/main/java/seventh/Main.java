package seventh;

public class Main {
    public static void main(String[] args) {
        Person immutablePerson = new ImmutablePerson("the name");
        Person person = ImmutablePerson.getBy(immutablePerson);
        System.out.println(person.getName());

        Person personImpl = new PersonImpl();
        person = ImmutablePerson.getBy(personImpl);
        System.out.println(person.getName());
    }
}
