package presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InputForm {

    private JPanel panel;
    private JLabel amount;
    private JButton gegenkontoButton;
    private JLabel documentNumber;
    private JLabel date;
    private JButton kontoButton2;
    private JTextField descriptionTextField;
    private JLabel description;
    private JButton buchenButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField rowAccTextField;

    public InputForm() {
        kontoButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Kontoverwaltung");
                try {
                    frame.setContentPane(new AccountManagementFrame().getAccountManagementFrame());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                frame.pack();
                frame.setVisible(true);
                frame.setLocation(750,400);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
