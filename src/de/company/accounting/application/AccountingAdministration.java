package de.company.accounting.application;

import de.company.accounting.data.Account;
import de.company.accounting.data.AccountingRecord;
import de.company.accounting.data.Position;
import de.company.accounting.presentation.MyTableModel;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static de.company.accounting.data.Site.HABEN;
import static de.company.accounting.data.Site.SOLL;

public class AccountingAdministration {

    private List<AccountingRecord> bookings = new ArrayList<>();
    private List<Object> input = new ArrayList<>();

    public AccountingAdministration() {
    }

    public void createUserInputList(Double amount, Object accountSoll, Integer documentNumber, LocalDate date,
                                      Object accountHaben, String description) {
        input.add(amount);
        input.add(accountSoll);
        input.add(documentNumber);
        input.add(date);
        input.add(accountHaben);
        input.add(description);
    }

    //TODO needed is code for adding a row and not cells
    public void addInputListToRow(MyTableModel myTableModel) {
        myTableModel.setValueAt(input,0,1);
    }

    public List<AccountingRecord> getBookings() {
        return bookings;
    }

    public void bookings(Account accountSoll, Account accountHaben, List<Position> positions) {
        int max = bookings.stream().map( b -> b.getBookingID()).mapToInt( i -> i).max().orElse(0);
        System.out.println(max);
        AccountingRecord ar1 = new AccountingRecord(accountSoll, positions, SOLL, max + 1);
        AccountingRecord ar2 = new AccountingRecord(accountHaben, positions, HABEN, max + 1);
        bookings.add(ar1);
        bookings.add(ar2);
    }

    @Override
    public String toString() {
        String book=  bookings.stream().reduce("", (acc,bs) -> acc + bs.toString()+"\n", String::concat );
        return MessageFormat.format("Buchungen:\n{0}", book);
    }

    public static String formattedDoubleString(double wert) {
        DecimalFormat newFormat = new DecimalFormat("#.00");
        return newFormat.format(wert);
    }



}
