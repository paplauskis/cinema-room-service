package org.example.cinemaroomservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.cinemaroomservice.exceptions.SeatNotFoundException;

import java.util.List;

public class Cinema {
    private final int rowCount;
    private final int columnCount;
    private final List<Seat> seatsList;

    public Cinema(int rowCount, int columnCount, List<Seat> seatsList) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.seatsList = seatsList;
    }

    @JsonProperty("rows")
    public int getRowCount() {
        return this.rowCount;
    }

    @JsonProperty("columns")
    public int getColumnCount() {
        return this.columnCount;
    }

    @JsonProperty("seats")
    public List<Seat> getSeatsList() {
        return this.seatsList;
    }

    public Seat getSeat(int row, int column) throws SeatNotFoundException {
        for (Seat seat : seatsList) {
            if (seat.getRow() == row && seat.getColumn() == column) {
                return seat;
            }
        }
        throw new SeatNotFoundException("Cannot find seat");
    }
}
