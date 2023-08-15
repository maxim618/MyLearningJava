import clients.Client;
import concrete_fabrics.ModernFurnitureFactory;
import concrete_fabrics.VictorianFurnitureFactory;

public class Main {
    public static void main(String[] args) {

        Client client = new Client(new VictorianFurnitureFactory());
        Client client1 = new Client(new ModernFurnitureFactory());

        client.enjoyFurniture();
        client1.enjoyFurniture();

    }
}
