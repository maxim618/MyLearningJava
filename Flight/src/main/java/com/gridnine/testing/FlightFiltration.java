package com.gridnine.testing;

import java.util.List;

/**
 * Selection of a specific filter implementation.
 */
public class FlightFiltration {
    private Filter filter;

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public List<Flight> doFilter(List<Flight> flights) {
        return filter.filter(flights);
    }
}
