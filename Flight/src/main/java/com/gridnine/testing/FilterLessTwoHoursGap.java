package com.gridnine.testing;


import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  List of all flights with total gaps of no more than two hours.
 */
public class FilterLessTwoHoursGap implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {

        List<Flight> filteredFlights = flights.stream().
                filter(f -> {
                    long hoursGap = 0;
                    for (int i = 0; i < f.getSegments().size() - 1; i++) {
                        Duration duration = Duration.between(f.getSegments().get(i).getArrivalDate(), f.getSegments().get(i + 1).getDepartureDate());
                        hoursGap += duration.toHours();
                    }
                    return hoursGap < 2;
                }).collect(Collectors.toList());
        return filteredFlights;
    }
}