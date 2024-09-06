package org.example.cinemaroomservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Ticket {
    private final int row;
    private final int column;
    private final int price;
    private boolean isPurchased;

    public Ticket(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.isPurchased = false;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public int getPrice() {
        return price;
    }

    @JsonIgnore
    public boolean isPurchased() {
        return isPurchased;
    }

    public void purchase() {
        isPurchased = true;
    }
}
