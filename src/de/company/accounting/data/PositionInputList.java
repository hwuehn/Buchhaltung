package de.company.accounting.data;

import de.company.accounting.application.UserInput;

import java.time.LocalDate;

public class PositionInputList {

    UserInput userInput;
    private final LocalDate date;
    private final int documentNumber;

    private final double totalNetPrice;
    private final String articleDescription;

    public double getTotalNetPrice() {
        return totalNetPrice;
    }
    public LocalDate getDate() { return date; }

    public PositionInputList() {
        this.date = userInput.getDate();
        this.documentNumber = userInput.getDocumentNumber();
        this.totalNetPrice = userInput.getAmount();
        this.articleDescription = userInput.getDescription();
    }
}
