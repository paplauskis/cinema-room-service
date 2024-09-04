package org.example.cinemaroomservice;

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
                seatsList.add(new Seat(row, column));
            }
        }

        this.cinema = new Cinema(rowCount, columnCount, seatsList);
    }

    public Cinema getCinema() {
        return this.cinema;
    }
}
