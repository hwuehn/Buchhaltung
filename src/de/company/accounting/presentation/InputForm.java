package de.company.accounting.presentation;

import de.company.accounting.application.AccountAdministration;
import de.company.accounting.application.AccountingAdministration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.time.LocalDate.*;

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
    private JComboBox accListComboBoxSoll;
    private JComboBox accListComboBoxHaben;
    private JButton kontoErstellenIndividuellButton;
    private JTextField accNumberTextField;
    private JTextField accDescriptionTextField;
    public JTextField textField1;
    public JTable table1;

    public InputForm(AccountAdministration accountAdministration, AccountingAdministration accountingAdministration, MyTableModel myTableModel) {
        this.accountAdministration = accountAdministration;
        this.accountingAdministration = accountingAdministration;
        this.myTableModel = myTableModel;
        kontoErstellenIndividuellButton.addActionListener(this::createAccount);
        buchenButton.addActionListener(this::fetchUserInput);
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

    private void fetchUserInput(ActionEvent actionEvent) {
        Double amount = parseDouble(getColAmountTextField().getText());
        Object accountSoll = getAccListComboBoxSoll();
        Integer documentNumber = parseInt(getColDocumentNumberTextField().getText());
        LocalDate date = parse(getColDateTextField().getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        Object accountHaben = getAccListComboBoxHaben();
        String description = getColDescriptionTextField().getText();
        accountingAdministration.createUserInputList(amount,accountSoll,documentNumber,date, accountHaben,description);
        //TODO
    }

    private void createAccount(ActionEvent actionEvent)  {
        String description = accDescriptionTextField.getText();
        int iD = parseInt(accNumberTextField.getText());
        accountAdministration.load();
        accountAdministration.append(iD, description);
        //fillCombos(accountAdministration.getSortedList());
        fillCombos2(accountAdministration.sortAccList());
    }

    public void fillCombos(List<String> list)  {
        accListComboBoxSoll.removeAllItems();
        accListComboBoxHaben.removeAllItems();
        for (String accName : list) {
            accListComboBoxSoll.addItem(accName);
            accListComboBoxHaben.addItem(accName);
        }
    }

    public void fillCombos2(Map<Integer, String> map) {
        accListComboBoxSoll.removeAllItems();
        accListComboBoxHaben.removeAllItems();
        map.forEach((k,v) -> accListComboBoxSoll.addItem(k + " " + v));
        map.forEach((k,v) -> accListComboBoxHaben.addItem(k + " " + v));
    }

    public JPanel getPanel() {
        return panel;
    }



}