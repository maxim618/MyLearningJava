package concrete_implementation.sofa;

import interfaces_from_products.Sofa;

public class VictorianSofa implements Sofa {
    @Override
    public void LyingOnSofa() {
        System.out.println("Overridden method LyingOnSofa() in VictorianSofa class");
    }
}
