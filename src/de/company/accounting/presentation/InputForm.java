package de.company.accounting.presentation;

import de.company.accounting.application.AccountAdministration;
import de.company.accounting.application.AccountingAdministration;
import de.company.accounting.application.AccountingRecordIDCounter;
import de.company.accounting.application.UserInput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.time.LocalDate.parse;

public class InputForm {

    private JPanel panel;

    private JTextField colDescriptionTextField;
    private JButton buchenButton;
    private JTextField colAmountTextField;
    private JTextField toAccTextField;
    private JTextField colDocumentNumberTextField;
    private JTextField colDateTextField;
    private AccountAdministration accountAdministration;
    private AccountingAdministration accountingAdministration;
    private MyTableModel myTableModel;
    private InputForm inputForm;
    private JComboBox accListComboBoxSoll;
    private JComboBox accListComboBoxHaben;
    private JButton kontoErstellenIndividuellButton;
    private JTextField accNumberTextField;
    private JTextField accDescriptionTextField;
    public JTextField textField1;
    public JTable table1;
    private JButton testButton;

    public InputForm(AccountAdministration accountAdministration, AccountingAdministration accountingAdministration,
                     MyTableModel myTableModel) {

        this.accountAdministration = accountAdministration;
        this.accountingAdministration = accountingAdministration;
        this.myTableModel = myTableModel;
        kontoErstellenIndividuellButton.addActionListener(this::createAccount);
        buchenButton.addActionListener(this::fetchAndSetUserInput);
        testButton.addActionListener(this::testAll);

    }

    public JTextField getColAmountTextField() {
        return colAmountTextField;
    }
    public Object getAccListComboBoxSoll() {
        return accListComboBoxSoll.getSelectedItem();
    }
    public JTextField getColDocumentNumberTextField() {
        return colDocumentNumberTextField;
    }
    public JTextField getColDateTextField() {
        return colDateTextField;
    }
    public Object getAccListComboBoxHaben() {
        return accListComboBoxHaben.getSelectedItem();
    }
    public JTextField getColDescriptionTextField() {
        return colDescriptionTextField;
    }

    public JComboBox setAccListComboBoxSoll(JComboBox accListComboBoxSoll) {
        this.accListComboBoxSoll = accListComboBoxSoll;
        return accListComboBoxSoll;
    }
    public JComboBox setAccListComboBoxHaben(JComboBox accListComboBoxHaben) {
        this.accListComboBoxHaben = accListComboBoxHaben;
        return accListComboBoxHaben;
    }

    private void fetchAndSetUserInput(ActionEvent actionEvent) {

        fetchAndSet();
    }

    private void fetchAndSet() {
        Double amount = parseDouble(getColAmountTextField().getText());
        Object accountSoll = getAccListComboBoxSoll();
        Integer documentNumber = parseInt(getColDocumentNumberTextField().getText());
        LocalDate date = parse(getColDateTextField().getText(), DateTimeFormatter.ofPattern("ddMMyyyy"));
        Object accountHaben = getAccListComboBoxHaben();
        String description = getColDescriptionTextField().getText();
        accountingAdministration.createUserInputList(new UserInput(new AccountingRecordIDCounter(), amount, accountSoll, documentNumber, date, accountHaben, description, myTableModel));
        clearInputFields();
    }

    private void createAccount(ActionEvent actionEvent)  {
        String description = accDescriptionTextField.getText();
        int iD = parseInt(accNumberTextField.getText());
        accountAdministration.load();
        accountAdministration.append(iD, description);
        fillCombos2(accountAdministration.sortAccList());
    }

    public void fillCombos2(Map<Integer, String> map) {
        accListComboBoxSoll.removeAllItems();
        accListComboBoxHaben.removeAllItems();
        map.forEach((k,v) -> accListComboBoxSoll.addItem(k + " " + v));
        map.forEach((k,v) -> accListComboBoxHaben.addItem(k + " " + v));
    }

    public void clearInputFields() {
        getColAmountTextField().setText("");
        getColDocumentNumberTextField().setText("");
        getColDateTextField().setText("");
        getColDescriptionTextField().setText("");
    }

    public JPanel getPanel() {
        return panel;
    }

    private void test2() {
        getColAmountTextField().setText("500.00");
        setAccListComboBoxSoll(accListComboBoxSoll);
        getColDocumentNumberTextField().setText("98765");
        getColDateTextField().setText("31122018");
        setAccListComboBoxHaben(accListComboBoxHaben);
        getColDescriptionTextField().setText("Foo");
        fetchAndSet();
    }

    private void test() {
        getColAmountTextField().setText("33333.00");
        setAccListComboBoxSoll(accListComboBoxSoll);
        getColDocumentNumberTextField().setText("4321");
        getColDateTextField().setText("10052017");
        setAccListComboBoxHaben(accListComboBoxHaben);
        getColDescriptionTextField().setText("Buzzzze");
        fetchAndSet();
    }

    private void testAll(ActionEvent actionEvent) {
        for (int i = 0; i < 11; i++) {
            test();
            test2();
        }
    }
}