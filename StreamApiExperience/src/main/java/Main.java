import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Animal>animals = getAnimals();

        List<Animal>predators = new ArrayList<>();
        for(Animal a:animals){
            if(a.getClassification().equals(Classification.PREDATOR)){
                predators.add(a);
            }
        }
        predators.forEach(System.out::println);
        System.out.println("-------------");

        predators = animals.stream()
                .filter(animal -> animal.getClassification().equals(Classification.PREDATOR))
                .collect(Collectors.toList());
        predators.forEach(System.out::println);
        System.out.println("-------------");

        List<Animal>sorted =  animals.stream()
                .sorted(Comparator.comparing(Animal::getName)
                        .thenComparing(Animal::getAge))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
        System.out.println("-------------");

        boolean allMatch = animals.stream()
                .allMatch(animal -> animal.getAge()>10);
        System.out.println(allMatch);
        System.out.println("-------------");

        boolean anyMatch = animals.stream()
                .anyMatch(animal -> animal.getAge()>10);
        System.out.println(anyMatch);
        System.out.println("-------------");

        boolean noneMatch = animals.stream()
                .anyMatch(animal -> animal.getName().equals("медведь"));
        System.out.println(noneMatch);
        System.out.println("-------------");

        animals.stream()
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);
        System.out.println("-------------");

        Map<Classification, List<Animal>> classificationListMap = animals.stream()
                .collect(Collectors.groupingBy(Animal::getClassification));

        classificationListMap.forEach((c,a)->{
            System.out.println(c);
        });





    }
    private static List<Animal>getAnimals(){
        return List.of(
                new Animal("Слон", 20 , Classification.HERBIVORE),
                new Animal("Лев", 10 , Classification.PREDATOR),
                new Animal("Гиена", 11 , Classification.PREDATOR),
                new Animal("Жираф", 36 , Classification.HERBIVORE),
                new Animal("Гибон", 35 , Classification.OMNIVOROUS),
                new Animal("Жираф", 35, Classification.HERBIVORE),
                new Animal("Лошадь", 36 , Classification.HERBIVORE),
                new Animal("Рысь", 2 , Classification.PREDATOR),
                new Animal("Динозавр", 200 , Classification.PREDATOR));
    }
}
