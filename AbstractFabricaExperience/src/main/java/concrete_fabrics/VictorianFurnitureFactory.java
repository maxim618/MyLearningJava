package concrete_fabrics;

import concrete_implementation.chair.VictorianChair;
import concrete_implementation.sofa.VictorianSofa;
import fabric_interfaces.FurnitureFactory;
import interfaces_from_products.Chair;
import interfaces_from_products.Sofa;

public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
