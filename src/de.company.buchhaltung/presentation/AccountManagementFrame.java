package presentation;

import application.KontoVerwaltung;
import data.AccountList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AccountManagementFrame {

    private JPanel accountManagementFrame;
    public JComboBox accListComboBox;
    private JButton kontoErstellenIndividuellButton;
    private JTextField accNumberTextField;
    private JTextField accDescriptionTextField;
    private JButton kontenLadenButton;
    private AccountList al = new AccountList();
    int counter = 0;

    public AccountManagementFrame() throws IOException {
        kontoErstellenIndividuellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bezeichnung = accDescriptionTextField.getText();
                int id = Integer.parseInt(accNumberTextField.getText());
                String idString = String.valueOf(id) + " " + bezeichnung;
                accListComboBox.addItem(idString);

                try {
                    al.readFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


                al.getAccList().put(id, bezeichnung);
                System.out.println(al.getAccList());
                al.sortAccList();
                System.out.println(al.sortAccList());

                try {
                    al.writeSortedFile();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

                accListComboBox.removeAllItems();
                accListLoading();

            }
        });

        kontenLadenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                File file;
                file = new File("saveData.txt");
                Scanner s = null;

                if(!file.exists()){
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


                // counter == 0 means no listloading twice
                if (counter == 0) {
                    while (s.hasNext()) {
                        String string = s.nextLine();
                        if (string != null) {
                            accListComboBox.addItem(string.concat(" "));
                            counter++;
                        }
                    }
                }
            }
        });
    }

    public void accListLoading() {
        File file;
        file = new File("saveData.txt");
        Scanner s = null;

        if(!file.exists()){
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
                accListComboBox.addItem(string.concat(" "));
            }
        }

    }

    public JPanel getAccountManagementFrame() {
        return accountManagementFrame;
    }
}

