package com.nadia.book.hotelReservation;

import com.nadia.book.hotel.Hotel;
import com.nadia.book.hotel.HotelRepository;
import com.nadia.book.user.User;
import com.nadia.book.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelReservationService {
    private final HotelReservationRepository hotelReservationRepository;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;

    public HotelReservationService(HotelReservationRepository hotelReservationRepository,
                                   UserRepository userRepository, HotelRepository hotelRepository) {
        this.hotelReservationRepository = hotelReservationRepository;
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
    }

    // Get all reservations for admin
    public List<HotelReservation> getAllReservations() {
        return hotelReservationRepository.findAll();
    }

    // Get reservations by user ID
    public List<HotelReservation> getReservationsByUserId(Integer userId) {
        return hotelReservationRepository.findByUserId(userId);
    }

    public HotelReservation createHotelReservation(HotelReservationDTO hotelReservationDTO) {
        // Fetch the user and hotel entities
        User user = userRepository.findById(hotelReservationDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Hotel hotel = hotelRepository.findById(hotelReservationDTO.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        // Calculate total price (example calculation)
        double totalPrice = hotelReservationDTO.getNumberOfNights() * hotel.getPricePerNight();

        // Create and save the reservation
        HotelReservation reservation = HotelReservation.builder()
                .user(user)
                .hotel(hotel)
                .numberOfNights(hotelReservationDTO.getNumberOfNights())
                .totalPrice(totalPrice)
                .status(hotelReservationDTO.getStatus())
                .build();

        return hotelReservationRepository.save(reservation);
    }
}
