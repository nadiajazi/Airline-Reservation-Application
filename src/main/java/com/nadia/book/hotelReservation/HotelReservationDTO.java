package com.nadia.book.hotelReservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelReservationDTO {
    private Integer userId;
    private Long hotelId;
    private int numberOfNights;
    private double totalPrice;
    private String status;
}
