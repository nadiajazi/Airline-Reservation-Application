package com.nadia.book.flight;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getFlights(String origin, String destination) {
        return flightRepository.findByOriginAndDestination(origin, destination);
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getFlightsByDateRange(LocalDateTime start, LocalDateTime end) {
        return flightRepository.findByDepartureTimeBetween(start, end);
    }
}

