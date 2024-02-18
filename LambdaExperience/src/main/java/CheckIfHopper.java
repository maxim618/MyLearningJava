public class CheckIfHopper implements CheckTrait{
    @Override
    public boolean test(Animal a) {
        return a.canHop();
    }

    @Override
    public boolean test2(Animal a1) {
        return !a1.canHop();
    }
}
