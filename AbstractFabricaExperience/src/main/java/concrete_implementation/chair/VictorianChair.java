package concrete_implementation.chair;

import interfaces_from_products.Chair;

public class VictorianChair implements Chair{
    @Override
    public void sitOnChair() {
        System.out.println("Overridden method sitOnChair() in VictorianChair class");
    }
}
