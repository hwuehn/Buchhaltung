package de.company.accounting.data;

import de.company.accounting.application.AccountingRecordIDCounter;
import de.company.accounting.application.UserInput;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class AccountingRecord {

    UserInput userInput;
    private  Object account;
    private  AccountingRecordIDCounter counter;
    private  Double amount;
    private  Integer number;
    private  LocalDate date;
    private  String text;
    private  Site site;
    private  int bookingID;

    public AccountingRecord(Object account, AccountingRecordIDCounter counter, Double amount, Integer number, LocalDate date, String text , Site site, int bookingID) {
        this.account = account;
        this.counter = counter;
        this.amount = amount;
        this.number = number;
        this.date = date;
        this.text = text;
        this.site = site;
        this.bookingID = bookingID;
    }

    public Object getAccount() {
        return account;
    }

    public int getBookingID() {
        return bookingID;
    }

//    public Double totalValue(){
//        return positions.stream().map(p -> p.getTotalNetPrice()).reduce(0d ,(acc, e) -> acc + e);
//    }

//        public String toString() {
//        return MessageFormat.format("Buchung: {0} {1} {2} {3} ", account.getAccountID(), account.getAccountName(), formattedDoubleString(totalValue()),site);
//    }

    public static String formattedDoubleString(double wert) {
        DecimalFormat newFormat = new DecimalFormat("#.00");
        return newFormat.format(wert);
    }
}