package org.example.cinemaroomservice.services;

import org.example.cinemaroomservice.exceptions.InvalidSeatNumberException;
import org.example.cinemaroomservice.exceptions.SeatAlreadyPurchasedException;
import org.example.cinemaroomservice.exceptions.SeatNotFoundException;
import org.example.cinemaroomservice.models.Cinema;
import org.example.cinemaroomservice.models.Seat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CinemaService {
    private final Cinema cinema;

    public CinemaService() {
        List<Seat> seatsList = new ArrayList<>();
        int rowCount = 9;
        int columnCount = 9;

        for (int row = 1; row <= rowCount; row ++) {
            for (int column = 1; column <= columnCount; column++) {
                seatsList.add(new Seat(row, column, row <= 4 ? 10 : 8));
            }
        }

        this.cinema = new Cinema(rowCount, columnCount, seatsList);
    }

    public Cinema getCinema() {
        return this.cinema;
    }

    public Seat purchaseSeat(int row, int column) throws InvalidSeatNumberException, SeatAlreadyPurchasedException, SeatNotFoundException {
        int rowCount = cinema.getRowCount();
        int columnCount = cinema.getColumnCount();

        if (row < 1 || row > rowCount || column < 1 || column > columnCount) {
            throw new InvalidSeatNumberException("The number of a row or a column is out of bounds!");
        }

        Seat seat = cinema.getSeat(row, column);

        if (seat.isPurchased()) {
            throw new SeatAlreadyPurchasedException("The ticket has been already purchased!");
        }

        seat.purchase();
        return seat;
    }
}
