package de.company.accounting.presentation;

import de.company.accounting.data.AccountAdministration;
import de.company.accounting.data.AccountList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class InputForm {

    private JPanel panel;
    private JLabel amount;
    private JLabel documentNumber;
    private JLabel date;
    private JTextField colDescriptionTextField;
    private JLabel description;
    private JButton buchenButton;
    private JTextField colAmountTextField;
    private JTextField toAccTextField;
    private JTextField colDocumentNumberTextField;
    private JTextField colDateTextField;

    private AccountList al = new AccountList();
    private JComboBox accListComboBoxSoll;
    private JComboBox accListComboBoxHaben;
    private JButton kontoErstellenIndividuellButton;
    private JTextField accNumberTextField;
    private JTextField accDescriptionTextField;

    public InputForm() {

        kontoErstellenIndividuellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fillCombos();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void fillCombos() throws IOException {
        String description = accDescriptionTextField.getText();
        int iD = Integer.parseInt(accNumberTextField.getText());
        String idString = String.valueOf(iD) + " " + description;
        accListComboBoxSoll.addItem(idString);
        accListComboBoxHaben.addItem(idString);

        //creating account
        AccountAdministration.createAccount(iD, description);

        try {
            al.readFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //show only sorted account list
        al.getAccList().put(iD, description); //normal list
        al.sortAccList(); //new sorted list
        System.out.println(al.sortAccList());

        try {
            al.writeSortedFile();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        accListComboBoxSoll.removeAllItems();
        accListComboBoxHaben.removeAllItems();
        accListLoading();
    }

    public void accListLoading() {
        File file;
        file = new File("saveData.txt");
        Scanner s = null;

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (s.hasNext()) {
            String string = s.nextLine();
            if (string != null) {
                accListComboBoxSoll.addItem(string.concat(" "));
                accListComboBoxHaben.addItem(string.concat(" "));
            }
        }
    }


    public JPanel getPanel() {
        return panel;
    }

    public void accListLoadingAll() {
        File file;
        file = new File("saveData.txt");
        Scanner s = null;

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (s.hasNext()) {
            String string = s.nextLine();
            if (string != null) {
                accListComboBoxSoll.addItem(string.concat(" "));
                accListComboBoxHaben.addItem(string.concat(" "));
            }
        }
    }
}