package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightFiltration flightFiltration = new FlightFiltration();

        Filter filter = new FilterNoDepartureBeforeNow();
        flightFiltration.setFilter(filter);
        print(flightFiltration.doFilter(flights));
        Filter filter2 = new FilterNoArrivalBeforeDeparture();
        flightFiltration.setFilter(filter2);
        print(flightFiltration.doFilter(flights));
        Filter filter3 = new FilterLessTwoHoursGap();
        flightFiltration.setFilter(filter3);
        print(flightFiltration.doFilter(flights));
    }
    public static void print(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        System.out.println("-------------------------");
    }
}
