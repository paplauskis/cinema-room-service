package org.example.cinemaroomservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Seat {
    private final UUID id;
    private final Ticket ticket;

    public Seat(Ticket ticket) {
        this.id = UUID.randomUUID();
        this.ticket = ticket;
    }

    public UUID getId() {
        return id;
    }

    @JsonIgnore
    public int getTicketRow() {
        return this.ticket.getRow();
    }

    @JsonIgnore
    public int getTicketColumn() {
        return this.ticket.getColumn();
    }

    public Ticket getTicket() {
        return ticket;
    }

    @JsonIgnore
    public boolean isTicketPurchased() {
        return ticket.isPurchased();
    }

    public void purchaseTicket() {
        ticket.purchase();
    }
}
