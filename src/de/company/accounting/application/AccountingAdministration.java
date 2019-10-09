package de.company.accounting.application;

import de.company.accounting.presentation.InputForm;
import de.company.accounting.presentation.MyTableModel;

import java.util.ArrayList;
import java.util.List;

public class AccountingAdministration {

    //number, amount, accountSoll, documentNumber, date, accountHaben, description
    //Integer, double, Integer, Integer, LocalDate, Integer, String
    private List<String> accRecLine = new ArrayList<>();
    private InputForm inputForm;
    private MyTableModel myTableModel;
    private String number, amount, accountSoll, documentNumber, date, accountHaben, description;

    public AccountingAdministration() {
    }

    public void setAmount() {
        this.amount = inputForm.getColAmountTextField().getText();
        System.out.println(amount);
    }
}
