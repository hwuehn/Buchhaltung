package de.company.accounting.data;

import java.time.LocalDate;

public class Position  {

    private final LocalDate date;
    private final int documentNumber;

    public double getTotalNetPrice() {
        return totalNetPrice;
    }
    public LocalDate getDate() { return date; }

    private final double totalNetPrice;
    private final String articleDescription;

    public Position(LocalDate date, int documentNumber, double totalNetPrice, String articleDescription) {
        this.date = date;
        this.documentNumber = documentNumber;
        this.totalNetPrice = totalNetPrice;
        this.articleDescription = articleDescription;
    }
}
