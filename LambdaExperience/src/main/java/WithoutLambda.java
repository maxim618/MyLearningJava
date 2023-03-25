import java.util.ArrayList;
import java.util.List;

public class WithoutLambda {
    public static void main(String[] args) {
        List<Animal>animals = new ArrayList<>();
        animals = List.of(
                new Animal("fish", false, true),
                new Animal("kangaroo", true,false),
                new Animal("rabbit",true, false),
                new Animal("turtle", false,true)
        );
        print(animals,new CheckIfHopper());
        print(animals, Animal::canHop);
    }
    private static void print(List<Animal>animals,CheckTrait checker){
        for(Animal animal:animals){
            if (checker.test(animal)){
                System.out.print(animal + " ");
            }
        }
        System.out.println();
    }
}
