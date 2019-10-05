package presentation;

import data.AccountList;
import data.AutocompleteJComboBox;
import data.StringSearchable;

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
    private JButton gegenkontoButton;
    private JLabel documentNumber;
    private JLabel date;
    private JTextField descriptionTextField;
    private JLabel description;
    private JButton buchenButton;
    private JTextField textField2;
    private JTextField toAccTextField;
    private JTextField textField4;
    private JTextField textField5;

    public JComboBox accListComboBoxSoll;
    public JComboBox accListComboBoxHaben;
    private JButton kontoErstellenIndividuellButton;
    private JTextField accNumberTextField;
    private JTextField accDescriptionTextField;
    private AccountList al = new AccountList();
    int counter = 0;

    public InputForm() throws IOException {
            kontoErstellenIndividuellButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String bezeichnung = accDescriptionTextField.getText();
                    int id = Integer.parseInt(accNumberTextField.getText());
                    String idString = String.valueOf(id) + " " + bezeichnung;
                    accListComboBoxSoll.addItem(idString);
                    accListComboBoxHaben.addItem(idString);

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

                    accListComboBoxSoll.removeAllItems();
                    accListComboBoxHaben.removeAllItems();
                    accListLoading();
                }
            });
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //StringSearchable searchable = new StringSearchable(myWords);
        //AutocompleteJComboBox combo = new AutocompleteJComboBox(searchable);
    }
}
