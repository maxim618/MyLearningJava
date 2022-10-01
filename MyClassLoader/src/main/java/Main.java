
import data.*;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {

        Set<Animal> allAnimals = new HashSet<>();

        String pathToAnimals = Cat.class.getProtectionDomain().getCodeSource().getLocation().getPath()
                + Cat.class.getPackage().getName().replaceAll("[.]", "/");

        File[]files = PathOpener.arrayPaths(pathToAnimals);

        //для кaждого File своим ClassLoader  получаем объект Class
        for(File f:files){
            Class<?> clazz = new MyClassLoader().load(Path.of(f.getPath())); //получаем экземпляр класса при помощи load - defineClass()
            //String ss = clazz.getTypeName();

            if(Animal.class.isAssignableFrom(clazz)||!clazz.isInterface()){

                //Class.forName(ss);

                try {
                    Constructor<?> c;
                    c = clazz.getConstructor();
                    Animal a = (Animal) c.newInstance();
                    allAnimals.add(a);
                } catch (NoSuchMethodException e) {
                    System.out.println("constructor with parameter");
                }
            }
        }
        for (Animal a:allAnimals){
            System.out.println(a.getClass().getSimpleName());
        }
    }
}
