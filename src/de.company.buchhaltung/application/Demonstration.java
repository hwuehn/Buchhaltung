package application;

import data.AutocompleteJComboBox;
import data.StringSearchable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Demonstration{

    public static void main(String[] args) throws Exception{
        SwingUtilities.invokeAndWait(new Runnable(){
            @Override
            public void run() {
                List<String> myWords = new ArrayList<String>();
                myWords.add("700");
                myWords.add("1400");
                myWords.add("1600");
                myWords.add("1800");
                myWords.add("4000");
                myWords.add("5000");
                myWords.add("6330");

                StringSearchable searchable = new StringSearchable(myWords);
                AutocompleteJComboBox combo = new AutocompleteJComboBox(searchable);

                JFrame frame = new JFrame();
                frame.add(combo);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
