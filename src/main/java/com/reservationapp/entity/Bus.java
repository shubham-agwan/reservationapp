package com.reservationapp.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;

    private String busNumber;
    private String busType;
    private double price;
    private int totalSeat;
    private int availableSeat;
//
//    @OneToOne(mappedBy = "bus")
//    private Route route;

}
