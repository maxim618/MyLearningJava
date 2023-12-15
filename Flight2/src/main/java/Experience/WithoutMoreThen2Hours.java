package Experience;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WithoutMoreThen2Hours implements Filtering {
    @Override
    public List<Flight> filtering(List<Flight> flights) {

        List<Flight>filteredFlights = new ArrayList<>();
        for(Flight f: flights){
            long hours = 0;
            for(int i = 0; i<f.getSegments().size()-1; i++){
                Duration d = Duration.between(f.getSegments().get(i).getArrivalDate(), f.getSegments().get(i+1).getDepartureDate());
                hours+=d.toHours();
            }
            if(hours<2){
                filteredFlights.add(f);
            }
        }
        return filteredFlights;
    }
}