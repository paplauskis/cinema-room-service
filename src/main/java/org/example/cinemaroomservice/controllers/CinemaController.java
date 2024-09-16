package org.example.cinemaroomservice.controllers;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.cinemaroomservice.dto.ErrorResponseDTO;
import org.example.cinemaroomservice.dto.IdRequestDTO;
import org.example.cinemaroomservice.dto.SeatPurchaseRequestDTO;
import org.example.cinemaroomservice.exceptions.*;
import org.example.cinemaroomservice.models.Cinema;
import org.example.cinemaroomservice.models.Seat;
import org.example.cinemaroomservice.models.Ticket;
import org.example.cinemaroomservice.services.CinemaService;
import org.example.cinemaroomservice.services.StatsService;
import org.example.cinemaroomservice.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private StatsService statsService;

    @GetMapping("/seats")
    ResponseEntity<Cinema> getSeats() {
        return new ResponseEntity<>(cinemaService.getCinema(), HttpStatus.OK);
    }

    @PostMapping("/purchase")
    ResponseEntity<?> getPurchasedSeat(@RequestBody SeatPurchaseRequestDTO request) {
        try {
            Seat purchasedSeat = cinemaService.purchaseSeat(request.row(), request.column());
            statsService.edit(purchasedSeat.getTicket().getPrice(), true);
            return new ResponseEntity<>(purchasedSeat, HttpStatus.OK);
        } catch (InvalidSeatNumberException | SeatNotFoundException | SeatAlreadyPurchasedException e) {
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/return")
    ResponseEntity<?> getPurchasedTicket(@RequestBody IdRequestDTO requestId) {
        try {
            Ticket ticket = ticketService.findTicketById(requestId.id());
            statsService.edit(ticket.getPrice(), false);
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } catch (TicketNotFoundException e) {
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/stats")
    ResponseEntity<?> getStats(@RequestParam String password) {
        try {
            String secret_password = Dotenv.load().get("PASSWORD");
            if (password.equals(secret_password)) {
                return new ResponseEntity<>(statsService.getStats(), HttpStatus.OK);
            }
            throw new WrongAdminPasswordException("Invalid password!");
        } catch (WrongAdminPasswordException e) {
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
