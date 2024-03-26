package com.reservationapp.service;

import com.reservationapp.entity.UserRegistration;
import com.reservationapp.payload.UserRegistrationDto;
import com.reservationapp.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    public UserRegistrationDto createUser(UserRegistration userRegistration){
        userRegistrationRepository.save(userRegistration);
        return null;
    }

    public UserRegistration getUserById(long id) {
        return userRegistrationRepository.findById(id).get();
    }
}
