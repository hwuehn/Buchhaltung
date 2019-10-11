package de.company.accounting.application;

import de.company.accounting.presentation.MyTableModel;

import java.time.LocalDate;

public class UserInput {
    private final AccountingRecordIDCounter accountingRecordIDCounter;
    private final Double amount;
    private final Object accountSoll;
    private final Integer documentNumber;
    private final LocalDate date;
    private final Object accountHaben;
    private final String description;
    private final MyTableModel myTableModel;

    public UserInput(AccountingRecordIDCounter accountingRecordIDCounter, Double amount, Object accountSoll,
                     Integer documentNumber, LocalDate date, Object accountHaben, String description,
                     MyTableModel myTableModel) {

        this.accountingRecordIDCounter = accountingRecordIDCounter;
        this.amount = amount;
        this.accountSoll = accountSoll;
        this.documentNumber = documentNumber;
        this.date = date;
        this.accountHaben = accountHaben;
        this.description = description;
        this.myTableModel = myTableModel;
    }

    public AccountingRecordIDCounter getAccountingRecordIDCounter() {
        return accountingRecordIDCounter;
    }

    public Double getAmount() {
        return amount;
    }

    public Object getAccountSoll() {
        return accountSoll;
    }

    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public Object getAccountHaben() {
        return accountHaben;
    }

    public String getDescription() {
        return description;
    }

    public MyTableModel getMyTableModel() {
        return myTableModel;
    }
}
