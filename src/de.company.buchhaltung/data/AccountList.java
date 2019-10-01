package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AccountList {

    private Map<String,String> accList = new HashMap<>();
    private Scanner s = null;

    public void readAccListAndPutPairsInHashMap() {
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
            }
        }
    }



}
