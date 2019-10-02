package presentation;

import application.KontoVerwaltung;
import data.AccountList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class AccountManagementFrame {

    private JPanel accountManagementFrame;

    public void setAccListComboBox(JComboBox accListComboBox) {
        this.accListComboBox = accListComboBox;
    }

    public JComboBox accListComboBox;
    private JButton kontoErstellenIndividuellButton;
    private JTextField accNumberTextField;
    private JTextField accDescriptionTextField;
    private JButton kontenLadenButton;
    private KontoVerwaltung kv = new KontoVerwaltung();
    private AccountList al = new AccountList();

    public AccountManagementFrame() throws IOException {
        kontoErstellenIndividuellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bezeichnung = accDescriptionTextField.getText();
                int id = Integer.parseInt(accNumberTextField.getText());

                try {
                    al.readFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                al.getAccList().put(id, bezeichnung);
                System.out.println(al.getAccList());

                String idString = String.valueOf(id) + " " + bezeichnung;
                accListComboBox.addItem(idString);

            }
        });
        kontenLadenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                File file;
                file = new File("saveData.txt");

                Scanner s = null;
                try {
                    s = new Scanner(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                if(!file.exists()){
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                while (s.hasNext()) {
                    String string = s.nextLine();
                    if (string != null) {
                        accListComboBox.addItem(string.concat(" "));
                    }
                }
            }
        });
    }

    public JPanel getAccountManagementFrame() {
        return accountManagementFrame;
    }


}

