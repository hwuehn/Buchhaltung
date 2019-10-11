package de.company.accounting.data;

import de.company.accounting.application.AccountAdministration;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Account {

    private AccountAdministration accountAdministration;

    private Integer accountID;
    private String accountName;
    private double initialBalance;

    public Integer getAccountID() {
        return accountID;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setInitialBalance() {
        initialBalance = 0.00;
    }

    public Account(Integer iD, String description) {
        if (accountAdministration.getAccList().containsKey(iD))
            accountID = iD;
        if (accountAdministration.getAccList().containsValue(description))
            accountName = description;
        setInitialBalance();
        System.out.print("Kontoerstellung:");
        System.out.println(output());
    }

    public String output() {
        return MessageFormat.format(" [Kontonummer = {0}, Bezeichnung = {1}, AB = {2}]", accountID, accountName, initialBalance);
    }

    public static String outputAccountBookings(List<AccountingRecord> bookings, Account account) {
        Stream<AccountingRecord> bookingRecord = bookings.stream().filter(b -> isSameAccount(b.getAccount(),account) );
        String diesesKonto = "K: " + account.getAccountID() + "    " + account.initialBalance;
        String gegenKonten = bookingRecord.reduce("", contraAccountRecord(bookings), String::concat);
        return diesesKonto+ "\n" + gegenKonten;
    }

    private static BiFunction<String, AccountingRecord, String> contraAccountRecord(List<AccountingRecord> bookings) {
        return (acc, b1) -> {
            AccountingRecord b2 = getBuchungsZwilling(bookings, b1).get();
            return acc + b2.getAccount() + "   " + b1 + "\n";
        };
    }

    private static Optional<AccountingRecord> getBuchungsZwilling(List<AccountingRecord> buchungen, AccountingRecord b) {
        return buchungen.stream().filter(bb -> isSameBuchungsId(b, bb) && isNotSameAccount(b, bb)).findFirst();
    }

    private static boolean isSameBuchungsId(AccountingRecord b, AccountingRecord bb) {
        return bb.getBookingID() == b.getBookingID();
    }

    private static boolean isNotSameAccount(AccountingRecord b, AccountingRecord bb) {
        return b.getAccount() != bb.getAccount();
    }
    private static boolean isSameAccount(Object k, Account k2) {
        return k == k2.getAccountID();
    }
//
//    @Override
//    public String toString() {
//        return accountName;
////		return MessageFormat.format("Soll       {0} {1}        Haben \n" +
////                        "----------------------------------------- \n" +
////                        "AB             {2} |                      \n" +
////                        "                    |                     \n" +
////				        "                    |                     \n" +
////						"                    |                     \n" ,
////               accountID, accountName, formattedDoubleString(initialBalance));
//    }
//
//    public static String formattedDoubleString(double wert) {
//        DecimalFormat newFormat = new DecimalFormat("0.00");
//        return newFormat.format(wert);
//    }
}
