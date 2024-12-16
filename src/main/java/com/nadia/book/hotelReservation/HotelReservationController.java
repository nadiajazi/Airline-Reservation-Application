package com.nadia.book.hotelReservation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel-reservations")
public class HotelReservationController {
    private final HotelReservationService hotelReservationService;

    public HotelReservationController(HotelReservationService hotelReservationService) {
        this.hotelReservationService = hotelReservationService;
    }

    // Admin: Get all hotel reservations
    @GetMapping
    public ResponseEntity<List<HotelReservation>> getAllHotelReservations() {
        List<HotelReservation> hotelReservations = hotelReservationService.getAllReservations();
        return ResponseEntity.ok(hotelReservations);
    }

    // User: Get hotel reservations by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<HotelReservation>> getHotelReservationsByUser(@PathVariable Integer userId) {
        List<HotelReservation> hotelReservations = hotelReservationService.getReservationsByUserId(userId);
        return ResponseEntity.ok(hotelReservations);
    }

    @PostMapping
    public ResponseEntity<HotelReservation> createHotelReservation(@RequestBody HotelReservationDTO hotelReservationDTO) {
        HotelReservation reservation = hotelReservationService.createHotelReservation(hotelReservationDTO);

        return ResponseEntity.status(201).body(reservation);
    }
}
