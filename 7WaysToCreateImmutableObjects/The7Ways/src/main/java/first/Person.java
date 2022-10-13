package first;
/*
Убираем сеттеры.
+Всё под контролем.
-Ошибки компиляции.
-Класс становится не совсем immutable.
-Могут быть наследники и поле может поменяться в другом методе.

 */

public class Person {
    private String name;

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
}
