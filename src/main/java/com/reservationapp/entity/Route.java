package com.reservationapp.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
    @Column(name = "bus_id",unique = true,nullable = false)
    private long busId;


//    @OneToOne
//    @JoinColumn(name = "bus_id")
//    private Bus bus;
//
//    @OneToMany(mappedBy = "route")
//    private List<SubRoute> subRoutes;

}
