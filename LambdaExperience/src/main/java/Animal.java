public class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String species, boolean canHop, boolean canSwim) {
        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }
    public boolean canHop() {return canHop;}
    public boolean CanSwim(){return  canSwim;}

    @Override
    public String toString() {
        return species;
    }
}
