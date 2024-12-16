package com.nadia.book.reservation;


import com.nadia.book.flight.Flight;
import com.nadia.book.flight.FlightRepository;
import com.nadia.book.user.User;
import com.nadia.book.user.UserRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final FlightRepository flightRepository;
    public ReservationService(ReservationRepository reservationRepository,UserRepository userRepository, FlightRepository flightRepository ) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.flightRepository = flightRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByUserId(Integer userId) {
        return reservationRepository.findByUserId(userId);
    }

    public Reservation createReservation(ReservationDTO reservationDTO) {
        User user = userRepository.findById(reservationDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Flight flight = flightRepository.findById(reservationDTO.getFlightId())
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        Reservation reservation = Reservation.builder()
                .user(user)
                .flight(flight)
                .numberOfSeats(reservationDTO.getNumberOfSeats())
                .totalPrice(reservationDTO.getTotalPrice())
                .bookingDate(LocalDateTime.now())
                .status(reservationDTO.getStatus())
                .build();

        return reservationRepository.save(reservation);
    }
}

