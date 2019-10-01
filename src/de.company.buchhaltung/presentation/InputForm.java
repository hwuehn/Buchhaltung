package presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField textField6;

    public InputForm() {
        kontoButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Kontoverwaltung");
                frame.setContentPane(new presentation.AccountManagementFrame().getAccountManagementFrame());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setLocation(600,200);



            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
