package org.example.cinemaroomservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

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
}
