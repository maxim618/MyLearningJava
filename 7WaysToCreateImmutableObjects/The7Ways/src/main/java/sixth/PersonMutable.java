package sixth;
/*
+По умолчанию класс неизменяемый.
+Контроль мест, где класс меняется.
-Не ООП.
-Можно сделать понижение типа.
-Ошибки компиляции - нужно менять тип создаваемых объектов.
-Не совсем immutable.
 */

public class PersonMutable implements Person{
    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
