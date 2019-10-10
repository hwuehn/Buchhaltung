package de.company.accounting.application;

import de.company.accounting.data.Account;
import de.company.accounting.data.AccountingRecord;
import de.company.accounting.data.Position;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static de.company.accounting.data.Site.HABEN;
import static de.company.accounting.data.Site.SOLL;

public class AccountingAdministration {

    private String number, amount, accountSoll, documentNumber, date, accountHaben, description;
    private List<AccountingRecord> bookings = new ArrayList<>();

    public AccountingAdministration() {
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
