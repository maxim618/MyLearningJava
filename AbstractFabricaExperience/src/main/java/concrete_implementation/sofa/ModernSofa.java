package concrete_implementation.sofa;

import interfaces_from_products.Sofa;

public class ModernSofa implements Sofa {
    @Override
    public void LyingOnSofa() {
        System.out.println("Overridden method LyingOnSofa() in ModernSofa class");
    }
}
