package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class AccountList {

    private Map<Integer, String> accList = new HashMap<Integer, String>();
    private Scanner s = null;

    public void readAccListFromFileAndPutPairsInHashMap() {
        scanFile();
        storePairs(s, accList);
    }

    private static void storePairs(Scanner s, Map<Integer, String> accList) {
        while (s.hasNext()) {
            int key = Integer.parseInt(s.next());
            String value = s.next();
            if (key != 0) {
                accList.put(key, value);
            }
        }
    }
    private void scanFile() {
        try {
            File file = new File("saveData.txt");
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<Object, Object> sortAccPairsInHashMap() {
        Map<Object, Object> sortedByKey = accList.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey())
                .collect(toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedByKey;
    }

    public void overwriteAccListWithSortedHashMap() {

    }

//    public void fillAccListInComboBoxWithSortedHashMap() {
//
//        try {
//            File file = new File("saveData.txt");
//            s = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        while (s.hasNext()) {
//            String string = s.nextLine();
//            if (string != null) {
//                accListComboBox.addItem(string.concat(" "));
//            }
//        }
//    }
}
