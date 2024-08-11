package Experience;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        for (Flight f: flights)System.out.println(f.toString());
        TypeFiltration typeFiltration ;

        System.out.println("без отправившихся до настоящего времени");

        typeFiltration = new TypeFiltration(new WithoutDepartureBeforeCurrentTime());
        print(typeFiltration.doIt().filtering(flights));

        System.out.println("без прибывших до отправления");

        typeFiltration =new TypeFiltration(new WithoutDepartureBeforeArrival());
        print(typeFiltration.doIt().filtering(flights));

        System.out.println("время, проведённое на земле превышает 2 часа");

        typeFiltration = new TypeFiltration(new WithoutMoreThen2Hours());
        print(typeFiltration.doIt().filtering(flights));
    }
    public static void print(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        System.out.println("***********************************");
    }
}
