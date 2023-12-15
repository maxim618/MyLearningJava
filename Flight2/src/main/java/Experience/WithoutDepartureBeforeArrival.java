package Experience;

import java.util.ArrayList;
import java.util.List;

public class WithoutDepartureBeforeArrival implements Filtering {
    @Override
    public List<Flight> filtering(List<Flight> flights) {

        List<Flight> filteredFlights = new ArrayList<>();
        for (int i = 0; i< flights.size(); i++) {
            Flight flight = flights.get(i);
            List<Segment>segments = flight.getSegments();
            boolean flag = true;
            for (int j=0; j<segments.size();j++) {
                if (!segments.get(j).getDepartureDate().isBefore(segments.get(j).getArrivalDate())) {
                    flag = false;
                }
            }
            if(flag)filteredFlights.add(flight);
        }
        return filteredFlights;
    }
}