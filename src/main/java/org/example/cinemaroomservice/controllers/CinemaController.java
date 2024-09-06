package org.example.cinemaroomservice.controllers;

import org.example.cinemaroomservice.dto.ErrorResponseDTO;
import org.example.cinemaroomservice.dto.SeatPurchaseRequestDTO;
import org.example.cinemaroomservice.exceptions.*;
import org.example.cinemaroomservice.models.Cinema;
import org.example.cinemaroomservice.models.Seat;
import org.example.cinemaroomservice.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/seats")
    ResponseEntity<Cinema> getSeats() {
        return new ResponseEntity<>(cinemaService.getCinema(), HttpStatus.OK);
    }

    @PostMapping("/purchase")
    ResponseEntity<?> getPurchasedSeat(@RequestBody SeatPurchaseRequestDTO request) {
        try {
            Seat purchasedSeat = cinemaService.purchaseSeat(request.row(), request.column());
            return new ResponseEntity<>(purchasedSeat, HttpStatus.OK);
        } catch (InvalidSeatNumberException | SeatNotFoundException | SeatAlreadyPurchasedException e) {
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
