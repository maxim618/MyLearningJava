package configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.javarush.info.fatfaggy.animals.entities.*;
import ru.javarush.info.fatfaggy.days.*;


import java.time.DayOfWeek;
import java.time.LocalDate;

@Configuration
@ComponentScan("ru.javarush.info.fatfaggy.animals.entities")
public class MyConfig {
    @Bean
    public Cat cat(Parrot parrot){
        Cat cat = new Cat();
        cat.setName(parrot.getName()+"killer");
        return cat;
    }
    @Bean
    public Dog dog(){
        return new Dog();
    }
    @Bean("parrot-kesha")
    public Parrot parrot(){
        return new Parrot();
    }

    @Bean
    public WeekDay getDay() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY: return new Monday();
            case TUESDAY: return new Tuesday();
            case WEDNESDAY: return new Wednesday();
            case THURSDAY: return new Thursday();
            case FRIDAY: return new Friday();
            case SATURDAY: return new Saturday();
            default: return new Sunday();
        }
    }



}
