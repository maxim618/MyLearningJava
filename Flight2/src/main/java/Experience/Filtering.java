package Experience;

import java.util.List;

/**
 * Common interface for all filtering algorithms.
 */
public interface Filtering {
    List<Flight>filtering(List<Flight> flights);
}

