package com.drivers.services;

import com.drivers.models.Driver;
import com.drivers.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServices {

    @Autowired
    private DriverRepository driverRepository;

    public Driver save(Driver driver){
        return driverRepository.save(driver);
    }
}
