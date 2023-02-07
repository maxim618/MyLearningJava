package fabric_interfaces;

import interfaces_from_products.Chair;
import interfaces_from_products.Sofa;

public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}
