package org.example.cinemaroomservice.dto;

public class SeatPurchaseRequestDTO {
    private final int row;
    private final int column;

    public SeatPurchaseRequestDTO(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
