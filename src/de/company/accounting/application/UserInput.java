package de.company.accounting.application;

import de.company.accounting.presentation.InputForm;
import de.company.accounting.presentation.MyTableModel;

public class UserInput {

    private InputForm inputForm;
    private MyTableModel myTableModel;

    private String amount;

    public String getAmount() {
        return amount;
    }

    public UserInput(InputForm inputForm, MyTableModel myTableModel) {
        this.inputForm = inputForm;
        this.myTableModel = myTableModel;
    }

    public void fetchUserInput() {
        amount = inputForm.getColAmountTextField().getText();
        //accountSoll = inputForm.g

    }

}
