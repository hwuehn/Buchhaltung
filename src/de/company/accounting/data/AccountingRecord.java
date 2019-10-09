package de.company.accounting.data;

import de.company.accounting.application.AccountingAdministration;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.List;

public class AccountingRecord {

    AccountingAdministration accountingAdministration = new AccountingAdministration();
    private Account account;
    private List<Position> positions;
    private Site site;
    private int bookingID;

    public AccountingRecord(AccountingAdministration accountingAdministration, JTextField account, List<Position> positions, Site site, int bookingID) {
        this.accountingAdministration = accountingAdministration;
        //if (textEqualsAccount(account))
        //this.account = account;
        this.positions = positions;
        this.site = site;
        this.bookingID = bookingID;
    }

    public Account getAccount() {
        return account;
    }

    public int getBookingID() {
        return bookingID;
    }

    public Double gesamtWert(){
        return positions.stream().map(p -> p.getTotalNetPrice()).reduce(0d ,(acc, e) -> acc + e);
    }

    public String toString() {
        return MessageFormat.format("Buchung: {0} {1} {2} {3} ", account.getAccountID(), account.getAccountName(), formattedDoubleString(gesamtWert()),site);
    }

    public static String formattedDoubleString(double wert) {
        DecimalFormat newFormat = new DecimalFormat("#.00");
        return newFormat.format(wert);
    }
}
//package de.company.accounting.data;
//
//import java.text.DecimalFormat;
//import java.text.MessageFormat;
//import java.util.List;
//
//
//public class BuchungsSatz {
//
//    private final Konto konto;
//    private final List<Position> positions;
//    private final Site site;
//    private final int buchungsid;
//
//    public Konto getKonto() {
//        return konto;
//    }
//    public List<Position> getPositions() {
//        return positions;
//    }
//
//    public int getBuchungsid() {
//        return buchungsid;
//    }
//
//    public BuchungsSatz(Konto konto, List<Position> positions, Site site, int buchungsid) {
//        this.konto = konto;
//        this.positions = positions;
//        this.site = site;
//        this.buchungsid = buchungsid;
//    }
//
//    public Double gesamtWert(){
//        return positions.stream().map(p -> p.getGesamtpreisNetto()).reduce(0d ,(acc,e) -> acc + e);
//    }
//
//    public String toString() {
//        return MessageFormat.format("Buchung: {0} {1} {2} {3} ", konto.getKontoId(), konto.getKontoBezeichnung(), formattedDoubleString(gesamtWert()),site);
//    }
//
//    public static String formattedDoubleString(double wert) {
//        DecimalFormat newFormat = new DecimalFormat("#.00");
//        return newFormat.format(wert);
//    }
//}