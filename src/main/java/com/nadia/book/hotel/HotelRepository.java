package com.nadia.book.hotel;

import com.nadia.book.hotelReservation.HotelReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
