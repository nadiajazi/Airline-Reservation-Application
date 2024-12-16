package com.nadia.book.reservation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO {
    private Integer userId;
    private Long flightId;
    private int numberOfSeats;
    private double totalPrice;
    private String status;
}
