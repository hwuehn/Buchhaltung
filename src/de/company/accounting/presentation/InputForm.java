package de.company.accounting.presentation;

import de.company.accounting.application.AccountAdministration;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class InputForm {

    private JPanel panel;
    private JTextField amount;
    private JTextField documentNumber;
    private JTextField date;
    private JTextField colDescriptionTextField;
    private JTextField description;
    private JButton buchenButton;
    private JTextField colAmountTextField;
    private JTextField toAccTextField;
    private JTextField colDocumentNumberTextField;
    private JTextField colDateTextField;

    private AccountAdministration al ;
    private JComboBox accListComboBoxSoll;
    private JComboBox accListComboBoxHaben;

    private JButton kontoErstellenIndividuellButton;
    private JTextField accNumberTextField;
    private JTextField accDescriptionTextField;
    public JTextField textField1;
    public JTextField textField2;
    public JTable table1;

    public InputForm(AccountAdministration accountAdministration) {
        al= accountAdministration;
        kontoErstellenIndividuellButton.addActionListener(this::createAccount);
    }

    private void createAccount(ActionEvent actionEvent)  {
        String description = accDescriptionTextField.getText();
        int iD = Integer.parseInt(accNumberTextField.getText());
        al.load();
        al.append(iD, description);
        fillCombos(al.getSortedList());
    }

    public void fillCombos(List<String> list)  {
        accListComboBoxSoll.removeAllItems();
        accListComboBoxHaben.removeAllItems();
        for (String accName : list) {
            accListComboBoxSoll.addItem(accName);
            accListComboBoxHaben.addItem(accName);
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}