package org.example.cinemaroomservice.services;

import org.example.cinemaroomservice.models.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    private final Stats stats;

    @Autowired
    public StatsService(CinemaService cinemaService) {
        int rowCount = cinemaService.getCinema().getRowCount();
        int columnCount = cinemaService.getCinema().getColumnCount();
        this.stats = new Stats(rowCount * columnCount);
    }

    public Stats getStats() {
        return this.stats;
    }

    public void edit(int seatPrice, boolean isPurchase) {
        int income = stats.getIncome();
        int availableSeatCount = stats.getAvailableSeatCount();
        int purchasedSeatCount = stats.getPurchasedSeatCount();

        if (isPurchase) {
            stats.setIncome(income + seatPrice);
            stats.setAvailableSeatCount(availableSeatCount - 1);
            stats.setPurchasedSeatCount(purchasedSeatCount + 1);
        } else {
            stats.setIncome(income - seatPrice);
            stats.setAvailableSeatCount(availableSeatCount + 1);
            stats.setPurchasedSeatCount(purchasedSeatCount - 1);
        }
    }
}
