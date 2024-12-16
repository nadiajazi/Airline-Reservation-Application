package com.nadia.book.hotel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // Endpoint to get all hotels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    // Endpoint to get a hotel by ID
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long hotelId) {
        return ResponseEntity.ok(hotelService.getHotelById(hotelId));
    }

    // Endpoint to create a new hotel
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.createHotel(hotel));
    }

    // Endpoint to update an existing hotel
    @PutMapping("/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long hotelId, @RequestBody Hotel hotelDetails) {
        return ResponseEntity.ok(hotelService.updateHotel(hotelId, hotelDetails));
    }

    // Endpoint to delete a hotel
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long hotelId) {
        hotelService.deleteHotel(hotelId);
        return ResponseEntity.noContent().build();
    }
}
