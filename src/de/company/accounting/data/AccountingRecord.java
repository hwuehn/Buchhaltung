package de.company.accounting.data;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.List;

public class AccountingRecord {

    private Account account;
    private List<Position> positions;
    private Site site;
    private int bookingID;

    public AccountingRecord(Account account, List<Position> positions, Site site, int bookingID) {
        this.account = account;
        this.positions = positions;
        this.site = site;
        this.bookingID = bookingID;
    }

    public Account getAccount() {
        return account;
    }

    public Double gesamtWert(){
        return positions.stream().map(p -> p.getGesamtpreisNetto()).reduce(0d ,(acc,e) -> acc + e);
    }

    public String toString() {
        return MessageFormat.format("Buchung: {0} {1} {2} {3} ", account.getAccountID(), account.getAccountName(), formattedDoubleString(gesamtWert()),site);
    }

    public static String formattedDoubleString(double wert) {
        DecimalFormat newFormat = new DecimalFormat("#.00");
        return newFormat.format(wert);
    }
}
