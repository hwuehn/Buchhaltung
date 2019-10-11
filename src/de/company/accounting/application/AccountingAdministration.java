package de.company.accounting.application;

import de.company.accounting.data.AccountingRecord;
import de.company.accounting.data.Site;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.*;

public class AccountingAdministration {

    private UserInput userInput;

    public List<AccountingRecord> getBookings() {
        return bookings;
    }

    private List<AccountingRecord> bookings = new ArrayList<>();
    private List<Vector> bookList = new ArrayList<>();

    public AccountingAdministration() {
    }

    public void storeInput(Vector<Object> input) {
        bookList.add(input);
    }

    public void createUserInputListAndBook(UserInput userInput) {
        Vector<Object> input = getObjects(userInput);
        bookings(userInput);
        addRowAndUpdate(userInput, input);
    }

    private void addRowAndUpdate(UserInput userInput, Vector<Object> input) {
        userInput.getMyTableModel().addRow(input);
        userInput.getMyTableModel().fireTableRowsUpdated(0, userInput.getMyTableModel().getRowCount());
    }

    private Vector<Object> getObjects(UserInput userInput) {
        Vector<Object> input = new Vector<>();

        input.add(userInput.getAccountingRecordIDCounter().getCounter());
        input.add(userInput.getAmount());
        input.add(userInput.getAccountSoll());
        input.add(userInput.getDocumentNumber());
        input.add(userInput.getDate());
        input.add(userInput.getAccountHaben());
        input.add(userInput.getDescription());

        storeInput(input);

        return input;
    }

    public void bookings(UserInput userInput) {

        int max = bookings.stream().map(b -> b.getBookingID()).mapToInt(i -> i).max().orElse(0);
        System.out.println(max);

        AccountingRecord ar1 = new AccountingRecord( userInput.getAccountSoll(), userInput.getAccountingRecordIDCounter(),
                userInput.getAmount(),
                userInput.getDocumentNumber(), userInput.getDate(),
                userInput.getDescription(), Site.SOLL, max + 1);

        AccountingRecord ar2 = new AccountingRecord( userInput.getAccountHaben(), userInput.getAccountingRecordIDCounter(),
                userInput.getAmount(),
                userInput.getDocumentNumber(), userInput.getDate(),
                userInput.getDescription(), Site.HABEN, max + 1);

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
