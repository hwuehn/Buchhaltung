package de.company.accounting.application;

import de.company.accounting.presentation.InputForm;
import de.company.accounting.presentation.MyTableModel;

public class UserInput {

    private InputForm inputForm;
    private MyTableModel myTableModel;

    private Object amount;
    private Object accountSoll;
    private Object documentNumber;
    private Object date;
    private Object accountHaben;
    private Object description;

    public String getAmount() {
        return String.valueOf(amount);
    }

    public UserInput(InputForm inputForm, MyTableModel myTableModel) {
        this.inputForm = inputForm;
        this.myTableModel = myTableModel;
    }

    public void fetchUserInput() {
        amount = inputForm.getColAmountTextField().getText();
        accountSoll = inputForm.getAccListComboBoxSoll();
        documentNumber = inputForm.getColDocumentNumberTextField().getText();
        date = inputForm.getColDateTextField().getText();
        accountHaben = inputForm.getAccListComboBoxHaben();
        description = inputForm.getColDescriptionTextField().getText();
    }

}
