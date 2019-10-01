package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AccountList {

    public void readAccList() {
        Scanner s = null;
        Map<String,String> accList = new HashMap<>();

        try {
            File file = new File("saveData.txt");
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNext()) {
            String key = s.next();
            String value = s.next();
            if (key != null) {
                accList.put(key, value);
                System.out.println(accList);
                //accListComboBox.addItem(string.concat(" "));
            }
        }
    }

}
