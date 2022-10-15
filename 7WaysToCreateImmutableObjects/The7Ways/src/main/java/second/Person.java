package second;
/*
+Нет ошибок компиляции.

-условно неизменяемый всегда и везде.
-Не совсем immutable.
 */

public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.name!=null) {
            throw new IllegalArgumentException("name is already set");
        }
        this.name = name;
    }
}
