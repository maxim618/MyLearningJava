package seventh;
/*
+Настоящий immutable.
+реализация скрыта за интерфейсом.
-много изменений в коде.
 */
public final class ImmutablePerson implements Person{
    private final String name;

    public ImmutablePerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static Person getBy(Person person) {
        if (person instanceof ImmutablePerson) {
            return person;
        }
        return new ImmutablePerson(person.getName());
    }
}
