package fifth;

public class Person implements ImmutablePerson {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ImmutablePerson immutable() {
        return new ImmutablePerson() {
            @Override
            public String getName() {
                return name;
            }
        };
    }
}
