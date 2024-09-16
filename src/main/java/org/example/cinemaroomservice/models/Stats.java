package org.example.cinemaroomservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {
    private int income = 0;
    @JsonProperty("available")
    private int availableSeatCount;
    @JsonProperty("purchased")
    private int purchasedSeatCount = 0;

    public Stats(int seatCount) {
        this.availableSeatCount = seatCount;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getAvailableSeatCount() {
        return availableSeatCount;
    }

    public void setAvailableSeatCount(int availableSeatCount) {
        this.availableSeatCount = availableSeatCount;
    }

    public int getPurchasedSeatCount() {
        return purchasedSeatCount;
    }

    public void setPurchasedSeatCount(int purchasedSeatCount) {
        this.purchasedSeatCount = purchasedSeatCount;
    }
}
