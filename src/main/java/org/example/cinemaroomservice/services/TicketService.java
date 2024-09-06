package org.example.cinemaroomservice.services;

import org.example.cinemaroomservice.exceptions.TicketNotFoundException;
import org.example.cinemaroomservice.models.Seat;
import org.example.cinemaroomservice.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService {
    @Autowired
    private CinemaService cinemaService;

    public Ticket findTicketById(UUID id) throws TicketNotFoundException {
        List<Seat> seatsList = cinemaService.getCinema().getSeatsList();
        for (Seat seat : seatsList) {
            if (seat.getId().equals(id)) {
                return seat.getTicket();
            }
        }
        throw new TicketNotFoundException("Wrong ID, ticket cannot be found.");
    }
}
