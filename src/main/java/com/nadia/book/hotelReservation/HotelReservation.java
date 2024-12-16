package com.nadia.book.hotelReservation;

import com.nadia.book.hotel.Hotel;
import com.nadia.book.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(nullable = false)
    private int numberOfNights;

    @Column(nullable = false)
    private double totalPrice;

    @Column(nullable = false)
    private String status;
}

