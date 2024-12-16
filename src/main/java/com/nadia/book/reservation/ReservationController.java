package com.nadia.book.reservation;

import com.nadia.book.flight.Flight;
import com.nadia.book.flight.FlightRepository;
import com.nadia.book.user.User;
import com.nadia.book.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;


    public ReservationController(ReservationService reservationService
                                 ) {
        this.reservationService = reservationService;

    }

    // Admin: Get all reservations
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    // User: Get reservations by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@PathVariable Integer userId) {
        List<Reservation> reservations = reservationService.getReservationsByUserId(userId);
        return ResponseEntity.ok(reservations);
    }


    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationDTO reservationDTO) {
        // Call the service to create a reservation
        Reservation reservation = reservationService.createReservation(reservationDTO);

        // Return the created reservation with status code 201 (Created)
        return ResponseEntity.status(201).body(reservation);
    }
}
