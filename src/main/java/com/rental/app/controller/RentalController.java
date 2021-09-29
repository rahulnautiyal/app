package com.rental.app.controller;

import com.rental.app.exception.InvalidDistanceException;
import com.rental.app.service.RentalService;

import com.rental.app.utils.LOG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/rentalapp")
public class RentalController {

    private RentalService rentalService;

    @Autowired
    public void setRentalService(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("getTotalExpense/{vehicle}/{engine}/{actype}/{trip}/{passengerscount}")
    public ResponseEntity<String> getTotalExpense(
            @PathVariable String vehicle,
            @PathVariable String engine,
            @PathVariable String actype,
            @PathVariable String trip,
            @PathVariable String passengerscount){

        LOG.info("getTotalExpense method started");
        try{
            String totalExpense = rentalService.calculateTotalExpense(vehicle, engine, actype, trip, passengerscount);
            return ResponseEntity.ok(totalExpense);
        } catch(InvalidDistanceException ex){
            LOG.error(ex.getMessage());
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT, "No Data");
        }
    }
}
