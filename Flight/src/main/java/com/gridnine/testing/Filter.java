package com.gridnine.testing;
import java.util.List;

/**
 * Common interface for all filtering algorithms.
 */
public interface Filter {
    List<Flight> filter(List<Flight> flights);
}