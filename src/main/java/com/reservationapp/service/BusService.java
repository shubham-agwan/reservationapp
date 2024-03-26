package com.reservationapp.service;

import com.reservationapp.entity.Bus;

import com.reservationapp.payload.BusDto;

import com.reservationapp.repository.BusRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;



   // @Transactional
    public Bus addBus(BusDto busDto){


        Bus bus = new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeat(busDto.getTotalSeat());
        bus.setAvailableSeat(busDto.getAvailableSeat());



        Bus savedBus = busRepository.save(bus);
        return savedBus;

            }
        }





