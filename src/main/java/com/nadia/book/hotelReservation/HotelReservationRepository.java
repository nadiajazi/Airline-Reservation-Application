package com.nadia.book.hotelReservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelReservationRepository extends JpaRepository<HotelReservation, Long> {
    List<HotelReservation> findByUserId(Integer userId);
}
