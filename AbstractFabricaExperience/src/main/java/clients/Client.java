package clients;

import fabric_interfaces.FurnitureFactory;
import interfaces_from_products.Chair;
import interfaces_from_products.Sofa;

public class Client {
    Sofa sofa;
    Chair chair;

    public Client(FurnitureFactory furnitureFactory) {
        sofa = furnitureFactory.createSofa();
        chair = furnitureFactory.createChair();
    }

    public void enjoyFurniture() {
        sofa.LyingOnSofa();
        chair.sitOnChair();
    }

}
