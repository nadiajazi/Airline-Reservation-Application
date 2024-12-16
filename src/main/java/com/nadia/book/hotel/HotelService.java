package com.nadia.book.hotel;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    // Method to get all hotels
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Method to get a hotel by ID
    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelId));
    }

    // Method to create a new hotel
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // Method to update hotel details
    public Hotel updateHotel(Long hotelId, Hotel hotelDetails) {
        Hotel existingHotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelId));

        existingHotel.setName(hotelDetails.getName());
        existingHotel.setLocation(hotelDetails.getLocation());
        existingHotel.setPricePerNight(hotelDetails.getPricePerNight());
        existingHotel.setAvailableRooms(hotelDetails.getAvailableRooms());

        return hotelRepository.save(existingHotel);
    }

    // Method to delete a hotel
    public void deleteHotel(Long hotelId) {
        Hotel existingHotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelId));

        hotelRepository.delete(existingHotel);
    }
}
