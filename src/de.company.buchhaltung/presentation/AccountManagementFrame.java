package presentation;

import application.KontoVerwaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class AccountManagementFrame {
    private JPanel accountManagementFrame;

    public JComboBox getAccListComboBox() {
        return accListComboBox;
    }

    private JComboBox accListComboBox;
    private JButton kontoErstellenIndividuellButton;
    private JButton kontenplanHinzufügenButton;
    private JComboBox accPlanComboBox;
    private JTextField accNumberTextField;
    private JTextField accDescriptionTextField;

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
                kv.createKonto(id, bezeichnung);
                String idString = String.valueOf(id) + " " + bezeichnung;
                accListComboBox.addItem(idString);

            }
        });
    }

    public JPanel getAccountManagementFrame() {
        return accountManagementFrame;
    }
}

