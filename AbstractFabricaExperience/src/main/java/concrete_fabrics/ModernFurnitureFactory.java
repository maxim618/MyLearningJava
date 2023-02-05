package concrete_fabrics;

import concrete_implementation.chair.ModernChair;
import concrete_implementation.sofa.ModernSofa;
import fabric_interfaces.FurnitureFactory;
import interfaces_from_products.Chair;
import interfaces_from_products.Sofa;

public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}
