package de.company.accounting.data;

import de.company.accounting.application.UserInput;

import java.time.LocalDate;

//class fetches input for accountRecord
public class Position {

    UserInput userInput;
    private final LocalDate date;
    private final int documentNumber;

    private final double totalNetPrice;
    private final String articleDescription;

    public double getTotalNetPrice() {
        return totalNetPrice;
    }
    public LocalDate getDate() { return date; }

    public Position() {
        this.date = userInput.getDate();
        this.documentNumber = userInput.getDocumentNumber();
        this.totalNetPrice = userInput.getAmount();
        this.articleDescription = userInput.getDescription();
    }
}
