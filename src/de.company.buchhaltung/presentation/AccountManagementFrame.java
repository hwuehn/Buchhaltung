package presentation;

import application.KontoVerwaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                KontoVerwaltung kv = new KontoVerwaltung();
                String bezeichnung = accDescriptionTextField.getText();
                int id = Integer.parseInt(accNumberTextField.getText());
                kv.createKonto(bezeichnung, id);
                String idString = String.valueOf(id) + " " + bezeichnung;
                accListComboBox.addItem(idString);

            }
        });
    }

    public JPanel getAccountManagementFrame() {
        return accountManagementFrame;
    }
}

