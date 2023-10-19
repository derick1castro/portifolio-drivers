package com.drivers.controllers;

import com.drivers.dtos.DriverRecordDto;
import com.drivers.models.Driver;
import com.drivers.services.DriverServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/v1/drivers")
public class DriverController {

    @Autowired
    private DriverServices driverServices;

    @PostMapping
    public ResponseEntity<Driver> saveDriver(@RequestBody DriverRecordDto driverRecordDto){
        var driver = new Driver();
        BeanUtils.copyProperties(driverRecordDto, driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(driverServices.save(driver));
    }
}
