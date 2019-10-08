package de.company.accounting.data;

import de.company.accounting.application.AccountAdministration;
import de.company.accounting.presentation.InputForm;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.List;

public class AccountingRecord {

    private Account account;
    private List<Position> positions;
    private Site site;
    private int bookingID;

    public boolean textEqualsAccount(JTextField textField) {
        if (AccountAdministration.getAccList().containsKey(textField.getText()));
        return true;
    }

    public void readFromTextField(JTextField textField) {
        String text = textField.getText();
        // accID
        text = text.substring(0,4);

        // vergleich mit accList
        if (AccountAdministration.getAccList().containsKey(text)){
            // texteingabe = account


        };



    }

    public AccountingRecord(JTextField account, List<Position> positions, Site site, int bookingID) {
        if (textEqualsAccount(account))
        this.account = account;
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
