package task2712.kitchen;



import task2712.ConsoleHelper;
import task2712.Tablet;

import java.io.IOException;
import java.util.List;



public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

     public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
        ConsoleHelper.writeMessage(toString());
    }


    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }


    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }


    public int getTotalCookingTime(){
        int res = 0;
        for (Dish dish : dishes) {
            res += dish.getDuration();
        }
        return res;
    }
    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        if (dishes.size()==0){
            return new StringBuilder().toString();
        }else
            return "Your order:"+ dishes.toString() + " of " + tablet.toString() + "cooking time "
                    + getTotalCookingTime()+"min";


    }

}
