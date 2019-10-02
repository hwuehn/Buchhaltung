package presentation;

import application.KontoVerwaltung;
import data.AccountList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AccountManagementFrame {

    private JPanel accountManagementFrame;
    private JComboBox accListComboBox;
    private JButton kontoErstellenIndividuellButton;
    private JTextField accNumberTextField;
    private JTextField accDescriptionTextField;
    private JButton kontenLadenButton;

    public AccountManagementFrame() {
        kontoErstellenIndividuellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KontoVerwaltung kv = null;
                try {
                    kv = new KontoVerwaltung();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                String bezeichnung = accDescriptionTextField.getText();
                int id = Integer.parseInt(accNumberTextField.getText());
                try {
                    kv.createKonto(id, bezeichnung);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                String idString = String.valueOf(id) + " " + bezeichnung;
                accListComboBox.addItem(idString);

            }
        });
        kontenLadenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fillAccListComboBox();
            }
        });
    }

    public JPanel getAccountManagementFrame() {
        return accountManagementFrame;
    }

    public void fillAccListComboBox() {
        AccountList.scanFile();
        while (AccountList.getS().hasNext()) {
            String string = AccountList.getS().nextLine();
            if (string != null) {
                accListComboBox.addItem(string.concat(" "));
            }
        }
    }
}

