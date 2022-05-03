package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * List all flights, without flights with an arrival date earlier than the departure date.
 */
public class FilterNoArrivalBeforeDeparture implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> filteredFlights = flights.stream().
                filter(f -> f.getSegments().get(0).getDepartureDate().isBefore(f.getSegments().get(0).getArrivalDate())).
                collect(Collectors.toList());
        return filteredFlights;
    }
}