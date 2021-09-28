package com.rental.app.controller;

import com.rental.app.exception.InvalidDistanceException;
import com.rental.app.service.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;


@RestController
public class RentalController {

    private static final Logger LOG = LoggerFactory.getLogger(RentalController.class);

    private RentalService rentalService;

    @Autowired
    public void setRentalService(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("getTotalExpense/{vehicle}/{engine}/{actype}/{trip}/{passengerscount}")
    public String getTotalExpense(
            @PathVariable String vehicle,
            @PathVariable String engine,
            @PathVariable String actype,
            @PathVariable String trip,
            @PathVariable String passengerscount){

        LOG.info("getTotalExpense method started");
        try{
            return rentalService.calculateTotalExpense(vehicle, engine, actype, trip, passengerscount);
        } catch(InvalidDistanceException ex){
            LOG.error(ex.getMessage(), ex);
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT, "No Data");
        }
    }
}
