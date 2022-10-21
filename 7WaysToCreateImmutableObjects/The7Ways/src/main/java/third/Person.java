package third;
/*
+ Объект может быть изменяемым и неизменяемым.
+ Нет ошибок компиляции
-Есть дополнительная синхронизация

 */

public class Person {
    private String name;
    private volatile boolean isSealed;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isSealed) {
            throw new IllegalStateException("Modification is prohibited");
        }
        this.name = name;
    }
    public void seal() {
        isSealed = true;
    }
}
