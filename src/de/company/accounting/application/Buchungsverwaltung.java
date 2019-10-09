//package de.company.accounting.application;
//
//import de.company.accounting.data.*;
//
//import javax.swing.*;
//import java.text.DecimalFormat;
//import java.text.MessageFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Buchungsverwaltung {

    //old
//    private List<BuchungsSatz> buchungen=new ArrayList<>();
    //new
    //private List<AccountingRecord> bookings = new ArrayList<>();

    //new
//    public void bookings(JTextField toAccTextField, JTextField accTextField, List<Position> positions) {
//        int max = bookings.stream().map( b -> b.getBookingID()).mapToInt( i -> i).max().orElse(0);
//        System.out.println(max);
//        AccountingRecord ar1 = new AccountingRecord(toAccTextField, positions, Site.SOLL, max + 1);
//        AccountingRecord ar2 = new AccountingRecord(accTextField, positions, Site.HABEN, max + 1);
//        bookings.add(ar1);
//        bookings.add(ar2);
//    }

    //old
//    public void buchen(Konto kontoSoll, Konto gegenKonto, List<Position> positions) {
//        int max = buchungen.stream().map(b -> b.getBuchungsid()).mapToInt(i -> i).max().orElse(0);
//        System.out.println(max);
//        BuchungsSatz bs1 = new BuchungsSatz(kontoSoll, positions, Seite.SOLL,max +1);
//        BuchungsSatz bs2 = new BuchungsSatz(gegenKonto, positions, Seite.HABEN,max +1);
//        buchungen.add(bs1);
//        buchungen.add(bs2);
//    }

    //old
//    @Override
//    public String toString() {
//        String buchus=  buchungen.stream().reduce("", (acc,bs) -> acc + bs.toString()+"\n", String::concat );
//        return MessageFormat.format("Buchungen:\n{0}", buchus);
//    }

    //new
//    @Override
//    public String toString() {
//        String book=  bookings.stream().reduce("", (acc,bs) -> acc + bs.toString()+"\n", String::concat );
//        return MessageFormat.format("Buchungen:\n{0}", book);
//    }
//
//    public static String formattedDoubleString(double wert) {
//        DecimalFormat newFormat = new DecimalFormat("#.00");
//        return newFormat.format(wert);
//    }
//}
