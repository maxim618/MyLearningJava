package com.gridnine.testing;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List of all flights, except flights with departures up to the current time.
 */
public class FilterNoDepartureBeforeNow implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> filteredFlights = flights.stream().
                filter(f -> f.getSegments().get(0).getDepartureDate().isAfter(LocalDateTime.now())).
                collect(Collectors.toList());
        return filteredFlights;
    }
}